package com.satyam.Spring_Sec_Proj.controller;

import com.satyam.Spring_Sec_Proj.model.User;
import com.satyam.Spring_Sec_Proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User>  register(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
