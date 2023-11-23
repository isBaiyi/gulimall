package com.baiyi.gulimall.product.entity;

import com.baiyi.gulimall.common.validator.ListValue;
import com.baiyi.gulimall.common.validator.group.AddGroup;
import com.baiyi.gulimall.common.validator.group.UpdateGroup;
import com.baiyi.gulimall.common.validator.group.UpdateStatusGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author liaozicai
 * @email starlishcs@gmail.com
 * @date 2023-11-13 15:10:19
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@NotNull(message = "品牌ID不能为空", groups = {UpdateGroup.class, UpdateStatusGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌logo地址不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@URL(message = "品牌logo地址必须是一个合法的URL地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@TableLogic(value = "1", delval = "0")
	@ListValue(value = {0, 1}, groups = {AddGroup.class, UpdateGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(message = "检索首字母不能为空")
	@Pattern(regexp = "^[a-zA-Z]$", message = "只能是a-z或者A-Z的字符", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序字段不能为空")
	@Min(value = 0, message = "排序字段必须是大于或等于0的整数", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
