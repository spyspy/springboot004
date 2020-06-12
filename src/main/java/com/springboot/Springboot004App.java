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
@SpringBootApplication
public class Springboot004App {

	public static void main(String[] args) {
		System.out.println("Let's GOOOO!!!!---------STRAT");
		SpringApplication.run(Springboot004App.class, args);
		System.out.println("Let's HOMEHOME!!!!-----END");
	}



//	@Bean
//	public SpringResourceTemplateResolver templateResolver(){
//		// SpringResourceTemplateResolver automatically integrates with Spring's own
//		// resource resolution infrastructure, which is highly recommended.
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(this.applicationContext);
//		templateResolver.setPrefix("/webapp/templates/");
//		templateResolver.setSuffix(".html");
//		// HTML is the default value, added here for the sake of clarity.
//		templateResolver.setTemplateMode(TemplateMode.HTML);
//		// Template cache is true by default. Set to false if you want
//		// templates to be automatically updated when modified.
//		templateResolver.setCacheable(true);
//		return templateResolver;
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine(){
//		// SpringTemplateEngine automatically applies SpringStandardDialect and
//		// enables Spring's own MessageSource message resolution mechanisms.
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		// Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//		// speed up execution in most scenarios, but might be incompatible
//		// with specific cases when expressions in one template are reused
//		// across different data types, so this flag is "false" by default
//		// for safer backwards compatibility.
//		templateEngine.setEnableSpringELCompiler(true);
//		return templateEngine;
//	}

}

/**
 * @SpringBootApplication(scanBasePackageClasses = {SpringBoot004Controller.class})
 * When controller and Application are not in the same package.
 * We need to use "scanBasePackageClasses" to tell the app to scan controller in subclass...
 *
 * */
