package com.springboot.controller;

import com.springboot.entity.PersonEntity;
import com.springboot.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SpringBoot004Controller {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/wow")
    public String Wow(){

        return "Hello Wow!!! This is for Subclass....";
    }

    @RequestMapping("/findall")
    @ResponseBody
    public List<PersonEntity> findall(){
        System.out.println(personDao.findAll());

        return personDao.findAll();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "wow";
    }

}
