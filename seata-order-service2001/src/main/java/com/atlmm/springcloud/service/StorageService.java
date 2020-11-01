package com.atlmm.springcloud.service;

import com.atlmm.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("seata-storage-service")
public interface StorageService {
    @RequestMapping("/storage/decrement")
    CommonResult decrement(@RequestParam("product_id")Long productId,@RequestParam("count")Integer count);
}
