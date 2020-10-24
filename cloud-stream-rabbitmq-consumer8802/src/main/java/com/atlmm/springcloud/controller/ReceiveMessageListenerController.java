package com.atlmm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author gyh
 * @create 2020-10-24 16:39
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println("消费者1号------>"+message.getPayload()+"\t"+serverPort);

    }

}
