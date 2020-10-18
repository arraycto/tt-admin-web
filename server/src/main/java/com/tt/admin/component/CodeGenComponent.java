package com.tt.admin.component;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;
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

    public ByteArrayOutputStream generateCode(List<Map<String, Object>> data, String packageName, String module) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(byteArrayOutputStream);
        data.forEach(item -> {
            VelocityContext context = new VelocityContext();
            Set<String> set = item.keySet();
            for (String key : set) {
                context.put(key, item.get(key));
            }
            List<String> templateFileList = new ArrayList<>();
            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources("tpl/*.*");
                for (Resource resource : resources) {
                    templateFileList.add(resource.getFilename());
                }
            } catch (IOException e) {
                log.error("模板读取失败", e);
            }
            if (!CollectionUtils.isEmpty(templateFileList)) {
                templateFileList.forEach(templateFile -> {
                    //加载模板，设定模板编码
                    Template template = velocityEngine.getTemplate("tpl/" + templateFile, "utf-8");
                    //设置输出
                    StringWriter stringWriter = new StringWriter();
                    //将环境数据转化输出
                    template.merge(context, stringWriter);
                    log.info(packageName + File.separator + module + File.separator + getFilePath(templateFile) + File.separator + getFile(templateFile, item));
                    log.info(stringWriter.toString());
                    try {
                        //添加到zip
                        if (templateFile.equals("mapper.vm")) {
                            zip.putNextEntry(new ZipEntry("src/main/resource/mybatis/" + module + File.separator + getFile(templateFile, item)));
                        } else if (templateFile.equals("vue.vm")) {
                            zip.putNextEntry(new ZipEntry("fe/src/view/" + module + File.separator + item.get("className") + File.separator + getFile(templateFile, item)));
                        } else if (templateFile.equals("api.vm")) {
                            zip.putNextEntry(new ZipEntry("fe/src/api/" + module + File.separator + getFile(templateFile, item)));
                        } else {
                            zip.putNextEntry(new ZipEntry("src/main/java/" + packageName + File.separator + module + File.separator + getFilePath(templateFile) + File.separator + getFile(templateFile, item)));
                        }
                        zip.write(stringWriter.toString().getBytes());
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                });
            }
        });
        try {
            zip.close();
        } catch (IOException e) {
            log.error("流关闭异常", e);
        }
        return byteArrayOutputStream;
    }

    private String getFile(String templateFile, Map<String, Object> data) {
        switch (templateFile) {
            case "controller.vm":
                return data.get("ClassName").toString() + "Controller.java";
            case "dao.vm":
                return data.get("ClassName").toString() + "Dao.java";
            case "service.vm":
                return data.get("ClassName").toString() + "Service.java";
            case "serviceImpl.vm":
                return data.get("ClassName").toString() + "ServiceImpl.java";
            case "vo.vm":
                return data.get("ClassName").toString() + "VO.java";
            case "mapper.vm":
                return data.get("ClassName").toString() + "Mapper.xml";
            case "vue.vm":
                return "index.vue";
            case "api.vm":
                return data.get("className").toString() + ".js";
            default:
                return data.get("ClassName").toString() + ".java";
        }
    }

    private String getFilePath(String templateFile) {
        switch (templateFile) {
            case "controller.vm":
                return "controller";
            case "dao.vm":
                return "dao";
            case "service.vm":
                return "service";
            case "serviceImpl.vm":
                return "service/impl";
            case "model.vm":
                return "model";
            case "vo.vm":
                return "vo";
            case "mapper.vm":
                return "mapper";
            default:
                return "";
        }
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
                tableElementList.forEach(item -> {
                    if (item instanceof SQLColumnDefinition) {
                        SQLColumnDefinition sqlColumnDefinition = (SQLColumnDefinition) item;
                        System.out.println(sqlColumnDefinition.getName() + "-" + sqlColumnDefinition.getDataType() + "-" + sqlColumnDefinition.getComment());
                    }
                });
            }
        }
        System.out.println(SQLUtils.toSQLString(sqlStatements, dbType));
    }
}
