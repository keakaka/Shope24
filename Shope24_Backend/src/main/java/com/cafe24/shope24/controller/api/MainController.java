package com.cafe24.shope24.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

@Controller
public class MainController {
	
	@ApiOperation(value="메인화면")
	@RequestMapping({"/", "/main"})
	public String main() {
		
		return "main/index";
	}
	
}
