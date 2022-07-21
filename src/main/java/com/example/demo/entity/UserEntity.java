package com.example.demo.entity;

import com.example.demo.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    String name;
    String lastName;
    String userName;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO toDTO(){
        return UserDTO
            .builder()
            .id(this.getId())
            .name(this.getName())
            .lastName(this.getLastName())
            .userName(this.getUserName())
            .password(this.getPassword())
            .build();
    }
}
