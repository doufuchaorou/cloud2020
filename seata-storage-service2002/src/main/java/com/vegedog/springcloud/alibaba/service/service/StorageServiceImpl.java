package com.vegedog.springcloud.alibaba.service.service;

import com.vegedog.springcloud.alibaba.dao.StorageDao;
import com.vegedog.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-04-09 13:47
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----------------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("--------------------->storage-service中扣减库存结束");
    }
}
