package com.baiyi.gulimall.member.dao;

import com.baiyi.gulimall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-11 10:45:10
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
