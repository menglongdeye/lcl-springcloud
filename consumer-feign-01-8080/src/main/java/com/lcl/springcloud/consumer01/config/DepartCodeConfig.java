/*
package com.lcl.springcloud.consumer01.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartCodeConfig {

    @Bean
    @LoadBalanced   //开启客户端负载均衡功能
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
*/
