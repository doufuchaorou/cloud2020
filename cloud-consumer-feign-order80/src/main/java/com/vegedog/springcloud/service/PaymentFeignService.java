package com.vegedog.springcloud.service;

import com.vegedog.springcloud.entities.CommonResult;
import com.vegedog.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-18 18:04
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();
}
