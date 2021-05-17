package com.lcl.springcloud.provider01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/depart")
@Slf4j
@RefreshScope
public class DepartController {


    @Value("${test.config}")
    private String testconfig;

    @GetMapping("/findAll")
    public String findAll() throws Exception {
        return testconfig;
    }

}
