package com.lhq.cloud.stream.rabbit.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MqMessageSource {

    String TEST_OUT_PUT = "testOutPut";

    @Output(TEST_OUT_PUT)
    MessageChannel testOutPut();

}
