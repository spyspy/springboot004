package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@Configuration
//@ComponentScan
//@SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class, FileUploadController.class})
//Not Necessary use "scanBasePackageClasses" to specify the controller.
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //Exculde: Spring Security Auto Configuration
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
