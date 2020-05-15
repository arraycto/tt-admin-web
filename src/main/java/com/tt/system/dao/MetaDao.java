package com.tt.system.dao;

import com.tt.system.model.Column;
import com.tt.system.model.Table;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MetaDao {
    @Select("select table_name, engine, table_comment, create_time from information_schema.tables"
            + " where table_schema = (select database())")
    List<Table> listTable();


    @Select("select column_name, data_type columnType, column_comment, column_key from information_schema.columns"
            + " where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
    List<Column> listColumn(String tableName);
}
