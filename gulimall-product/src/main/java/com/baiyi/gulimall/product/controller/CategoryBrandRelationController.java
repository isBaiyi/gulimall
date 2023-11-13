package com.baiyi.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baiyi.gulimall.product.entity.CategoryBrandRelationEntity;
import com.baiyi.gulimall.product.service.CategoryBrandRelationService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.common.utils.R;

/**
 * 品牌分类关联
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-13 15:10:19
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<CategoryBrandRelationEntity> result=categoryBrandRelationService.lambdaQuery()
                .page(new Page<>(Objects.nonNull(params.get("pageNo")) ? Long.parseLong(params.get("pageNo").toString()) : 1L,
                        Objects.nonNull(params.get("pageSize")) ? Long.parseLong(params.get("pageSize").toString()) : 10L));
        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.save(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
