package com.baiyi.gulimall.product.service.impl;

import com.baiyi.gulimall.common.utils.PageUtils;
import com.baiyi.gulimall.common.utils.Query;
import com.baiyi.gulimall.product.dao.CategoryDao;
import com.baiyi.gulimall.product.entity.CategoryEntity;
import com.baiyi.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1. 查询所有的分类数据
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 2. 组装树形结构数据
        return categoryEntities.stream()
                .filter(menu -> menu.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, categoryEntities));
                    return menu;
                })
                .sorted((menu1, menu2) -> {
                    if (menu1.getSort() == null || menu2.getSort() == null) {
                        return 0;
                    }
                    return menu1.getSort() - menu2.getSort();
                })
                .collect(Collectors.toList());
    }

    /**
     * 递归处理获取子分类
     *
     * @param parent 父分类
     * @param all    所有分类
     * @return 已经获取到子分类的分类
     */
    public List<CategoryEntity> getChildren(CategoryEntity parent, List<CategoryEntity> all) {
        return all.stream()
                .filter(menu -> menu.getParentCid().equals(parent.getCatId()))
                .map(menu -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                .sorted((menu1, menu2) -> {
                    if (menu1.getSort() == null || menu2.getSort() == null) {
                        return 0;
                    }
                    return menu1.getSort() - menu2.getSort();
                })
                .collect(Collectors.toList());
    }

    @Override
    public void removeMenuByIds(List<Long> list) {
        // todo 检查当前删除的菜单，是否被别的地方引用
        // 逻辑删除
        baseMapper.deleteBatchIds(list);
    }
}
