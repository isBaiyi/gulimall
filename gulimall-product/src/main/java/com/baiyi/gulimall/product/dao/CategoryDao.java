package com.baiyi.gulimall.product.dao;

import com.baiyi.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-13 15:10:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
