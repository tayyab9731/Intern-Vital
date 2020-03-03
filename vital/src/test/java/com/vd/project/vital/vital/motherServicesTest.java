package com.vd.project.vital.vital;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.vd.project.vital.vital.services.motherServices;
@ComponentScan("com.vd.project.vital.vital.services")
public class motherServicesTest {
	@Autowired
	
	motherServices test; 
//	@Before
//	public void testbefore()
//	{
//		test(101);
//		
//	}
@Test
public void test()
{assertEquals("Mother id not found : 101" ,test.getmother(101l));
}

}
