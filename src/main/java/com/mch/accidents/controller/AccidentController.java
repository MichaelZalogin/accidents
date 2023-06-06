package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("accidents")
public class AccidentController {

    private final AccidentService accidents;

    @GetMapping("/add")
    public String viewCreateAccident() {
        return "addAccident";
    }

    @PostMapping("/add")
    public String saveAccident(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/index";
    }

    @GetMapping("/{id}")
    public String viewOneAccident(Model model, @PathVariable int id) {
        model.addAttribute("accident", accidents.findById(id));
        return "one";
    }

    @PostMapping("/update")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }

}