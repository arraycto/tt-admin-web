package com.tt.admin.model;

import lombok.Data;

import java.util.Date;


@Data
public class Dept{
	//主键
	private Integer id;
	//上级部门ID，一级部门为0
	private Integer parentId;
	//部门名称
	private String deptName;
	//是否删除  -1：正常  0：已删除
	private Integer status;

	/**
	 * 排序
	 */
	private Integer orderNum;

	private Date createTime;

	private Date updateTime;

}
