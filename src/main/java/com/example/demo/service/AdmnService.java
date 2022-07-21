package com.example.demo.service;

import com.example.demo.controller.AdminController;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.form.CreateAdminForm;
import com.example.demo.form.CreateUserForm;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AdmnService
{
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminEntity> getAll()
    {
        Iterator<AdminEntity> adminIt = adminRepository.findAll().iterator();
        List<AdminEntity> admins = new ArrayList<>();

        adminIt.forEachRemaining(admins::add);

        return admins;
    }

    public AdminEntity getAdminById(Long id){
        return adminRepository.findById(id).get();
    }

    public void createAdmin(CreateAdminForm createAdminForm)
    {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setUserName(createAdminForm.getUserName());
        adminEntity.setPassword(createAdminForm.getPassword());

        adminRepository.save(adminEntity);
    }
}
