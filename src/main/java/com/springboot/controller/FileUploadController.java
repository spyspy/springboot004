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
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Controller
public class FileUploadController {

    private static String UPLOADED_FOLDER = ".//upload//";

    @Autowired
    FileUploadService fileUploadService;

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
        downloadTextFile(response);

        makeTextFile();

        response.flushBuffer();
    }


    public void downloadTextFile(HttpServletResponse response) throws IOException {
        response.reset();
        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        response.setHeader("Content-Disposition", "attachment; filename=myfile"+timeLog+".txt");
        response.setContentType("text/plain");
        OutputStream outStream = response.getOutputStream();
        byte[] buf = new byte[4096];
        int len = -1;

        String textContent ="This is my test \n Wow wow Wow";


        InputStream result = new ByteArrayInputStream(textContent.getBytes(StandardCharsets.UTF_8));
        System.out.println("IIIIIIIIIIIIIIIIIIIIII");
//Write the file contents to the servlet response
//Using a buffer of 4kb (configurable). This can be
//optimized based on web server and app server
//properties
        while ((len = result.read(buf)) != -1) {
            outStream.write(buf, 0, len);
        }

        outStream.flush();
        outStream.close();
        System.out.println("XXXXXXXXXXXXXXXXXXXXX");

    }


    public void makeTextFile(){
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog+".txt");
            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("Hello world!");



            //Download location example:
            //C:\Users\OOOOOOOOO\IdeaProjects\springboot004\20200706_194433

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //JAVA 7 up to make a text file
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("the-file-name.txt");
        try{
            Files.write(file, lines, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        //End



    }
}
