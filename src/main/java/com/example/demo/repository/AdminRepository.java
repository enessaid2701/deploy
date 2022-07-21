package com.example.demo.repository;

import com.example.demo.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Long>
{
    AdminEntity findAdminEntityByUserName(String userName);
}
