package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Optional<Accident> accident = accidents.findById(id);
        if (accident.isEmpty()) {
            model.addAttribute("message", "Инцидент с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("accident", accident);
        return "one";
    }

    @PostMapping("/update")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }

}