package com.example.studentappnew_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @GetMapping("/")
    public String Homepage()
    {
        return "Welcome to my website";
    }

    @GetMapping("/contact")
    public String Contactpage()
    {
        return "welcome to my contact page";
    }
    @GetMapping("gallary")
    public String Gallarypage()
    {
        return "welcome to my Gallary";
    }
    @GetMapping("home")
    public String Homepage2()
    {
        return "welcome to my homepage";
    }
}
