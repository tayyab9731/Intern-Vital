package com.vd.project.vital.vital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vd.project.vital.vital.services")
public class VitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalApplication.class, args);
	}

}
