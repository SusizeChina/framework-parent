package com.lhq.cloud.stream.rabbit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqMessageController {
    @Autowired
    private MqMessageProducer mqMessageProducer;

    @GetMapping(value = "/testMq")
    public String testMq(@RequestParam("msg") String msg) {
        mqMessageProducer.sendMsg(msg);
        return "发送成功";
    }
}
