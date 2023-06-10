package com.mch.accidents.controller;

import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping({"/", "index"})
public class IndexController {

    private final AccidentService accidentService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", "Michael");
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }

}