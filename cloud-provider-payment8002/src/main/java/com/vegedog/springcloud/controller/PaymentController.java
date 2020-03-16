package com.vegedog.springcloud.controller;

import com.vegedog.springcloud.entities.CommonResult;
import com.vegedog.springcloud.entities.Payment;
import com.vegedog.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-12 11:22
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***********插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功 + serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "成功 + serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "失败", null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


}
