package com.tt.system.controller;

import com.tt.system.model.SysFeVersion;
import com.tt.system.service.SysFeVersionService;
import com.tt.system.vo.SysFeVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private SysFeVersionService sysFeVersionService;

    @GetMapping("/")
    public String index(Model model) {
        SysFeVersionVO sysFeVersionVO = new SysFeVersionVO();
        Optional<SysFeVersion> first = sysFeVersionService.findAll(sysFeVersionVO).stream().findFirst();
        first.ifPresent(feVersionVO -> model.addAttribute("version", "/" + feVersionVO.getFeVersion()));
        return "index";
    }

}
