package com.vd.project.vital.vital;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vd.project.vital.vital.interfaces.MotherServicesImpl;


public class ApplicationConfig {
	 
	@Bean(name = "motherServices")
	    public MotherServicesImpl getMotherService() {
	        return new MotherServicesImpl();
	    }
}
