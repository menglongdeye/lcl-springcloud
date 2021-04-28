package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class Zuul011000Application {
    public static void main(String[] args) {
        SpringApplication.run(Zuul011000Application.class, args);
    }

}