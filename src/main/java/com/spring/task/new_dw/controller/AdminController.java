package com.spring.task.new_dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminController() {

    }

    @GetMapping
    public String get() {
        return "";
    }

}
