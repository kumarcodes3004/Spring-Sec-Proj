package com.satyam.Spring_Sec_Proj.controller;

import com.satyam.Spring_Sec_Proj.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "satyam", "Java"),
            new Student(2, "aman", "react")
    ));

   //if we make it stateless we won't be needing the csrf-token , we will be sending username and pwd everytime in request
    @GetMapping("/csrf-token")
    public CsrfToken getcsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
