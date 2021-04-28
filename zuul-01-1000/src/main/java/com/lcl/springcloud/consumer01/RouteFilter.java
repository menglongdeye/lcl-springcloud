package com.lcl.springcloud.consumer01;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
@Slf4j
public class RouteFilter extends ZuulFilter {

    //每秒生成2个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

    @Override
    public String filterType() {
        //路由执行位置：指定路由之前执行
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 路由执行顺序：系统最小值为-3，设置-5说明在所有的系统执行前执行
        return -5;
    }

    //对请求进行过滤的核心逻辑
    @Override
    public boolean shouldFilter() {
        //获取请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = currentContext.getRequest();

        if(!RATE_LIMITER.tryAcquire()){
            log.warn("请求超载，每秒只可访问{}次", RATE_LIMITER.getRate());
            RequestContext.getCurrentContext().setSendZuulResponse(false);
            RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.SC_CONFLICT);
            return false;
        }

        //如果前端传的test为Y，则认为是测试路径，请求到gray-test为gray的服务上
        /*String test = request.getHeader("test");
        if(StringUtils.isNotBlank(test) && "Y".equals(test)){
            RibbonFilterContextHolder.getCurrentContext().add("gray-test","gray");
        }*/


        //获取请求路径和user信息
        String requestURI = request.getRequestURI();
        String user = request.getParameter("user");
        //请求过滤
        if(requestURI.contains("/v2") && StringUtils.isBlank(user)){
            log.warn("访问/v2时用户不能为空");
            //指定当前请求未通过Zuul过滤，默认值为true
            RequestContext.getCurrentContext().setSendZuulResponse(false);
            //设置返回状态码
            RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }



    //校验通过的执行逻辑
    @Override
    public Object run() throws ZuulException {
        log.info("=====校验通过=====");

        String test = RequestContext.getCurrentContext().getRequest().getHeader("test");
        if(StringUtils.isNotBlank(test) && "Y".equals(test)){
            int send = (int) (Math.random() * 100);
            log.info("send==================={}", send);
            if (send >= 0 && send < 10) {
                //也就是百分之10的请求转发到gray-test=gray的服务上去
                RibbonFilterContextHolder.getCurrentContext().add("gray-test","gray");
            } else {
                //百分之90的请求转发到gray-test=running的服务上去
                RibbonFilterContextHolder.getCurrentContext().add("gray-test","running");
            }
        }

        return null;
    }
}
