package com.baiyi.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-11 10:45:10
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

