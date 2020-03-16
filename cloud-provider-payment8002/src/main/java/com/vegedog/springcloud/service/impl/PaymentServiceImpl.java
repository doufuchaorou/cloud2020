package com.vegedog.springcloud.service.impl;

import com.vegedog.springcloud.dao.PaymentDao;
import com.vegedog.springcloud.entities.Payment;
import com.vegedog.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-12 11:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}

