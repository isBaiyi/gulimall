package com.baiyi.gulimall.order.controller;

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

import com.baiyi.gulimall.order.entity.OrderReturnReasonEntity;
import com.baiyi.gulimall.order.service.OrderReturnReasonService;
import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.common.utils.R;

/**
 * 退货原因
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-11 11:08:00
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {

    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnreason:list")
    public R list(@RequestParam Map<String, Object> params){
        // 此处暂时不加条件, 但生产环境必须根据需求加
        IPage<OrderReturnReasonEntity> result=orderReturnReasonService.lambdaQuery()
                .page(new Page<>(Objects.nonNull(params.get("pageNo")) ? Long.parseLong(params.get("pageNo").toString()) : 1L,
                        Objects.nonNull(params.get("pageSize")) ? Long.parseLong(params.get("pageSize").toString()) : 10L));
        return R.ok().put("page", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("order:orderreturnreason:info")
    public R info(@PathVariable("id") Long id){
		OrderReturnReasonEntity orderReturnReason = orderReturnReasonService.getById(id);

        return R.ok().put("orderReturnReason", orderReturnReason);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("order:orderreturnreason:save")
    public R save(@RequestBody OrderReturnReasonEntity orderReturnReason){
		orderReturnReasonService.save(orderReturnReason);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("order:orderreturnreason:update")
    public R update(@RequestBody OrderReturnReasonEntity orderReturnReason){
		orderReturnReasonService.updateById(orderReturnReason);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("order:orderreturnreason:delete")
    public R delete(@RequestBody Long[] ids){
		orderReturnReasonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
