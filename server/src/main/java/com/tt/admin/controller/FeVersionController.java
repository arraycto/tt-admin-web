package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.admin.annotation.SysLog;
import com.tt.common.vo.Result;
import com.tt.admin.annotation.Permission;
import com.tt.admin.model.FeVersion;
import com.tt.admin.service.FeVersionService;
import com.tt.admin.vo.FeVersionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/feVersion")
@Permission(value = {"SUPER_ADMIN"})
public class FeVersionController {

    @Autowired
    private FeVersionService feVersionService;

    @GetMapping("/list")
    @SysLog(module = "获取版本分页数据", operationType = "查看", desc = "")
    public Result getPageList(FeVersionVO feVersionVO) {
        try {
            List<FeVersion> feVersionList = feVersionService.findByCondition(feVersionVO);
            if (feVersionList instanceof Page) {
                Page page = (Page) feVersionList;
                return Result.ok(feVersionList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
            }
            return Result.ok(feVersionList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/all-list")
    @SysLog(module = "获取版本全部数据", operationType = "查看", desc = "")
    public Result getAllList(FeVersionVO feVersionVO) {
        try {
            return Result.ok(feVersionService.findAll(feVersionVO));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    @SysLog(module = "增加版本", operationType = "增加", desc = "")
    public Result save(@RequestBody FeVersion feVersion) {
        try {
            feVersionService.save(feVersion);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/update")
    @SysLog(module = "修改版本", operationType = "修改", desc = "")
    public Result update(@RequestBody FeVersion feVersion) {
        try {
            feVersionService.update(feVersion);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    @SysLog(module = "删除版本", operationType = "删除", desc = "")
    public Result remove(@PathVariable Integer id) {
        try {
            feVersionService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
}
