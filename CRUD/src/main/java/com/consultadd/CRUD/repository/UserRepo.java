package com.consultadd.CRUD.repository;

import com.consultadd.CRUD.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String>{
    public User findByUsername(String username);
}
