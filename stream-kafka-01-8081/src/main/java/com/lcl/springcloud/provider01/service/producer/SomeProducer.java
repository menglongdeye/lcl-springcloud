package com.lcl.springcloud.provider01.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class SomeProducer {
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    public void sendMsg(String message){
        channel.send(MessageBuilder.withPayload(message).build());
    }
}
