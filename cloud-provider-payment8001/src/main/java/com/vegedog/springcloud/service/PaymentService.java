package com.vegedog.springcloud.service;

import com.vegedog.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-12 11:17
 **/
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
