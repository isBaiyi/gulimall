package com.baiyi.gulimall.order.dao;

import com.baiyi.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-11 11:08:00
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
