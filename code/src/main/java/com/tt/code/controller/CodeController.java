package com.tt.code.controller;

import com.tt.code.service.CodeService;
import com.tt.code.vo.CodeVO;
import com.tt.code.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@Controller
@Slf4j
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @GetMapping("/")
    public String codePage() {
        return "code";
    }

    /**
     * 校验sql语法
     *
     * @param codeVO
     * @return
     */
    @PostMapping("/check-sql")
    @ResponseBody
    public Result checkSql(@RequestBody CodeVO codeVO) {
        try {
            codeService.validationCreateSql(codeVO.getSql());
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }

    /**
     * 预览结果
     *
     * @param codeVO
     * @return
     */
    @PostMapping("/preview")
    @ResponseBody
    public Result preview(@RequestBody CodeVO codeVO) {
        try {
            codeService.preview(codeVO.getSql(), codeVO.getTemplate());
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 预览结果
     *
     * @param codeVO
     * @return
     */
    @PostMapping("/generate")
    public void generate(@RequestBody CodeVO codeVO, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = codeService.generate(codeVO.getSql(), codeVO.getTemplateList());
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=code.zip");
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.close();
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
    }

}
