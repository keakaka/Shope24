package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before	
	public void setUp() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}
	
//	public void insertDefaultCategory() {
//		
//		CategoryVo vo = new CategoryVo();
//		vo.setName("하의");
//		sqlSession.insert("admin.insertCategory", vo);
//		
//		CategoryVo vo2 = new CategoryVo();
//		vo2.setName("청바지");
//		vo2.setRefNo(1L);
//		sqlSession.insert("admin.insertCategory", vo);
//	}
	
//	@After
//	public void teadDown() {
//		sqlSession.delete("test.deleteAllCategory");
//		sqlSession.update("test.defaultCategoryIncrement");
//	}
	
@Ignore	
	@Test
	public void serviceDITest() {
		assertNotNull(adminService);
	}
	
@Ignore
	@Test
	public void controllerMappingTest() throws Exception{
		mockMvc.perform(get("/api/admin")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void showProductManagement() throws Exception{
		mockMvc.perform(get("/api/admin/productManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void showCategory() throws Exception{
		
		mockMvc.perform(get("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void insertCategory() throws Exception{
//		insertDefaultCategory();
		
//		CategoryVo vo = new CategoryVo();
//		vo.setName("가방");
//		mockMvc.perform(post("/api/admin/productManager/category")
//				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)))
//				.andExpect(status().isOk());
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("하의");
		vo2.setGroupNo(1L);
		vo2.setGroupSeq(1L);
		vo2.setDepth(0L);
		
		mockMvc.perform(post("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo2)))
				.andDo(print())
				.andExpect(status().isOk());
	}
		
		
@Ignore
	@Test
	public void deleteCategory() throws Exception{
	
		CategoryVo vo = new CategoryVo();
		vo.setNo(5L);
		vo.setGroupNo(1L);
		vo.setGroupSeq(4L);
		mockMvc.perform(delete("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(vo)))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void updateCategory() throws Exception{
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		CategoryVo vo = new CategoryVo();
		vo.setNo(1L);
		vo.setName("의류");
		vo.setGroupNo(1L);
		vo.setGroupSeq(1L);
		vo.setDepth(0L);
		list.add(0, vo);
		
		vo = new CategoryVo();
		vo.setNo(3L);
		vo.setName("상의");
		vo.setGroupNo(1L);
		vo.setGroupSeq(2L);
		vo.setDepth(1L);
		list.add(1, vo);
		
		vo = new CategoryVo();
		vo.setNo(10L);
		vo.setName("셔츠");
		vo.setGroupNo(1L);
		vo.setGroupSeq(3L);
		vo.setDepth(2L);
		list.add(2, vo);
		
		vo = new CategoryVo();
		vo.setNo(11L);
		vo.setName("하의");
		vo.setGroupNo(1L);
		vo.setGroupSeq(4L);
		vo.setDepth(1L);
		list.add(3, vo);
		
		vo = new CategoryVo();
		vo.setNo(2L);
		vo.setName("신발");
		vo.setGroupNo(2L);
		vo.setGroupSeq(1L);
		vo.setDepth(0L);
		list.add(4, vo);
		
		vo = new CategoryVo();
		vo.setNo(4L);
		vo.setName("스니커즈");
		vo.setGroupNo(2L);
		vo.setGroupSeq(2L);
		vo.setDepth(1L);
		list.add(5, vo);
		
		vo = new CategoryVo();
		vo.setNo(8L);
		vo.setName("가방");
		vo.setGroupNo(3L);
		vo.setGroupSeq(1L);
		vo.setDepth(0L);
		list.add(6, vo);
			
		mockMvc.perform(put("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(list)))
//				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void showProduct() throws Exception{
		mockMvc.perform(get("/api/admin/productManager/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void insertProduct() throws Exception{
		mockMvc.perform(post("/api/admin/productManager/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}	
	
@Ignore
	@Test
	public void updateProduct() throws Exception{
		mockMvc.perform(put("/api/admin/productManager/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void customerManagement() throws Exception{
		mockMvc.perform(get("/api/admin/customerManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	
@Ignore
	@Test
	public void deleteMember() throws Exception{
		mockMvc.perform(delete("/api/admin/customerManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void ordermanagement() throws Exception{
		mockMvc.perform(get("/api/admin/orderManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
@Ignore
	@Test
	public void updateOrder() throws Exception{
		mockMvc.perform(put("/api/admin/orderManager")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
