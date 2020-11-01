package com.atlmm.springcloud.service.impl;

import com.atlmm.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class IAccountService implements AccountService {
    @Override
    public void decrement(Long userId, Double money) {

    }
}
