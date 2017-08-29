package com.cyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:spring-all.xml")
@EnableTransactionManagement
public class WebDecorationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebDecorationApplication.class, args);
	}

}