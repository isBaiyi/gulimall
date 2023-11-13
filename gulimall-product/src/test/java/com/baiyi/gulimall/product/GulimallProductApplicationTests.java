package com.baiyi.gulimall.product;

import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.product.entity.BrandEntity;
import com.baiyi.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
class GulimallProductApplicationTests {

    @Resource
    private BrandService brandService;

    /**
     * 用于测试：
     */
    @Test
    void test_add() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

    /**
     * 用于测试：
     */
    @Test
    void test_query() {
        PageUtils pageUtils = brandService.queryPage(new HashMap<>());
        pageUtils.getList().forEach(System.out::println);
    }

}
