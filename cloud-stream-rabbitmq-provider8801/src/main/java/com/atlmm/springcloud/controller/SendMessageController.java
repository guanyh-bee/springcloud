package com.atlmm.springcloud.controller;

import com.atlmm.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gyh
 * @create 2020-10-24 16:12
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping("/sendMessage")
    public String sendMessage(){

        return messageProvider.send();
    }

}
