package com.baiyi.gulimall.member.controller;

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

import com.baiyi.gulimall.member.entity.MemberCollectSpuEntity;
import com.baiyi.gulimall.member.service.MemberCollectSpuService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.common.utils.R;

/**
 * 会员收藏的商品
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-11 10:45:10
 */
@RestController
@RequestMapping("member/membercollectspu")
public class MemberCollectSpuController {

    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:membercollectspu:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<MemberCollectSpuEntity> result=memberCollectSpuService.lambdaQuery()
                .page(new Page<>(Objects.nonNull(params.get("pageNo")) ? Long.parseLong(params.get("pageNo").toString()) : 1L,
                        Objects.nonNull(params.get("pageSize")) ? Long.parseLong(params.get("pageSize").toString()) : 10L));
        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("member:membercollectspu:info")
    public R info(@PathVariable("id") Long id){
		MemberCollectSpuEntity memberCollectSpu = memberCollectSpuService.getById(id);

        return R.ok().put("memberCollectSpu", memberCollectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("member:membercollectspu:save")
    public R save(@RequestBody MemberCollectSpuEntity memberCollectSpu){
		memberCollectSpuService.save(memberCollectSpu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("member:membercollectspu:update")
    public R update(@RequestBody MemberCollectSpuEntity memberCollectSpu){
		memberCollectSpuService.updateById(memberCollectSpu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("member:membercollectspu:delete")
    public R delete(@RequestBody Long[] ids){
		memberCollectSpuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
