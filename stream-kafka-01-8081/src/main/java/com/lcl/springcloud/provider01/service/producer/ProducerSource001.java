package com.lcl.springcloud.provider01.service.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerSource001 {
    String CHANNEL_NAME = "stram-test-001";

    @Output(ProducerSource001.CHANNEL_NAME)
    MessageChannel output();
}
