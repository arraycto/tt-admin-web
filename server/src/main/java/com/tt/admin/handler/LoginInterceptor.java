package com.tt.admin.handler;

import com.tt.admin.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final String LOGIN_ERROR_JSON = "{\"status\":401,\"msg\":\"登录异常:登录信息过期或缺失,请回到首页重新登录\"}";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(LOGIN_ERROR_JSON);
            return false;
        }
        UserHandler.set(user);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserHandler.clear();
    }

}
