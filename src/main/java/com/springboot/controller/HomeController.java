package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Home page
    @GetMapping("/")
    public String home(){
        return "projecthome";
    }

    //Go to Child-folder's website
    @GetMapping("/pathtest")
    public String pathtest(){
        return "/path/path";
    }
}
