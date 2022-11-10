package com.orange.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.orange.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 系统角色表
 * @author: Li ZhiCheng
 * @date: 2022/10/27 16:49
 **/
@Data
@TableName("sys_role")
@ApiModel("系统角色")
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//角色名字
	@TableField("role_name")
	@ApiModelProperty("角色名称")
	private String roleName;

	//角色编码
	@TableField("role_code")
	private String roleCode;

	//描述
	@TableField("description")
	private String description;

}

