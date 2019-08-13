package com.cafe24.shope24.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.shope24.dto.ProductDTO;
import com.cafe24.shope24.security.Auth;
import com.cafe24.shope24.security.AuthUser;
import com.cafe24.shope24.service.AdminService;
import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.FileVo;
import com.cafe24.shope24.vo.MemberVo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin")
@Auth
public class AdminController {
	
	private final String PATH = "/shope24-uploads/";
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("")
	public String main () {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public String login (@ModelAttribute MemberVo memberVo, ModelAndView model) {
		
		MemberVo vo = memberService.getMember(memberVo);
		if(vo.getRole() != "ROLE_ADMIN") {
			return "redirect:/";
		}
		return "admin/main";
	}
	
	@RequestMapping("/main")
	public String goMain () {
		return "admin/main";
	}
	
	
	@GetMapping("/product")
	public String getProductPage(Model model, @AuthUser MemberVo authUser) {
		if(authUser == null || !"ROLE_ADMIN".equals(authUser.getRole())) {
			return "redirect:/";
		}
		List<CategoryVo> list = adminService.getCategoryList();
		model.addAttribute("list", list);
		
		return "admin/productMain";
	}
	
	@PostMapping("/product")
	@ResponseBody
	public String insertProduct(@RequestBody Map<String, Object> productDTO, @AuthUser MemberVo authUser) {
		if(authUser == null || !"ROLE_ADMIN".equals(authUser.getRole())) {
			return "redirect:/";
		}
		System.out.println("ㅇ ㅗ니 오니오니");
		System.out.println(productDTO);
		
		
		
		return "";
	}
	
	
	
	@PostMapping("/imgUpload")
	@ResponseBody
	public String imgUpload(@RequestParam("file") MultipartFile file, @AuthUser MemberVo authUser, HttpSession session) {
		if(authUser == null || !"ROLE_ADMIN".equals(authUser.getRole())) {
			return "redirect:/";
		}
		
		String fileName = file.getOriginalFilename();
		String changeName = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
		
		FileVo vo = new FileVo();
		vo.setOriName(fileName);
		vo.setChangeName(changeName);
		
		
		try {
			file.transferTo(new File(PATH+changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		vo.setUrl("/images/"+changeName);

		return new Gson().toJson(vo);
	}
	
	@GetMapping("/imgDelete")
	@ResponseBody
	public String imgDelete(@RequestParam("fileName") String fileName, @AuthUser MemberVo authUser) {
		if(authUser == null || !"ROLE_ADMIN".equals(authUser.getRole())) {
			return "redirect:/";
		}
		
		File file = new File(PATH+fileName);

		if( file.exists()) file.delete();
		return "success";
	}
	
	
	@GetMapping("/memberList")
	public String memberList(Model model, @AuthUser MemberVo authUser) {
		if(authUser == null || !"ROLE_ADMIN".equals(authUser.getRole())) {
			return "redirect:/";
		}
		
		ArrayList<MemberVo> list = (ArrayList<MemberVo>) memberService.getmemberList();
		model.addAttribute("list", list);
		return "admin/memberList";
	}
	
}
