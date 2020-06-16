package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

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
    public String sendPostUploadFiles(Model model, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpRequest) throws IOException, ServletException {

        System.out.println("Entering (POST) sendPostUploadFiles.......");
        System.out.println("multipartFile.getName(): "+multipartFile.getName() +" " +multipartFile.getOriginalFilename());

        saveUploadedFiles(multipartFile,httpRequest);

        return "finish";
    }

    //Use Axios to send a post request from the front-end
    //When get a json object. We use "POST" and "@RequestBody Map<String,String> params" to get json object.
    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestBody Map<String,String> params) throws IOException {

        System.out.println("test....");
        System.out.println("test...."+params);


//        return "redirect:/uploadFiles";
        return "testEmpty";
    }

    //Save Files From  Web page to Disk C:/test/
    private void saveUploadedFiles(MultipartFile file,HttpServletRequest httpRequest) throws IOException, ServletException {
        InputStream initialStream = file.getInputStream();

        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        //Save in Disk
        File targetFile = new File("C://WebUploadTest//"+file.getOriginalFilename());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();

        //Save in Server
        //Get Real Path First
        Part part = httpRequest.getPart("file");//Form's input name
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        System.out.println("fileName:"+fileName);
        Path basePath = Paths.get("./").toAbsolutePath().normalize();
        System.out.println("basePath:"+basePath);
        String serverUploadPath  = basePath+"\\src\\main\\resources\\uploadfileBox\\";
        System.out.println("serverUploadPath:"+serverUploadPath);

        InputStream fileContent = part.getInputStream();

        //Save in the real path of the server
        File targetFile2 = new File(serverUploadPath+file.getOriginalFilename());
        OutputStream outStream2 = new FileOutputStream(targetFile2);
        outStream2.write(buffer);
        outStream2.close();


        //Save in DB?  Save as BLOB?
    }

    //Save Files From  Web page to Server /uploadFiles/

}
