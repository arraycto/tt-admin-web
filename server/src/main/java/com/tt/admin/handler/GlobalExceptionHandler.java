package com.tt.admin.handler;

import com.tt.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TONGXIN
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }
}
