package com.springboot.controller;

import com.springboot.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@Controller
public class FileUploadController {

    private static String UPLOADED_FOLDER = ".//upload//";

    @Autowired
    FileUploadService fileUploadService;

    //2020/06/12 upload Test
    @GetMapping("/uploadFiles")
    public String listUploadedFiles(Model model) {
        System.out.println("Entering (GET) listUploadedFiles.......");
        String timeLog = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        model.addAttribute("serverTime", timeLog);

        List<String> files = Arrays.asList("File001.jpg","File002.xls","File003.WOW");

        model.addAttribute("files", files);

        return "uploadFiles";
    }

    @PostMapping("/uploadFiles")
    public String sendPostUploadFiles(Model model, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpRequest) throws IOException, ServletException {

        System.out.println("Entering (POST) sendPostUploadFiles.......");
        System.out.println("multipartFile.getName(): "+multipartFile.getName() +" " +multipartFile.getOriginalFilename());

        fileUploadService.saveUploadedFiles(multipartFile,httpRequest);
        fileUploadService.zipSingleFile(multipartFile,httpRequest);

        return "finish";
    }

    //Use Axios to send a post request from the front-end
    //When get a json object. We use "POST" and "@RequestBody Map<String,String> params" to get json object.
    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestBody Map<String,String> params) throws IOException {

        System.out.println("test method is calling....");
        System.out.println("input object: "+params);

//        return "redirect:/uploadFiles";
        return "testEmpty";
    }

    @GetMapping("/filelist")
    @ResponseBody
    public String getFileList() throws IOException{

        System.out.println("getFileList method is calling....");

        //To Get file List from.... Ex: C:\WebUploadTest\
        //Ref: https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
        //Java 8 + The try-with-resources
        try (Stream<Path> paths = Files.walk(Paths.get("C:/WebUploadTest/"))) {
            paths.filter(Files::isRegularFile).forEach(System.out::println);
        }

        return "testEmpty";
    }

    //Boostrap Test Example
    @RequestMapping(value = "/bootstrap", method = {RequestMethod.POST, RequestMethod.GET})
    public String bootstraptest() {

        return "bootstraptest";
    }


    @GetMapping(value = "/download")
    public void getDownlad(HttpServletResponse response) throws IOException {

        fileUploadService.downloadTextFile(response);

        fileUploadService.makeTextFile();

        fileUploadService.readStaticFile();

        response.flushBuffer();
    }

}
