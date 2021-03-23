package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient //开启服务发现客户端
@EnableEurekaClient
public class Consumer018080Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer018080Application.class, args);
    }

}
