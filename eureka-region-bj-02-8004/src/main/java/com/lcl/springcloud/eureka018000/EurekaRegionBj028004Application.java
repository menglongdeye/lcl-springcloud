package com.lcl.springcloud.eureka018000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegionBj028004Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegionBj028004Application.class, args);
    }

}
