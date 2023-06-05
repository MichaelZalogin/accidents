package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final AccidentService accidents;

    @GetMapping("/addAccident")
    public String viewCreateAccident() {
        return "addAccident";
    }

    @PostMapping("/addAccident")
    public String save(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/index";
    }
}