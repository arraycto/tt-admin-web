package com.tt.admin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class EnvironmentAop {

    @Value("${demo}")
    private Boolean demo;

    @Pointcut("execution(* com.tt..controller.*.*(..)))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doBefore() {
        //演示环境不允许修改数据
        if (demo) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            String method = request.getMethod();
            String requestURI = request.getRequestURI();
            if (!requestURI.contains("login") && !requestURI.contains("logout")) {
                if (!"GET".equalsIgnoreCase(method)) {
                    log.warn("演示环境，不允许修改");
                    throw new RuntimeException("演示环境，不允许修改");
                }
            }
        }
    }
}
