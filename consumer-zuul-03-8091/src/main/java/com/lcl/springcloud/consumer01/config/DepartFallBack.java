package com.lcl.springcloud.consumer01.config;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequestMapping("/fallback")
public class DepartFallBack implements DepartService {

    @Override
    public boolean save(Depart depart) {
        log.info("=========执行保存异常服务降级处理========");
        return false;
    }

    @Override
    public List<Depart> findAll() {
        Depart arrays[] = {Depart.builder().id(8091).name("findAll错误8091").build(), Depart.builder().id(8091).name("findAll错误8091").build()};
        return Arrays.asList(arrays);
    }

    @Override
    public Depart query(int id) {
        return Depart.builder().id(8091).name("query错误8091").build();
    }


    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
}
