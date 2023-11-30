package com.easytable.api;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.easytable.api.service.BusinessService;








@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private BusinessService bs;

    
	@Test
	void contextLoads() {
	}
	
    @Test
    public void testGetHelloWorld() {
        String expected = "Hola mundo cruel";
        String result = bs.getHelloWorld().getValue();
        assertEquals(expected, result);
    }

	
	

}
