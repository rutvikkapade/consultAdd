package com.consultadd.CRUD.service;

import com.consultadd.CRUD.model.User;
import com.consultadd.CRUD.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("this username dpes not exist");
        }
        return new MyUserDetails(user);
    }
    
}
