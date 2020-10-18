package com.tt.code.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class CodeConfig {

    @Value("${code.disable}")
    private boolean disable;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        if (disable) {
            log.info("开始建表");
            jdbcTemplate.execute("CREATE TABLE `hibernate_sequence` (\n" +
                    "  `next_val` bigint(20) DEFAULT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
            log.info("建表完成");
        }

    }

}
