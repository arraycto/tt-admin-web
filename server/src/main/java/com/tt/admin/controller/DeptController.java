package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.admin.annotation.SysLog;
import com.tt.common.vo.Result;
import com.tt.admin.model.Dept;
import com.tt.admin.service.DeptService;
import com.tt.admin.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    @SysLog(module = "获取部门分页数据", operationType = "查看", desc = "")
    public Result getDeptPageList(DeptVO deptVO) {
        List<DeptVO> deptList = deptService.findByCondition(deptVO);
        if (deptList instanceof Page) {
            Page page = (Page) deptList;
            return Result.ok(deptList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
        }
        return Result.ok(deptList);
    }
    @GetMapping("/all-list")
    @SysLog(module = "获取部门全部数据", operationType = "查看", desc = "")
    public Result getDeptAllList(DeptVO deptVO) {
        List<DeptVO> deptList = deptService.findAll(deptVO);
        return Result.ok(deptList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @SysLog(module = "增加部门", operationType = "增加", desc = "")
    public Result save(@RequestBody Dept dept) {
        deptService.save(dept);
        return Result.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @SysLog(module = "修改部门", operationType = "修改", desc = "")
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{deptId}")
    @SysLog(module = "删除部门", operationType = "删除", desc = "")
    public Result remove(@PathVariable Integer deptId) {
        deptService.deleteById(deptId);
        return Result.ok();
    }
}
