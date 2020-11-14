package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.common.vo.Result;
import com.tt.admin.annotation.SysLog;
import com.tt.admin.model.Menu;
import com.tt.admin.service.MenuService;
import com.tt.admin.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TONGXIN
 */
@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @SysLog(module = "获取分页菜单", operationType = "查看", desc = "")
    public Result getMenuPageList(MenuVO menuVO) {
        List<MenuVO> menuList = menuService.findByCondition(menuVO);
        if (menuList instanceof Page) {
            Page page = (Page) menuList;
            return Result.ok(menuList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
        }
        return Result.ok(menuList);
    }

    @GetMapping("/permission-list")
    @SysLog(module = "获取权限菜单", operationType = "查看", desc = "")
    public Result getPermissionList(MenuVO menuVO) {
        List<MenuVO> menuList = menuService.getPermissionList(menuVO);
        return Result.ok(menuList);
    }

    @GetMapping("/all-list")
    @SysLog(module = "获取全部菜单", operationType = "查看", desc = "")
    public Result getMenuAllList(MenuVO menuVO) {
        List<MenuVO> menuList = menuService.findAll(menuVO);
        return Result.ok(menuList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @SysLog(module = "添加菜单", operationType = "增加", desc = "")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @SysLog(module = "修改菜单", operationType = "修改", desc = "")
    public Result update(@RequestBody Menu menu) {
        menuService.update(menu);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{menuId}")
    @SysLog(module = "删除菜单", operationType = "删除", desc = "")
    public Result remove(@PathVariable Integer menuId) {
        menuService.deleteById(menuId);
        return Result.ok();
    }
}
