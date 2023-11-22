package com.baiyi.gulimall.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 自定义注解校验器
 * @author: liaozicai
 * @date: 2023/11/22 21:31
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private final Set<Integer> set = new HashSet<>();

    /**
     * 获取自定义校验注解的value值
     *
     * @param constraintAnnotation 注解
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] value = constraintAnnotation.value();
        for (int i : value) {
            set.add(i);
        }
    }

    /**
     * 校验是否符合
     *
     * @param value   实体对应的准备校验的值
     * @param context 上下文
     * @return true：符合 false：不符合
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
