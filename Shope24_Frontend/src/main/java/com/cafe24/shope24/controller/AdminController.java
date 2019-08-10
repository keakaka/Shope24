package com.cafe24.shope24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.shope24.service.AdminService;
import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.CategoryVo;
import com.cafe24.shope24.vo.MemberVo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
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
		MemberVo vo = memberService.getAdmin(memberVo);
		
		model.addObject(vo);
		return "admin/main";
	}
	
	@GetMapping("/product")
	public String getProductPage(Model model) {
		
		List<CategoryVo> list = adminService.getCategoryList();
		model.addAttribute("list", list);
		
		return "admin/productMain";
	}
}
