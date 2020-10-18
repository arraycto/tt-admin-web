package com.tt.admin.vo;

import lombok.Data;

@Data
public class LogVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    /**
     *
     */
    private String module;
    /**
     *
     */
    private String operationType;
    /**
     *
     */
    private String requestUrl;
    /**
     *
     */
    private String requestMethod;
    /**
     *
     */
    private String requestParam;
    /**
     *
     */
    private String requestTime;
    /**
     *
     */
    private String classMethod;
    /**
     *
     */
    private String createUser;
}
