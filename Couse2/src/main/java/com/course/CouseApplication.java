package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput.Enabled;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;




@SpringBootApplication(scanBasePackages = {"com.course"})
@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL })
public class CouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouseApplication.class, args);
	}


}
