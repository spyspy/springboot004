package com.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileUploadService {

    public String getServerUploadPath();

    public void saveUploadedFiles(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException;

    public void zipSingleFile(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException;

    public void downloadTextFile(HttpServletResponse response) throws IOException;

    public void makeTextFile();

    //How To Read a static file on the server
    public void readStaticFile() throws IOException;

    public void getFilesList() throws IOException;
}
