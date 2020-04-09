package com.vegedog.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @program: cloud2020
 * @description
 * @author: Vegedog
 * @create: 2020-04-09 13:31
 **/
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
