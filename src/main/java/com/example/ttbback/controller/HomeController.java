package com.example.ttbback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping
    public String helloWorld(){
        return "Hello World";
    }
}
