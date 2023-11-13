package com.baiyi.gulimall.member.feign;

import com.baiyi.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: liaozicai
 * @date: 2023/11/12 11:58
 */
// 告诉spring cloud这个接口是一个远程客户端，要调用coupon服务，再去调用coupon服务/coupon/coupon/member/list对应的方法
@FeignClient(value = "gulimall-coupon")
public interface CouponFeignService {
    /**
     * 注意写全优惠券类上还有映射
     *
     * @return 得到一个R对象
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
