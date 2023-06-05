package com.mch.accidents.controller;

import com.mch.accidents.repository.AccidentRepositoryMem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping({"/", "index"})
public class IndexController {

    private final AccidentRepositoryMem accidentRepositoryMem;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", "Michael");
        model.addAttribute("accidents", accidentRepositoryMem.findAll());
        return "index";
    }

}