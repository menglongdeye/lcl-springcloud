package com.lcl.springcloud.provider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/*   ////////@EnableEurekaClient
 /////////@EnableDiscoveryClient*/
public class Provider018081Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider018081Application.class, args);
    }

}
