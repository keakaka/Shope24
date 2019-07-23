package com.cafe24.shope24.controller.api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shope24.config.app.test.AppConfig;
import com.cafe24.shope24.config.web.test.WebConfig;
import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.DeliveryAddressVo;
import com.cafe24.shope24.vo.MemberVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class MemberControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	public void insertDefaultMember() {
		MemberVo memberVo = new MemberVo();
		memberVo.setId("keakaka");
		memberVo.setPassword("!q2w3e4r");
		memberVo.setName("박필");
		memberVo.setEmail("keakaka@naver.com");
		memberVo.setGender("M");
		memberVo.setBirth("900512");
		memberVo.setPhone("01062570512");
		memberVo.setKey("FeelSoGoooooood");
		sqlSession.insert("member.insertMember", memberVo);
	}
	
	public void deleteAllMember() {
		sqlSession.delete("test.deleteAllMember");
		sqlSession.update("test.defaultIncrement");
	}
	
	@Before	
	public void setUp() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
		insertDefaultMember();
	}
	@After
	public void teadDown() {
		deleteAllMember();
	}
	
//@Ignore
	@Test
	public void test_a_memberServiceDI() {
		assertNotNull(memberService);
	}
	
//@Ignore
	@Test
	public void test_b_getJoinPage() throws Exception{
		mockMvc.perform(get("/api/member/join")
				.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())
				.andExpect(status().isOk());
			
	}
	
//@Ignore
	@Test
	public void test_b_checkId() throws Exception {
		mockMvc.perform(get("/api/member/checkId").param("id", "keakaka")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
//				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}
	
//@Ignore
	@Test
	public void test_b_MemberInsertAndValid() throws Exception {
		MemberVo memberVo = new MemberVo();
		
		// id Fail
		memberVo = new MemberVo();
		memberVo.setId("ke");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		
		// password Fail
		memberVo = new MemberVo();
		memberVo.setId("keakaka");
		memberVo.setPassword("pwd");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		
		// name Fail
		memberVo = new MemberVo();
		memberVo.setId("keakaka");
		memberVo.setPassword("!q2w3e4r");
		memberVo.setName("a");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		
		// email Fail
		memberVo = new MemberVo();
		memberVo.setId("keakaka");
		memberVo.setPassword("!q2w3e4r");
		memberVo.setName("박필");
		memberVo.setEmail("email");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		
		// gender Fail
		memberVo = new MemberVo();
		memberVo.setId("keakaka");
		memberVo.setPassword("!q2w3e4r");
		memberVo.setName("박필");
		memberVo.setEmail("keakaka@naver.com");
		memberVo.setGender("aa");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		
		// success
		memberVo = new MemberVo();
		memberVo.setId("keakaka2");
		memberVo.setPassword("!q2w3e4r2");
		memberVo.setName("박필");
		memberVo.setEmail("keakaka2@naver.com");
		memberVo.setGender("M");
		memberVo.setBirth("900512");
		memberVo.setPhone("01062570512");
		mockMvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());


	}
	
	
//@Ignore
	@Test
	public void test_b_MemberLoginValid() throws Exception {
		MemberVo memberVo = new MemberVo();
		
		// Fail
		memberVo.setId("k");
		memberVo.setPassword("pwd");
		mockMvc.perform(post("/api/member/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andExpect(status().isBadRequest());
		// success 
		memberVo.setId("keakaka");
		memberVo.setPassword("!q2w3e4r");
		
		mockMvc.perform(post("/api/member/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_c_getMyPage() throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		mockMvc.perform(get("/api/member/{id}", "keakaka").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_d_deliveryInfo() throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		mockMvc.perform(get("/api/member/{id}/delivery", memberVo.getId()).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_d_deliveryAdd() throws Exception {
		DeliveryAddressVo daVo = new DeliveryAddressVo();
		daVo.setAddress("주소주소");
		daVo.setType("기본주소지");
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		mockMvc.perform(post("/api/member/{id}/delivery", memberVo.getId()).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(daVo)).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_d_deliveryDelete() throws Exception {
		DeliveryAddressVo daVo = new DeliveryAddressVo();
		daVo.setNo(1L);
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		mockMvc.perform(delete("/api/member/{id}/delivery", memberVo.getId()).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(daVo)).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_e_MyInfo() throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		mockMvc.perform(get("/api/member/{id}/myInfo", memberVo.getId()).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//@Ignore
	@Test
	public void test_e_MyInfoUpdate() throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setNo(1L);
		memberVo.setId("keakaka");
		memberVo.setBirth("900512");
		memberVo.setPhone("01062570512");
		memberVo.setGender("F");
		memberVo.setEmail("pfeel0512@naver.com");
		
		mockMvc.perform(put("/api/member/{id}/updateMyInfo", memberVo.getId()).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo)))
				.andDo(print()).andExpect(status().isOk());
	}
	
	
//@Ignore
	@Test
	public void test_f_showMyCart() throws Exception{
		// 회원일 경우
		MemberVo memberVo = new MemberVo();
		memberVo.setId("keakaka");
		
		mockMvc.perform(get("/api/member/showCart").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo.getId())))
				/* .andDo(print()) */.andExpect(status().isOk());
		
		// 비회원일 경우
		String cartOwner = "192.168.1.236";
		mockMvc.perform(get("/api/member/showCart").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(cartOwner)))
				.andDo(print()).andExpect(status().isOk());
	}
	
//	@Test
//	public void test_g_showMyPayInfo() throws Exception{
//		MemberVo memberVo = new MemberVo();
//		memberVo.setId("keakaka");
//		
//		mockMvc.perform(get("/api/member/showPayInfo").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(memberVo.getId())))
//				/* .andDo(print()) */.andExpect(status().isOk());
//		
//		// 비회원일 경우
//		String orderCode = "AB1234";
//		String orderName = "박필";
//		mockMvc.perform(get("/api/member/showPayInfo").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(cartOwner)))
//				.andDo(print()).andExpect(status().isOk());
//}

}
