package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileUploadController {

    private static String UPLOADED_FOLDER = ".//upload//";

    //2020/06/12 upload Test
    @GetMapping("/uploadFiles")
    public String listUploadedFiles(Model model) throws IOException {

        System.out.println("Entering (GET) listUploadedFiles.......");

        return "uploadFiles";
    }


    @PostMapping("/uploadFiles")
    public String sendPostUploadFiles(Model model,@RequestParam("file") MultipartFile multipartFile) throws IOException {

        System.out.println("Entering (POST) sendPostUploadFiles.......");
        System.out.println("multipartFile.getName(): "+multipartFile.getName() +" " +multipartFile.getOriginalFilename());

        saveUploadedFiles(multipartFile);

        return "redirect:/uploadFiles";
    }

    //Save Files From  Web page to Disk C:/test/
    private void saveUploadedFiles(MultipartFile file) throws IOException {
        InputStream initialStream = file.getInputStream();

        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);
        File targetFile = new File("C://test//"+file.getOriginalFilename());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();

    }

    //Save Files From  Web page to Server /uploadFiles/

}
