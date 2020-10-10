package com.tt.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author TONGXIN
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 父菜单ID，一级菜单为0
     */
    private Integer parentId;

    /**
     * 父菜单名称
     */
    private String parentName;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;

    /**
     * 菜单URL
     */
    private String operate;

    /**
     * 类型 1：菜单 2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer orderNum;

    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 子节点
     */
    private List<MenuVO> children;

    private String roleSign;

}
