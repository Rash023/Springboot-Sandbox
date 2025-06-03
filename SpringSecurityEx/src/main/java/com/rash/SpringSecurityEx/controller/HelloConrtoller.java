package com.rash.SpringSecurityEx.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConrtoller {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to Spring Security Example" + " "+ request.getSession().getId();
    }
}
