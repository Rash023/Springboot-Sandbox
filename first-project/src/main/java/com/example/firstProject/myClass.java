package com.example.firstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myClass {

    @Autowired
    private Dog dog;

    @GetMapping("abc")
    public String sayHello(){
        return dog.fun();
    }
}
