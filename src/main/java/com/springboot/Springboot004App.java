package com.springboot;

import com.springboot.controller.FileUploadController;
import com.springboot.controller.SpringBoot004Controller;
import com.springboot.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

//@Configuration
//@ComponentScan
//@SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class, FileUploadController.class})
//Not Necessary use "scanBasePackageClasses" to specify the controller.
@SpringBootApplication
public class Springboot004App {

	public static void main(String[] args) {
		System.out.println("Let's GO APP  !!------STRAT");
		SpringApplication.run(Springboot004App.class, args);
		System.out.println("Let's END APP !!------END");
	}
}

/**
 * @SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class})
 * When controller and Application are not in the same package.
 * We need to use "scanBasePackageClasses" to tell the app to scan controller in subclass...
 *
 * */
