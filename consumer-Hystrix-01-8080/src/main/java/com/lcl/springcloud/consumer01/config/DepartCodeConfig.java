package com.lcl.springcloud.consumer01.config;

import com.lcl.springcloud.consumer01.rule.MyRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartCodeConfig {

    /*@Bean
    @LoadBalanced   //开启客户端负载均衡功能
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }*/

    /*@Bean
    public IRule loadBalanceRule(){
        return new MyRule();
    }*/
}
