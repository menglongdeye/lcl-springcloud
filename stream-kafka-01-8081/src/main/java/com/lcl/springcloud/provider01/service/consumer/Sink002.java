package com.lcl.springcloud.provider01.service.consumer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Sink002 {
    String CHANNEL_NAME = "stram-test-002";

    @Output(Sink002.CHANNEL_NAME)
    MessageChannel input();
}
