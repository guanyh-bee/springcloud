package com.atlmm.springcloud.service.impl;

import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

@Service
public class IStorageService implements StorageService {
    @Override
    public CommonResult decrement(Long productId, Integer count) {
        return null;
    }
}
