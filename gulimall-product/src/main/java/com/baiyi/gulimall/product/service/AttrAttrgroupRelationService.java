package com.baiyi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-13 15:10:19
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

