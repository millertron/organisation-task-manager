package com.millertronics.otm.webapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final RestTemplate restTemplate;

    @GetMapping
    public String index(Model model) {
        Map<String, String> data = new HashMap<>();
        data.put("Task 1", "Do task 1");
        data.put("Task 2", "Do task 2");
        model.addAttribute("username", "Millertron");
        model.addAttribute("data", data);
        return "home";
    }

}
