package com.lcl.springcloud.provider01.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink001.class)
@Slf4j
public class SomeConsumer001 {

    @ServiceActivator(inputChannel = Sink001.CHANNEL_NAME)
    public void printMsg(Object object){
        log.info("stram-test-001========={}",object);
    }

}
