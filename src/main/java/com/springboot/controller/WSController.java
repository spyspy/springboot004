package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.thread.ThreadExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class WSController {

    @Autowired
    Student student;

    //Difference between the annotations @GetMapping and @RequestMapping(method = RequestMethod.GET) ?
    //https://stackoverflow.com/questions/39077787/difference-between-the-annotations-getmapping-and-requestmappingmethod-requ


    //Web Service without parameter
    //Get Single Student Info
    @RequestMapping("/getstudentinfo")
    public Student getStudentInfo(){

        student.setName("Apple");
        student.setAddress("My Home");
        student.setHobby("Play fire");

        return student;
    }

    //Web Service without parameter
    //Get Multiple Students Info List
    @RequestMapping("/getstudentinfolist")
    public List<Student> getStudentInfoList(){
        List<Student> listStu = new ArrayList<>();

        Student stu1 = new Student();
        Student stu2 = new Student();
        Student stu3 = new Student();

        stu1.setName("Apple");
        stu1.setAddress("My Home");
        stu1.setHobby("Play fire");

        stu2.setName("Banana");
        stu2.setAddress("Banana Street Home");
        stu2.setHobby("Play Banana");

        stu3.setName("Cindy");
        stu3.setAddress("Cindy Road City");
        stu3.setHobby("Play Cindy");

        listStu.add(stu1);
        listStu.add(stu2);
        listStu.add(stu3);

        return listStu;
    }

    //Thread Test
    @RequestMapping("/threadtest")
    public Map<String,Object> getThreadtest() throws InterruptedException {


        LocalDateTime nowTime1 = LocalDateTime.now();

        TimeUnit.SECONDS.sleep(3); // Delay for .... Second

        LocalDateTime nowTime2 = LocalDateTime.now();

        String rtn = nowTime1.toString() +" || "+ nowTime2.toString();

        //Generate Return Object
        Map<String,Object> mymap = new HashMap<>();
        mymap.put("Time 1",nowTime1.toString());
        mymap.put("Time 2",nowTime2.toString());

        //Thread Test
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1;i<=5;i++){
            System.out.println("for's i:"+i);

            es.execute(new ThreadExample());
        }

        /**
         * Result:
         *
         * doControllerBefore: Before Before!!!
         * i:1
         * i:2
         * i:3
         * run pool-1-thread-1 thread
         * run pool-1-thread-2 thread
         * i:4
         * i:5
         * run pool-1-thread-3 thread
         * run pool-1-thread-4 thread
         * doControllerAfterReturning: After After
         * run pool-1-thread-5 thread
         *
         */

        return mymap;
    }



}
