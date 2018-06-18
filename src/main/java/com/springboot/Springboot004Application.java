package com.springboot;

import com.springboot.controller.SpringBoot004Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class})
public class Springboot004Application {

	public static void main(String[] args) {
		System.out.println("Let's goooooooo!!!!");
		SpringApplication.run(Springboot004Application.class, args);
		System.out.println("Let's homehome!!!!");
	}
}

/**
 * @SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class})
 * When controller and Application are not in the same package.
 * We need to use "scanBasePackageClasses" to tell the app to scan controller in subclass...
 *
 * */
