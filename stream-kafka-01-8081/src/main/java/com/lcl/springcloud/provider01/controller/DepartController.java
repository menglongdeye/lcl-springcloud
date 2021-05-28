package com.lcl.springcloud.provider01.controller;

import com.lcl.springcloud.provider01.service.producer.SelfProducer;
import com.lcl.springcloud.provider01.service.producer.SomeProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depart")
@Slf4j
public class DepartController {

    @Autowired
    private SomeProducer producer;
    @Autowired
    private SelfProducer selfProducer;

    @GetMapping("/send")
    public String send() throws Exception {
        producer.sendMsg("stream send message=============");
        return "OK";
    }

    @GetMapping("/sendAll")
    public String sendAll() throws Exception {
        selfProducer.sendMsg("stream send all message=============");
        return "OK";
    }

}
