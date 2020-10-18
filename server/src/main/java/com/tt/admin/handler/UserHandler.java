package com.tt.admin.handler;

import com.tt.admin.vo.UserVO;

public class UserHandler {

    private UserHandler() {
    }

    private static final ThreadLocal<UserVO> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public static void clear() {
        USER_INFO_THREAD_LOCAL.remove();
    }

    public static void set(UserVO user) {
        USER_INFO_THREAD_LOCAL.set(user);
    }

    public static UserVO getCurrentUser() {
        return USER_INFO_THREAD_LOCAL.get();
    }

    public static String getCurrentUsername() {
        return USER_INFO_THREAD_LOCAL.get().getUsername();
    }

    public static String getRoleSign() {
        return USER_INFO_THREAD_LOCAL.get().getRoleSign();
    }
}
