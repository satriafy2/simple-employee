package com.satriadwi.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.satriadwi.employee.dto.EmployeeDto;


@ContextConfiguration(classes = EmployeeApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void successCreateEmployee() throws Exception {
		EmployeeDto employee = new EmployeeDto("Dodit", 500000.0, 1);
		RequestBuilder request = MockMvcRequestBuilders
			.post("/employee")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(employee))
			.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(request)
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andReturn();
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(employee.getName(), JsonPath.read(content, "name"));
		assertEquals(employee.getSalary(), JsonPath.read(content, "salary"));
	}

	@Test
	void successGetEmployees() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
			.get("/employee")
			.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
