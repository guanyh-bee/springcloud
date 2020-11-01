package com.atlmm.springcloud.service;

import com.atlmm.springcloud.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void create(Order order);
}
