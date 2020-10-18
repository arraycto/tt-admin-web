package com.tt.admin.controller;

import com.github.pagehelper.Page;
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
@RequestMapping("/system/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/list")
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
    public Result getAllList(LogVO logVO) {
        try {
            return Result.ok(logService.findAll(logVO));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    public Result save(@RequestBody Log syslog) {
        try {
            logService.save(syslog);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/update")
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
