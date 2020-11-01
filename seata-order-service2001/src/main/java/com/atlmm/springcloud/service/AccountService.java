package com.atlmm.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient
public interface AccountService {
    @RequestMapping("/account/decrement")
    void decrement(Long userId,Double money);
}
