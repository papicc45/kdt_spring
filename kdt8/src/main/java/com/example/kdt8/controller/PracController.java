package com.example.kdt8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracController {

    @GetMapping("/introduce/{name}")
    public String prac1(@PathVariable(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/introduce2")
    public String prac2(@RequestParam String name,
                                    @RequestParam int age,
                                    Model model) {
        model.addAttribute("name", name)
                .addAttribute("age", age);
        return "response";
    }

    @PostMapping("/prac")
    public String prac3(@RequestParam String name, @RequestParam String gender,
                                    @RequestParam int year, @RequestParam int month, @RequestParam int day,
                                    @RequestParam String[] interest, Model model) {
        model.addAttribute("name", name)
                .addAttribute("gender", gender)
                .addAttribute("year", year)
                .addAttribute("month", month)
                .addAttribute("day", day)
                .addAttribute("interests", interest);

        return "response";
    }
}
