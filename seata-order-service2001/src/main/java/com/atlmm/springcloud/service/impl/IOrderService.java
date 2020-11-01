package com.atlmm.springcloud.service.impl;

import com.atlmm.springcloud.entity.Order;
import com.atlmm.springcloud.mapper.OrderMapper;
import com.atlmm.springcloud.service.AccountService;
import com.atlmm.springcloud.service.OrderService;
import com.atlmm.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IOrderService implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        orderMapper.create(order);
        storageService.decrement(order.getProductId(),order.getCount());
        accountService.decrement(order.getUserId(),order.getMoney());
        orderMapper.update(order.getUserId());

    }
}
