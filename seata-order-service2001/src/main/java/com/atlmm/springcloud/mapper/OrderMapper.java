package com.atlmm.springcloud.mapper;

import com.atlmm.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Integer create(Order order);
    Integer update(Long userId);
}
