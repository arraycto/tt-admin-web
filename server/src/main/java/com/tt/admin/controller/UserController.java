package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.common.utils.MD5Utils;
import com.tt.common.vo.Result;
import com.tt.admin.handler.UserHandler;
import com.tt.admin.service.UserService;
import com.tt.admin.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/system/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result getUserPageList(UserVO userVO) {
        // 查询列表数据
        List<UserVO> userList = userService.findByCondition(userVO);
        if (userList instanceof Page) {
            Page page = (Page) userList;
            return Result.ok(userList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
        }
        return Result.ok(userList, 0, 0, 0);
    }

    @GetMapping("/info")
    public Result getUserInfo() {
        return Result.ok(UserHandler.getCurrentUser());
    }

    @PostMapping("/save")
    public Result save(@RequestBody UserVO userVO) {
        userVO.setPassword(MD5Utils.encrypt(userVO.getUsername(), userVO.getPassword()));
        userService.save(userVO);
        return Result.ok();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody UserVO userVO) {
        userService.update(userVO);
        return Result.ok();
    }

    @PostMapping("/update-current-user")
    @ResponseBody
    public Result updateCurrentUser(@RequestBody UserVO userVO, HttpServletRequest request) {
        try {
            UserVO reallyUser = userService.findByUsername(UserHandler.getCurrentUsername());
            userVO.setId(reallyUser.getId());
            userService.updateCurrentUser(userVO);
            reallyUser = userService.findByUsername(UserHandler.getCurrentUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", reallyUser);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }

    }


    @PostMapping("/delete/{userId}")
    @ResponseBody
    public Result remove(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return Result.ok();
    }

    @PostMapping("/resetPassword")
    @ResponseBody
    public Result resetPassword(@RequestBody UserVO userVO) {
        userVO.setPassword(MD5Utils.encrypt(userVO.getUsername(), userVO.getPassword()));
        userService.update(userVO);
        return Result.ok();
    }

}
