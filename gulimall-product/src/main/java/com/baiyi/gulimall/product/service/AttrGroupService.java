package com.baiyi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-13 15:10:19
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

