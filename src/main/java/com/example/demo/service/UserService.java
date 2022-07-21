package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.CreateUserForm;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAll()
    {
        Iterator<UserEntity> usersIt = userRepository.findAll().iterator();
        List<UserEntity> users = new ArrayList<>();

        usersIt.forEachRemaining(users::add);

        return users;
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void createUser(CreateUserForm createUserForm)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserForm.getName());
        userEntity.setLastName(createUserForm.getLastName());
        userEntity.setUserName(createUserForm.getUserName());
        userEntity.setPassword(createUserForm.getPassword());

        userRepository.save(userEntity);
    }
}
