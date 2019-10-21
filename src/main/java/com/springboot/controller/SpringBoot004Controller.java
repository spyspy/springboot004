package com.springboot.controller;

import com.springboot.entity.PersonEntity;
import com.springboot.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class SpringBoot004Controller {

    @Autowired
    PersonDao personDao;
    @RequestMapping(value = "/wow", method = {RequestMethod.POST,RequestMethod.GET})
    public String Wow(){

        return "Hello Wow!!! This is for Subclass....";
    }

    @RequestMapping(value ="/findall", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<PersonEntity> findall(){
        System.out.println(personDao.findAll());

        return personDao.findAll();
    }

    @RequestMapping(value ="/findone/{id}", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<PersonEntity> findone(@PathVariable("id") Integer id){
        List<Integer> listString = new ArrayList<Integer>();
        listString.add(id);
        System.out.println(personDao.findAll());

        return (List<PersonEntity>) personDao.findAllById(listString);
    }

    @RequestMapping(value = "/test", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String test(){
        return "wow";
    }

}
