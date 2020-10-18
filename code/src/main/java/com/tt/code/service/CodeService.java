package com.tt.code.service;

import com.tt.code.model.Table;
import com.tt.code.vo.TemplateVO;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface CodeService {

    /**
     * 验证sql语法
     *
     * @param sql
     */
    void validationCreateSql(String sql);

    /**
     * 将sql创建语句解析成表元数据
     *
     * @param sql
     */
    List<Table> parseCreateSqlToTable(String sql);

    /**
     * 预览结果
     *
     * @param sql
     * @return
     */
    TemplateVO preview(String sql, TemplateVO template);

    /**
     * 生成代码
     *
     * @param sql
     * @param template
     * @return
     */
    ByteArrayOutputStream generate(String sql, List<TemplateVO> template);
}
