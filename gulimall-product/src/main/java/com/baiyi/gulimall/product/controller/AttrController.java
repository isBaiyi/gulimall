package com.baiyi.gulimall.product.controller;

import com.baiyi.gulimall.common.utils.R;
import com.baiyi.gulimall.product.entity.AttrEntity;
import com.baiyi.gulimall.product.service.AttrService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * 商品属性
 *
 * @author liaozicai
 * @email 1101293873@qq.com
 * @date 2023-11-13 15:10:19
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<AttrEntity> result=attrService.lambdaQuery()
                .page(new Page<>(Objects.nonNull(params.get("pageNo")) ? Long.parseLong(params.get("pageNo").toString()) : 1L,
                        Objects.nonNull(params.get("pageSize")) ? Long.parseLong(params.get("pageSize").toString()) : 10L));
        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    // @RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrEntity attr){
		attrService.save(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
