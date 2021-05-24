package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.lcl.springcloud.consumer01.service")
public class ZipkinConsumer018080Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinConsumer018080Application.class, args);
    }

}