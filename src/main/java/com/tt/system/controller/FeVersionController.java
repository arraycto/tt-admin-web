package com.tt.system.controller;

import com.github.pagehelper.Page;
import com.tt.system.annotation.Permission;
import com.tt.common.vo.Result;
import com.tt.system.vo.FeVersionVO;
import com.tt.system.model.FeVersion;
import com.tt.system.service.FeVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/system/feVersion")
@Permission(value = {"SUPER_ADMIN"})
public class FeVersionController {

    @Autowired
    private FeVersionService feVersionService;

    @GetMapping("/list")
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
    public Result getAllList(FeVersionVO feVersionVO) {
        try {
            return Result.ok(feVersionService.findAll(feVersionVO));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    public Result save(@RequestBody FeVersion feVersion) {
        try {
            feVersionService.save(feVersion);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/update")
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
