package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Service
public class FileUploadServiceImp implements FileUploadService {


    //Get Server's real path for file location
    @Override
    public String getServerUploadPath() {
        Path basePath = Paths.get("./").toAbsolutePath().normalize();
        System.out.println("basePath:"+basePath);
        String serverUploadPath  = basePath+"\\src\\main\\resources\\uploadfileBox\\";
        System.out.println("serverUploadPath:"+serverUploadPath);
        return serverUploadPath;
    }

    //Save Files From  Web page to Disk C:/test/
    @Override
    public void saveUploadedFiles(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException {

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


        InputStream fileContent = part.getInputStream();

        String serverUploadPath = getServerUploadPath();

        //Save in the real path of the server
        File targetFile2 = new File(serverUploadPath+file.getOriginalFilename());
        OutputStream outStream2 = new FileOutputStream(targetFile2);
        outStream2.write(buffer);
        outStream2.close();


        //Save in DB?  Save as BLOB?
    }

    //Zip one file
    //https://www.baeldung.com/java-compress-and-uncompress
    @Override
    public void zipSingleFile(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException {
        String targetFileName = file.getOriginalFilename()+".zip";

        String serverUploadPath = getServerUploadPath();

        FileOutputStream fos = new FileOutputStream(serverUploadPath+targetFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);

        zos.putNextEntry(new ZipEntry(file.getOriginalFilename()));

        InputStream in = file.getInputStream();
        byte[] bytes = new byte[in.available()];
        in.read(bytes);

        zos.write(bytes,0,bytes.length);
        zos.closeEntry();
        zos.close();
    }

    //Save Files From  Web page to Server /uploadFiles/

}
