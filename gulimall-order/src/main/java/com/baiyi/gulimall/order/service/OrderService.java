package com.baiyi.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-11 11:08:00
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

