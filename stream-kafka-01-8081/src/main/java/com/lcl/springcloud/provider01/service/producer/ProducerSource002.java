package com.lcl.springcloud.provider01.service.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerSource002 {
    String CHANNEL_NAME = "stram-test-002";

    @Output(ProducerSource002.CHANNEL_NAME)
    MessageChannel output();
}
