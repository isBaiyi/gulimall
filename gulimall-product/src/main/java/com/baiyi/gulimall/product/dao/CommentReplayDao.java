package com.baiyi.gulimall.product.dao;

import com.baiyi.gulimall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-13 15:10:19
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
