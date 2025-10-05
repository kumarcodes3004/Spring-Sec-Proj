package com.satyam.Spring_Sec_Proj.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> greetHello(HttpServletRequest req){
        return new ResponseEntity<>("Hello Satyam!! How are you? \n Session: "+req.getSession().getId(), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(HttpServletRequest req){
        return new ResponseEntity<>("This site is in process \n Session: "+req.getSession().getId(), HttpStatus.OK);
    }
}
