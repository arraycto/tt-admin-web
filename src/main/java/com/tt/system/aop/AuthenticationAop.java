package com.tt.system.aop;

import com.alibaba.druid.support.http.WebStatFilter;
import com.tt.system.annotation.Permission;
import com.tt.system.handler.UserHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongxin
 */
@Aspect
@Component
@Slf4j
public class AuthenticationAop {

    @Pointcut("execution(* com.tt..controller.*.*(..)))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        Class clazz = joinPoint.getSignature().getDeclaringType();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object[] args = joinPoint.getArgs();
            Class[] argsClass = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argsClass[i] = args[i].getClass();
                if (argsClass[i].equals(RequestFacade.class)) {
                    argsClass[i] = HttpServletRequest.class;
                }
                if (argsClass[i].equals(WebStatFilter.StatHttpServletResponseWrapper.class)) {
                    argsClass[i] = HttpServletResponse.class;
                }
                if (argsClass[i].equals(BindingAwareModelMap.class)) {
                    argsClass[i] = Model.class;
                }
                if (argsClass[i].getName().equals("org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile")) {
                    argsClass[i] = MultipartFile.class;
                }
            }
            Method method = clazz.getMethod(methodName, argsClass);
            Permission permission = method.getAnnotation(Permission.class);
            if (permission != null) {
                List<String> permissionList = Arrays.asList(permission.value());
                checkPermission(permissionList, joinPoint);
                return;
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        Permission permission = (Permission) clazz.getAnnotation(Permission.class);
        if (permission != null) {
            List<String> permissionList = Arrays.asList(permission.value());
            checkPermission(permissionList, joinPoint);
        }
    }

    private void checkPermission(List<String> permissionList, JoinPoint joinPoint) {
        String roleSign = UserHandler.getRoleSign();
        log.info("{}-所需权限注解-{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), permissionList);
        if (!permissionList.contains(roleSign)) {
            log.warn("用户-{}-无访问权限，角色-{}，所需角色-{}", UserHandler.getCurrentUser().getName(), UserHandler.getRoleSign(), permissionList);
            throw new RuntimeException("无访问权限");
        }
    }
}
