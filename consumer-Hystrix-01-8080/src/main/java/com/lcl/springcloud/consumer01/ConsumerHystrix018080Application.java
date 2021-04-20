package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@EnableFeignClients("com.lcl.springcloud.consumer01.service")
@SpringCloudApplication
public class ConsumerHystrix018080Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrix018080Application.class, args);
    }

}