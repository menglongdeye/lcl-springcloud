package com.lcl.springcloud.consumer01;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
@Slf4j
public class RouteFilter extends ZuulFilter {
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
        //获取请求路径和user信息
        String requestURI = request.getRequestURI();
        String user = request.getParameter("user");
        //校验逻辑
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
        return null;
    }
}
