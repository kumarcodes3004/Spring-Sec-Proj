package com.satyam.Spring_Sec_Proj.service;

import com.satyam.Spring_Sec_Proj.model.User;
import com.satyam.Spring_Sec_Proj.model.UserPrincipal;
import com.satyam.Spring_Sec_Proj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =userRepo.findByUserName(username);

        if(user ==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return  new UserPrincipal(user);
    }
}
