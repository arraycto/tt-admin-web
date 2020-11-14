package com.tt.admin.controller;

import com.github.pagehelper.Page;
import com.tt.admin.annotation.SysLog;
import com.tt.common.vo.Result;
import com.tt.admin.model.Log;
import com.tt.admin.service.LogService;
import com.tt.admin.vo.LogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/admin/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/list")
    @SysLog(module = "获取日志分页数据", operationType = "查看", desc = "")
    public Result getPageList(LogVO logVO) {
        try {
            List<Log> logList = logService.findByCondition(logVO);
            if (logList instanceof Page) {
                Page page = (Page) logList;
                return Result.ok(logList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
            }
            return Result.ok(logList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/all-list")
    @SysLog(module = "获取日志全部数据", operationType = "查看", desc = "")
    public Result getAllList(LogVO logVO) {
        try {
            return Result.ok(logService.findAll(logVO));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    @SysLog(module = "增加日志", operationType = "增加", desc = "")
    public Result save(@RequestBody Log syslog) {
        try {
            logService.save(syslog);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/update")
    @SysLog(module = "修改日志", operationType = "修改", desc = "")
    public Result update(@RequestBody Log syslog) {
        try {
            logService.update(syslog);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    @SysLog(module = "删除日志", operationType = "删除", desc = "")
    public Result remove(@PathVariable Integer id) {
        try {
            logService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
}
