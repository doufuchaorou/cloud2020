package com.vegedog.springcloud.alibaba.service.serviceImpl;

import com.vegedog.springcloud.alibaba.dao.OrderDao;
import com.vegedog.springcloud.alibaba.domain.Order;
import com.vegedog.springcloud.alibaba.service.AccountService;
import com.vegedog.springcloud.alibaba.service.OrderService;
import com.vegedog.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-04-08 17:37
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("---------->开始新建订单");
        orderDao.create(order);

        log.info("----------------->订单微服务开始调用库存，做扣减count");

        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----------------->订单微服务开始调用库存，做扣减count结束");

        log.info("--------------->订单微服务开始调用账户，做扣减money");

        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("--------------->订单微服务开始调用账户，做扣减money结束");

        //修改订单状态，从0到1，代表已经完成
        log.info("---------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("---------->修改订单状态结束");

        log.info("---------------.下订单结束。");

    }
}
