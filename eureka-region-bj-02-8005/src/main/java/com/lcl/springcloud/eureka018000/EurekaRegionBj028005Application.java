package com.lcl.springcloud.eureka018000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegionBj028005Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegionBj028005Application.class, args);
    }

}
