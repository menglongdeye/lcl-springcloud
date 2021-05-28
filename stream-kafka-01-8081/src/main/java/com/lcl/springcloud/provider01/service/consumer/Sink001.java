package com.lcl.springcloud.provider01.service.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink001 {
    String CHANNEL_NAME = "stram-test-001";

    @Input(Sink001.CHANNEL_NAME)
    SubscribableChannel input();
}
