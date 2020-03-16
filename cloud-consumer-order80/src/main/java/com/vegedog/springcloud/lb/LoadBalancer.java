package com.vegedog.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-03-17 18:41
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
