package com.easytable.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.easytable.api.controller.EmployeeController;
import com.easytable.api.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
    @MockBean
    private EmployeeService employeeService;
    
    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].firstName", is("Laurent")));
    }
    
	
//	@Test
//	public void testGetEmployees() throws Exception {
//		
//		mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));
//		
//	}
	
}
