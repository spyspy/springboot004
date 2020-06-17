package com.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface FileUploadService {

    public String getServerUploadPath();

    public void saveUploadedFiles(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException;

    public void zipSingleFile(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException;

}
