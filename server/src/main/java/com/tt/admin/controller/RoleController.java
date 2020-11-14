package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.admin.annotation.SysLog;
import com.tt.common.vo.Result;
import com.tt.admin.model.Role;
import com.tt.admin.model.RoleMenu;
import com.tt.admin.service.RoleService;
import com.tt.admin.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    @SysLog(module = "获取角色分页数据", operationType = "查看", desc = "")
    public Result getRolePageList(RoleVO roleVO) {
        List<Role> roleList = roleService.findByCondition(roleVO);
        if (roleList instanceof Page) {
            Page page = (Page) roleList;
            return Result.ok(roleList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
        }
        return Result.ok(roleList, 0, 0, 0);
    }

    @GetMapping("/all-list")
    @SysLog(module = "获取角色全部数据", operationType = "查看", desc = "")
    public Result getRoleAllList(RoleVO roleVO) {
        List<Role> roleList = roleService.findAll(roleVO);
        return Result.ok(roleList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @SysLog(module = "增加角色", operationType = "增加", desc = "")
    public Result save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @SysLog(module = "修改角色", operationType = "修改", desc = "")
    public Result update(@RequestBody Role role) {
        roleService.update(role);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{roleId}")
    @SysLog(module = "删除角色", operationType = "删除", desc = "")
    public Result remove(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
        return Result.ok();
    }

    /**
     * 获取已有的菜单权限
     * @param roleMenu
     * @return
     */
    @GetMapping("/role-menu")
    @SysLog(module = "获取权限菜单数据", operationType = "删除", desc = "")
    public Result getRoleMenu(RoleMenu roleMenu) {
        List<RoleMenu> roleMenuList = roleService.getRoleMenu(roleMenu);
        List<Integer> result = new ArrayList<>();
        roleMenuList.forEach(item -> result.add(item.getMenuId()));
        return Result.ok(result);
    }

    /**
     * 增加
     * @param roleVO
     * @return
     */
    @PostMapping("/add-menu-permission")
    @SysLog(module = "增加菜单权限", operationType = "增加", desc = "")
    public Result addMenuPermission(@RequestBody RoleVO roleVO) {
        roleService.addMenuPermission(roleVO);
        return Result.ok();
    }


}
