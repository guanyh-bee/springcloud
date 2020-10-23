package com.atlmm.springcloud.service;

import com.atlmm.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Integer create(Payment payment);
    Payment getPaymentById( Long id);
}
