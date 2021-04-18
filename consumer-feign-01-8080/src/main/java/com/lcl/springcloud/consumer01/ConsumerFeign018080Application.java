package com.lcl.springcloud.consumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableCircuitBreaker
//@EnableEurekaClient
@EnableFeignClients("com.lcl.springcloud.consumer01.service")
@SpringCloudApplication
public class ConsumerFeign018080Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign018080Application.class, args);
    }

}
