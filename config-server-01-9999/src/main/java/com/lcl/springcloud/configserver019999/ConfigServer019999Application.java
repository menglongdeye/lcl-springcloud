package com.lcl.springcloud.configserver019999;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer019999Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer019999Application.class, args);
    }

}
