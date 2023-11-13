package com.baiyi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-13 15:10:19
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

