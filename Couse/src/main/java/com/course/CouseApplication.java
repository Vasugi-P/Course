package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(scanBasePackages = {"com.course"})
public class CouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouseApplication.class, args);
	}


}
