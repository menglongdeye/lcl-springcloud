package com.lcl.springcloud.provider01.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Source.class, ProducerSource001.class, ProducerSource002.class})
public class SelfProducer {

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    @Autowired
    @Qualifier(ProducerSource001.CHANNEL_NAME)
    private MessageChannel channel001;

    @Autowired
    @Qualifier(ProducerSource002.CHANNEL_NAME)
    private MessageChannel channel002;

    public void sendMsg(String message){
        Message<String> msg = MessageBuilder.withPayload(message).build();
        channel.send(msg);
        channel001.send(msg);
        channel002.send(msg);
    }
}
