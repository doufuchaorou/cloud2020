package com.vegedog.springcloud.alibaba.service;

import com.vegedog.springcloud.entities.CommonResult;
import com.vegedog.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @auther vegedog
 * @create 2020-04-08 10:50
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
