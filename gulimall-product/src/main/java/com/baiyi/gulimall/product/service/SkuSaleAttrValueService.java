package com.baiyi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-13 15:10:19
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

