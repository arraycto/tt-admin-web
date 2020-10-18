package com.tt.code.service.impl;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.tt.code.component.CodeGenComponent;
import com.tt.code.model.Column;
import com.tt.code.model.Table;
import com.tt.code.service.CodeService;
import com.tt.code.vo.TemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeGenComponent codeGenComponent;

    @Override
    public void validationCreateSql(String sql) {
        SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
    }

    @Override
    public List<Table> parseCreateSqlToTable(String sql) {
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        List<Table> tableList = new ArrayList<>();
        for (SQLStatement sqlStatement : sqlStatements) {
            if (sqlStatement instanceof MySqlCreateTableStatement) {
                MySqlCreateTableStatement mySqlCreateTableStatement = (MySqlCreateTableStatement) sqlStatement;
                List<SQLTableElement> tableElementList = mySqlCreateTableStatement.getTableElementList();
                Table build = Table.builder()
                        .tableName(mySqlCreateTableStatement.getName().toString().replace("`", ""))
                        .tableComment(mySqlCreateTableStatement.getComment() != null ? mySqlCreateTableStatement.getComment().toString().replace("'", "") : "")
                        .columnList(new ArrayList<>())
                        .build();
                tableElementList.forEach(item -> {
                    List<Column> columnList = build.getColumnList();
                    if (item instanceof SQLColumnDefinition) {
                        SQLColumnDefinition sqlColumnDefinition = (SQLColumnDefinition) item;
                        Column column = Column.builder()
                                .columnName(sqlColumnDefinition.getName().toString().replace("`", ""))
                                .columnType(sqlColumnDefinition.getDataType().toString().replaceAll("\\(.*\\)", ""))
                                .columnComment(sqlColumnDefinition.getComment() != null ? sqlColumnDefinition.getComment().toString().replace("'", "") : "")
                                .build();
                        columnList.add(column);
                    }
                });
                tableList.add(build);
            }
        }
        return tableList;
    }

    @Override
    public TemplateVO preview(String sql, TemplateVO template) {
        List<Table> tableList = parseCreateSqlToTable(sql);
        List<String> strings = codeGenComponent.generateSingleTemplateResult(tableList, template.getTemplate());
        if (CollectionUtils.isNotEmpty(strings)) {
            return TemplateVO.builder().content(strings.get(0)).fileType(template.getFileType()).build();
        }
        return TemplateVO.builder().build();
    }

    @Override
    public ByteArrayOutputStream generate(String sql, List<TemplateVO> template) {
        List<Table> tableList = parseCreateSqlToTable(sql);
        return codeGenComponent.generateCode(tableList, template);
    }
}
