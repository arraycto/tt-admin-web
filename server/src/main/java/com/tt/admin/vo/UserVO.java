package com.tt.admin.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class UserVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出身日期
     */
    private Date birth;

    /**
     * 出身日期
     */
    private String birthStr;

    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
        if (StringUtils.isNotBlank(birthStr)) {
            this.birth = Date.from(LocalDate.parse(birthStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }

    /**
     * 图片ID
     */
    private String image;
    /**
     * 图片ID
     */
    private Integer status;
    /**
     * 角色名称
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色标识
     */
    private String roleSign;

    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

}
