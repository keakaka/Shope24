package com.cafe24.shope24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.MemberVo;

@Controller
@RequestMapping(value="/user")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "user/loginform";
	}
	
	@GetMapping("/checkId")
	@ResponseBody
	public Boolean checkId(@RequestParam String id) {
		
		Boolean check = memberService.checkId(id);
		return check;
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@ModelAttribute MemberVo memberVo) {
		String result = memberService.insertMember(memberVo);
		return result;
	}
}
