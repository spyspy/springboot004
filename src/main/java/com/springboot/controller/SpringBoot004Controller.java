package com.springboot.controller;

import com.springboot.dao.ExtendRepository;
import com.springboot.dao.PersonDao;
import com.springboot.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SpringBoot004Controller {

    @Autowired
    PersonDao personDao;

    @Autowired
    ExtendRepository extendRepository;

    @RequestMapping(value = "/wow", method = {RequestMethod.POST, RequestMethod.GET})
    public String wow() {

        return "Hello Wow!!! This is for Subclass....";
    }

    @RequestMapping(value = "/findall", method = {RequestMethod.POST, RequestMethod.GET})
//    @ResponseBody //Use RestController. No need to use @ReponseBody
    public List<PersonEntity> findall() {
        System.out.println(personDao.findAll());

        return personDao.findAll();
    }

    @RequestMapping(value = "/findone/{id}", method = {RequestMethod.POST, RequestMethod.GET})
//    @ResponseBody
    public List<PersonEntity> findone(@PathVariable("id") Integer id) {
        List<Integer> listString = new ArrayList<>();
        listString.add(id);
        System.out.println(personDao.findAll());

        return personDao.findAllById(listString);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
//    @ResponseBody
    public String save() {
        PersonEntity personEntity = new PersonEntity();
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = today.format(formatter);
        String address = "Add-" + formatDateTime;
        String name = "Name-" + formatDateTime;
        personEntity.setAddress(address);
        personEntity.setName(name);
        extendRepository.save(personEntity);
        return "You Save a new Data !! " + name + " || " + address;
    }

}
