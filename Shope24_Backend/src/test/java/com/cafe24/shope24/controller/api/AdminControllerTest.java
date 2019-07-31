package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shope24.config.app.test.AppConfig;
import com.cafe24.shope24.config.web.test.WebConfig;
import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.service.AdminService;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.DisplayProductVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.ProductVo;
import com.google.common.reflect.TypeToken;
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
//		sqlSession.insert("admin.insertCategory", vo);
//	}
//	
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
	
@Ignore
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
	public void insertProductForm() throws Exception{
		mockMvc.perform(get("/api/admin/productManager/showInsertProductForm")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}	


//@Ignore
	@Test
	public void insertProduct() throws Exception{
		
		ResultActions resultActions =
		
		mockMvc.perform(get("/api/admin/productManager/category")
				.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())
				.andExpect(status().isOk());
		
		String resultString = resultActions.andReturn().getResponse().getContentAsString();
		JSONResult jsonResult = new Gson().fromJson(resultString, JSONResult.class);
		List<CategoryVo> list = new Gson().fromJson(jsonResult.getData().toString(), new TypeToken<List<CategoryVo>>(){}.getType());
		
		DisplayProductDTO dto = new DisplayProductDTO();
		
		dto.setTitle("판매글 제목");
		dto.setContent("판매글 내용");
		dto.setCategoryNo(3L);
		
		List<ProductVo> productList = new ArrayList<ProductVo>();
		ProductVo pv = new ProductVo();
		pv.setName("뉴발란스 맨투맨");
		pv.setOption("S/BLACK");
		pv.setPrice(50000L);
		pv.setStock(600L);
		pv.setActiveStock(600L);
		productList.add(pv);
		
		pv = new ProductVo();
		pv.setName("뉴발란스 맨투맨");
		pv.setOption("M/BLACK");
		pv.setPrice(50000L);
		pv.setStock(600L);
		pv.setActiveStock(600L);
		productList.add(pv);
		
		pv = new ProductVo();
		pv.setName("뉴발란스 맨투맨");
		pv.setOption("L/BLACK");
		pv.setPrice(50000L);
		pv.setStock(600L);
		pv.setActiveStock(600L);
		productList.add(pv);
		
		pv = new ProductVo();
		pv.setName("뉴발란스 맨투맨");
		pv.setOption("XL/BLACK");
		pv.setPrice(50000L);
		pv.setStock(600L);
		pv.setActiveStock(600L);
		productList.add(pv);
		
		
		List<FileVo> fileList = new ArrayList<FileVo>();
		FileVo fv = new FileVo();
		fv.setOriName("맨투맨메인사진.JPG");
		fv.setChangeName("맨투맨 바뀐 이름.JPG");
		fv.setDisplayProductNo(1L);
		fv.setUrl("/assets/images/productImages");
		fv.setStatus("Main");
		fileList.add(fv);
		
		fv = new FileVo();
		fv.setOriName("맨투맨 서브 사진");
		fv.setChangeName("맨투맨 바뀐 이름.JPG");
		fv.setDisplayProductNo(1L);
		fv.setUrl("/assets/images/productImages");
		fv.setStatus("Sub");
		fileList.add(fv);
		
		dto.setProductList(productList);
		dto.setFileList(fileList);
		
		
		mockMvc.perform(post("/api/admin/productManager/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(dto)))
//				.andDo(print())
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
