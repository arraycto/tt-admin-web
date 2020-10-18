package com.tt.admin.vo;

import lombok.Data;

@Data
public class FeVersionVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 版本
     */
    private String feVersion;

    /**
     * 创建人
     */
    private String createUser;

}
