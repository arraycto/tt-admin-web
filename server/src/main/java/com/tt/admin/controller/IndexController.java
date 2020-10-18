package com.tt.admin.controller;

import com.tt.admin.model.FeVersion;
import com.tt.admin.service.FeVersionService;
import com.tt.admin.vo.FeVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private FeVersionService feVersionService;

    @GetMapping("/")
    public String index(Model model) {
        FeVersionVO sysFeVersionVO = new FeVersionVO();
        Optional<FeVersion> first = feVersionService.findAll(sysFeVersionVO).stream().findFirst();
        first.ifPresent(feVersionVO -> model.addAttribute("version", "/" + feVersionVO.getFeVersion()));
        return "index";
    }

}
