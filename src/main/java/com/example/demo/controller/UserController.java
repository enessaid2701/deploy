package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.CreateUserForm;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("useer")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    private String CreateUser(@ModelAttribute CreateUserForm createUserForm)
    {
        userService.createUser(createUserForm);
        return "redirect:/admin/get-admin-user";
    }

    @GetMapping(value = "/{userId}")
    private String getUserById(@PathVariable("userId") Long userId, Model model)
    {
        UserEntity userEntity = userService.getUserById(userId);

        CreateUserForm createUserForm = new CreateUserForm();

        createUserForm.setName(userEntity.getName());
        createUserForm.setLastName(userEntity.getLastName());
        createUserForm.setUserName(userEntity.getUserName());
        createUserForm.setPassword(userEntity.getPassword());

//        model.addAttribute("LoginPanelUser", userService.getAll().stream().map(UserEntity::toDTO).collect(Collectors.toList()));
//        model.addAttribute("createUserForm", createUserForm);

        return "/";

    }
}
