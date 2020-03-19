package com.vegedog.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-19 18:18
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
