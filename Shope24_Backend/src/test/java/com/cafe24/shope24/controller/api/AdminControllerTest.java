package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shope24.config.app.test.AppConfig;
import com.cafe24.shope24.config.web.test.WebConfig;
import com.cafe24.shope24.service.AdminService;
import com.cafe24.shope24.vo.CategoryVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class AdminControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before	
	public void setUp() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}
//@Ignore	
	@Test
	public void serviceDITest() {
		assertNotNull(adminService);
	}
	
//@Ignore
	@Test
	public void controllerMappingTest() throws Exception{
		mockMvc.perform(get("/api/admin")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void showProductManagement() throws Exception{
		mockMvc.perform(get("/api/admin/productManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void showCategory() throws Exception{
		mockMvc.perform(get("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void insertCategory() throws Exception{
		
		CategoryVo vo = new CategoryVo();
		vo.setName("상의");
		
		mockMvc.perform(post("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)))
				.andDo(print())
				.andExpect(status().isOk());
		
		vo.setName("맨투맨");
		
		mockMvc.perform(post("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data", hasSize(2)))
				.andExpect(jsonPath("$.data[0].name", is("상의")))
				.andExpect(jsonPath("$.data[0].name", is("맨투맨")));
	}
		
		
//@Ignore
	@Test
	public void deleteCategory() throws Exception{
		mockMvc.perform(delete("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
