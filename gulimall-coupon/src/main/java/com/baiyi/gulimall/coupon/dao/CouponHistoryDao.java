package com.baiyi.gulimall.coupon.dao;

import com.baiyi.gulimall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-11 10:56:46
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
