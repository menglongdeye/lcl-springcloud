package com.lcl.springcloud.provider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigProviderBus028081Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigProviderBus028081Application.class, args);
    }

}
