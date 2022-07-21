package com.example.demo.entity;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminEntity extends BaseEntity {
    String userName;
    String password;

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

    public AdminDTO toDTO(){
        return AdminDTO
            .builder()
            .id(this.getId())
            .userName(this.getUserName())
            .password(this.getPassword())
            .build();
    }
}
