package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shope24.config.app.test.AppConfig;
import com.cafe24.shope24.config.web.test.WebConfig;
import com.cafe24.shope24.dto.DisplayProductDTO;
import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.vo.CartVo;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.DisplayProductVo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class ProductControllerTest {
	
	private MockMvc mockMvc;
	
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
@Ignore
	@Test
	public void showProductList() throws Exception {
		mockMvc.perform(get("/api/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}
@Ignore
	@Test
	public void showOneProduct() throws Exception {
		DisplayProductVo vo = new DisplayProductVo();
		vo.setNo(1L);
		
		ResultActions resultActions =
		mockMvc.perform(get("/api/product/{displayProductNo}", vo.getNo())
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
		
	}
	
@Ignore
	@Test
	public void addCartToProduct() throws Exception {
		
		CartVo vo = new CartVo();
		vo.setMemberNo("1");
		vo.setProductNo(3L);
		vo.setCount(2L);
		
		mockMvc.perform(post("/api/product/addCart")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(vo)))
				.andDo(print())
				.andExpect(status().isOk());
		
	}

@Ignore
	@Test
	public void BuyProduct() throws Exception {
		
		CartVo vo = new CartVo();
		vo.setMemberNo("1");
		vo.setProductNo(3L);
		vo.setCount(2L);
		
		mockMvc.perform(post("/api/product/addCart")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(vo)))
				.andDo(print())
				.andExpect(status().isOk());
		
	}

	
	
	
	
}
