package com.syrah.SpringAPIproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/add")
    public String getAdd() {
        return "add";
    }

    @GetMapping("/delete")
    public String getDelete() {
        return "delete";
    }

    @GetMapping("/list")
    public String getList() {
        return "list";
    }

    @GetMapping("/update")
    public String updateList() {
        return "update";
    }

    @GetMapping("*")
    public String getDefault() {
        return "redirect:/";
    }
}

