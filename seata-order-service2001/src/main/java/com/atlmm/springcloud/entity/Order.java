package com.atlmm.springcloud.entity;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private double money;
    private Integer status;

}
