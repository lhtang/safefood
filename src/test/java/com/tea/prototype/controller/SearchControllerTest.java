package com.tea.prototype.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SearchControllerTest {
	
	 @Autowired
	 private WebApplicationContext wac;
	 
	 private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testLoadSearchCriteriaForm() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk())
	     .andExpect(view().name("search"))
	     .andExpect(model().attributeExists("searchCriteriaBean"));
	}

	@Test
	public void testHandleSearchSubmit() throws Exception {
		mockMvc.perform(post("/search")).andExpect(status().isOk())
	     .andExpect(view().name("results"))
	     .andExpect(model().attributeExists("searchParms"))
	     .andExpect(model().attributeExists("searchCriteriaBean"));
	}

}
