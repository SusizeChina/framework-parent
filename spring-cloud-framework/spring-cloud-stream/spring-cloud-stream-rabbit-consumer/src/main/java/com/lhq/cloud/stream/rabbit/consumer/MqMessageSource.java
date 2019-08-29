package com.lhq.cloud.stream.rabbit.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lihuiquan
 * 创建通道
 */
public interface MqMessageSource {
    String TEST_IN_PUT = "testInPut";

    @Input(TEST_IN_PUT)
    SubscribableChannel testInPut();
}
