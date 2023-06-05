package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("accident")
public class AccidentController {

    private final AccidentService accidents;

    @GetMapping("/add")
    public String viewCreateAccident() {
        return "addAccident";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/index";
    }

//    @GetMapping("/edit")
//    public String viewCreateAccident() {
//        return "editAccident";
//    }
//
//    @PostMapping("/edit")
//    public String save(@ModelAttribute Accident accident) {
//        accidents.edit(accident);
//        return "redirect:/index";
//    }

}