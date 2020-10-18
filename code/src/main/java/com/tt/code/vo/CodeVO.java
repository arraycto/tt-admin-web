package com.tt.code.vo;

import lombok.Data;

import java.util.List;

@Data
public class CodeVO {
    private String sql;

    private TemplateVO template;

    private List<TemplateVO> templateList;
}
