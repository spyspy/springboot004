package com.springboot.controller;

import com.springboot.dao.Person;
import com.springboot.dao.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SpringBoot004Controller {

    @Autowired
    PersonRepo personRepo;

    @RequestMapping("/wow")
    public String Wow(){

        return "Hello Wow!!! This is for Subclass....";
    }

    @RequestMapping("/findall")
    @ResponseBody
    public List<Person> findall(){
        System.out.println(personRepo.findAll());
        return personRepo.findAll();
    }

}
