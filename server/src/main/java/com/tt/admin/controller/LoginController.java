package com.tt.admin.controller;

import com.tt.common.utils.MD5Utils;
import com.tt.common.vo.Result;
import com.tt.admin.model.User;
import com.tt.admin.service.UserService;
import com.tt.admin.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author TONGXIN
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return Result.error("用户名或密码不能为空");
        }
        String password = MD5Utils.encrypt(user.getUsername(), user.getPassword());
        try {
            UserVO reallyUser = userService.findByUsername(user.getUsername());
            if (!reallyUser.getPassword().equals(password)) {
                return Result.error("密码错误");
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", reallyUser);
            return Result.ok(reallyUser);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return Result.ok();
    }

}
