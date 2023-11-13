package com.baiyi.gulimall.coupon.controller;

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

import com.baiyi.gulimall.coupon.entity.MemberPriceEntity;
import com.baiyi.gulimall.coupon.service.MemberPriceService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.common.utils.R;

/**
 * 商品会员价格
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-11 10:56:46
 */
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {

    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:memberprice:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<MemberPriceEntity> result=memberPriceService.lambdaQuery()
                .page(new Page<>(Objects.nonNull(params.get("pageNo")) ? Long.parseLong(params.get("pageNo").toString()) : 1L,
                        Objects.nonNull(params.get("pageSize")) ? Long.parseLong(params.get("pageSize").toString()) : 10L));
        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:memberprice:info")
    public R info(@PathVariable("id") Long id){
		MemberPriceEntity memberPrice = memberPriceService.getById(id);

        return R.ok().put("memberPrice", memberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:memberprice:save")
    public R save(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.save(memberPrice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:memberprice:update")
    public R update(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.updateById(memberPrice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:memberprice:delete")
    public R delete(@RequestBody Long[] ids){
		memberPriceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
