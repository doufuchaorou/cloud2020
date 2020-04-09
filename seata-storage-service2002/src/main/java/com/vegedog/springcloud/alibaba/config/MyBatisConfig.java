package com.vegedog.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-04-09 13:49
 **/
@Configuration
@MapperScan({"com.vegedog.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
