package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
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
import com.cafe24.shope24.dto.OrdersDTO;
import com.cafe24.shope24.vo.CartVo;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.DisplayProductVo;
import com.cafe24.shope24.vo.OrdersDetailVo;
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

//@Ignore
	@Test
	public void buyProduct() throws Exception {
		
		OrdersDTO dto = new OrdersDTO();
		
		dto.setMemberNo(1L);
		dto.setOrdersName("주문자");
		dto.setReceiveName("수령자");
		dto.setPhone("010-6257-0512");
		dto.setDeliveryAddress("서울시 관악구 신림동");
		dto.setPrice(120000L);
		dto.setTel("02-2525-2525");
		dto.setEmail("keakaka@naver.com");
		
		List<OrdersDetailVo> ordersDetailList = new ArrayList<OrdersDetailVo>();
		OrdersDetailVo ordersDetailVo = new OrdersDetailVo();
		
		ordersDetailVo.setProductNo(3L);
		ordersDetailVo.setCount(1L);
		ordersDetailList.add(ordersDetailVo);
		
		ordersDetailVo = new OrdersDetailVo();
		ordersDetailVo.setProductNo(2L);
		ordersDetailVo.setCount(1L);
		ordersDetailList.add(ordersDetailVo);
		
		ordersDetailVo = new OrdersDetailVo();
		ordersDetailVo.setProductNo(4L);
		ordersDetailVo.setCount(4L);
		ordersDetailList.add(ordersDetailVo);
		
		dto.setOrdersDetailList(ordersDetailList);
		
		mockMvc.perform(post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(dto)))
//				.andDo(print())
				.andExpect(status().isOk());
		
	}

	
	
	
	
}
