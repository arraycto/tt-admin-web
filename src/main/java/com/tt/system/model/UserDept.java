package com.tt.system.model;

import lombok.Data;

import java.util.Date;

/**
 * @author TONGXIN
 */
@Data
public class UserDept {

    private Integer id;
    private Integer deptId;
    private Integer userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
