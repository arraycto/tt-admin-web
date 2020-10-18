package com.tt.code.component;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.tt.code.model.Table;
import com.tt.code.vo.TemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
@Slf4j
public class CodeGenComponent {

    private VelocityEngine velocityEngine;

    public List<String> generateSingleTemplateResult(List<Table> tableList, String templateContent) {
        VelocityContext context = new VelocityContext();
        List<String> result = new ArrayList<>();
        tableList.forEach(item -> {
            context.put("tableName", item.getTableName());
            context.put("tableComment", item.getTableComment());
            context.put("columnList", item.getColumnList());
            StringWriter stringWriter = new StringWriter();
            velocityEngine.evaluate(context, stringWriter, item.getTableName(), templateContent);
            result.add(stringWriter.toString());
        });
        return result;
    }

    public ByteArrayOutputStream generateCode(List<Table> tableList, List<TemplateVO> templateContents) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(byteArrayOutputStream);
        VelocityContext context = new VelocityContext();
        tableList.forEach(item -> {
            context.put("tableName", item.getTableName());
            context.put("tableComment", item.getTableComment());
            context.put("columnList", item.getColumnList());
            templateContents.forEach(templateContent -> {
                StringWriter stringWriter = new StringWriter();
                velocityEngine.evaluate(context, stringWriter, item.getTableName(), templateContent.getTemplate());
                try {
                    zip.putNextEntry(new ZipEntry(templateContent.getFileName() + File.separator + templateContent.getFileType()));
                    zip.write(stringWriter.toString().getBytes());
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            });

        });
        try {
            zip.close();
        } catch (IOException e) {
            log.error("流关闭异常", e);
        }
        return byteArrayOutputStream;
    }


    @PostConstruct
    public void init() {
        velocityEngine = new VelocityEngine();
        //设置模板加载路径，这里设置的是class下
        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //进行初始化操作
        velocityEngine.init();
    }

    public static void main(String[] args) {
        final String dbType = JdbcConstants.MYSQL; // 可以是ORACLE、POSTGRESQL、SQLSERVER、ODPS等
        String sql = "CREATE TABLE `sys_user` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',\n" +
                "  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',\n" +
                "  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',\n" +
                "  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',\n" +
                "  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',\n" +
                "  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 1.男 2.女',\n" +
                "  `birth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出身日期',\n" +
                "  `image` varchar(1000) NOT NULL DEFAULT '' COMMENT '头像',\n" +
                "  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '可用状态 1.可用 2.不可用',\n" +
                "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '用户表'";
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, dbType);
        for (SQLStatement sqlStatement : sqlStatements) {
            if (sqlStatement instanceof MySqlCreateTableStatement) {
                MySqlCreateTableStatement mySqlCreateTableStatement = (MySqlCreateTableStatement) sqlStatement;
                List<SQLTableElement> tableElementList = mySqlCreateTableStatement.getTableElementList();
                System.out.println(mySqlCreateTableStatement.getName().toString().replace("`", "") + "-" + mySqlCreateTableStatement.getComment().toString().replace("'", ""));
                tableElementList.forEach(item -> {
                    if (item instanceof SQLColumnDefinition) {
                        SQLColumnDefinition sqlColumnDefinition = (SQLColumnDefinition) item;
                        System.out.println(sqlColumnDefinition.getName().toString().replace("`", "") + "-" + sqlColumnDefinition.getDataType().toString().replaceAll("\\(.*\\)", "") + "-" + (sqlColumnDefinition.getComment() != null ? sqlColumnDefinition.getComment().toString().replace("'", "") : ""));
                    }
                });
            }
        }
    }
}
