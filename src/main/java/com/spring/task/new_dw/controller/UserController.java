package com.spring.task.new_dw.controller;


import com.spring.task.new_dw.entity.User;
import com.spring.task.new_dw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        Collection<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/registration")
    public String getUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

    @PutMapping //Добавить проверку ид
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }
}
