package com.vd.project.vital.vital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.vd.project.vital.vital.services.MotherServices;
@Import(ApplicationConfig.class)
@SpringBootTest()
public class MotherServicesTest {
	
	@Autowired	
	MotherServices motherServices; 
	
//	@Before
//	public void testbefore()
//	{
//		test(101);
//		
//	}
@Test
public void test()
{
	assertSame("unsuccess",motherServices.getmother(101l));
}

}
