package com.tt.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class TableVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String tableName;

    private List<String> tableNameList;

    private String packageName = "com.tt";

    private String module = "mybatis";

    private Boolean removeTablePrefix = false;


}
