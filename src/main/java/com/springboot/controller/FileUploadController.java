package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class FileUploadController {
    //2020/06/12 upload Test
    @RequestMapping("/uploadFiles")
    public String listUploadedFiles(Model model) throws IOException {

        System.out.println("Entering listUploadedFiles.......");

        return "uploadFiles";
    }
}
