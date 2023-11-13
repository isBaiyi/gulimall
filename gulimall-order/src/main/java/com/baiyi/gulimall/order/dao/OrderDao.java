package com.baiyi.gulimall.order.dao;

import com.baiyi.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-11 11:08:00
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
