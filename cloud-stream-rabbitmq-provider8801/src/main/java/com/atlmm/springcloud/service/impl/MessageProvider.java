package com.atlmm.springcloud.service.impl;

import com.atlmm.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author gyh
 * @create 2020-10-24 16:03
 */
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********"+serial);
        return serial;
    }
}
