package com.example.demo.controller;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.form.CreateAdminForm;
import com.example.demo.service.AdmnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController
{
    @Autowired
    private AdmnService adminService;

    @PostMapping(value = "/create")
    private String CreateAdmin(@ModelAttribute CreateAdminForm createAdminForm)
    {
        adminService.createAdmin(createAdminForm);
        return "redirect:/admin/get-admin-admin";
    }

    @GetMapping(value = "/{userId}")
    private String getAdminById(@PathVariable("userId") Long adminId, Model model)
    {
        AdminEntity adminEntity = adminService.getAdminById(adminId);

        CreateAdminForm createAdminForm = new CreateAdminForm();

        createAdminForm.setUserName(adminEntity.getUserName());
        createAdminForm.setPassword(adminEntity.getPassword());

        model.addAttribute("adminPanel", adminService.getAll().stream().map(AdminEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createAdminForm", createAdminForm);

        return "/";
    }


}
