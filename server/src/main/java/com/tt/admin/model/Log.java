package com.tt.admin.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Log {

    /**
     *
     */
    private Integer id;
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
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
}
