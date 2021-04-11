package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.lcl.springcloud.consumer01.service")
public class ConsumerFeign018080Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign018080Application.class, args);
    }

}
