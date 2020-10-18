package com.tt.admin.aop;

import com.alibaba.fastjson.JSON;
import com.tt.admin.annotation.SysLog;
import com.tt.admin.component.ThreadPoolExecutorComponent;
import com.tt.admin.handler.UserHandler;
import com.tt.admin.model.Log;
import com.tt.admin.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAop {

    private static final ThreadLocal<Log> LOG_THREAD_LOCAL = new ThreadLocal<>();

    @Autowired
    private LogService logService;

    @Autowired
    private ThreadPoolExecutorComponent threadPoolExecutorComponent;

    @Pointcut("execution(* com.tt..controller.*.*(..)))")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        log.info("请求地址:{}", request.getRequestURL().toString());
        log.info("HTTP METHOD:{}", request.getMethod());
        log.info("CLASS_METHOD:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("参数:{}", Arrays.toString(joinPoint.getArgs()));
        SysLog sysLog = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(SysLog.class);
        if (sysLog != null) {
            Log build = Log.builder()
                    .module(sysLog.module())
                    .operationType(sysLog.operationType())
                    .requestUrl(request.getRequestURI())
                    .requestMethod(request.getMethod())
                    .requestParam(Arrays.toString(joinPoint.getArgs()))
                    .classMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName())
                    .createUser(UserHandler.getCurrentUsername())
                    .build();
            LOG_THREAD_LOCAL.set(build);
        }
    }

    @AfterReturning(returning = "result", pointcut = "controllerAspect()")
    public void doAfterReturning(Object result) {
        log.info("返回值:{}", JSON.toJSONString(result));
    }

    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        long endTime = System.currentTimeMillis();
        String requestTime = String.format("%.2f", (endTime - startTime) * 1.0 / 1000);
        log.info("耗时:{}秒", requestTime);
        Log sysLog = LOG_THREAD_LOCAL.get();
        if (sysLog != null) {
            sysLog.setCreateTime(new Date());
            sysLog.setUpdateTime(new Date());
            sysLog.setRequestTime(requestTime);
            threadPoolExecutorComponent.submit(() -> logService.save(sysLog));
        }
        return ob;
    }
}
