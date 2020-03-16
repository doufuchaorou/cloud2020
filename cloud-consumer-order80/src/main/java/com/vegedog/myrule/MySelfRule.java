package com.vegedog.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡路由规则类
 *
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-17 10:51
 **/

@Configuration
public class MySelfRule {
    @Bean
    public IRule iRule() {
        //定义为随机
        return new RoundRobinRule();
    }
}
