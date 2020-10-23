package com.atlmm.springcloud.dao;

import com.atlmm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    Integer create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
