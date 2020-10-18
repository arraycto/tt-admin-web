package com.tt.code.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    /**
     * 表的名称
     */
    private String tableName;
    /**
     * 引擎
     */
    private String engine;
    /**
     * 表的备注
     */
    private String tableComment;

    /**
     * 字段
     */
    List<Column> columnList;

}
