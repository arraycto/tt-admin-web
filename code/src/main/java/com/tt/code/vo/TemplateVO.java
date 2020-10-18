package com.tt.code.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateVO {

    private String template;

    private String content;

    private String fileType;

    private String fileName;
}
