package com.lcl.springcloud.configserver019999;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerBus029999Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerBus029999Application.class, args);
    }

}
