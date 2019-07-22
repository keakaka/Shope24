package com.cafe24.shope24.controller.api;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shope24.dto.JSONResult;
import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.DeliveryAddressVo;
import com.cafe24.shope24.vo.MemberVo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@Autowired
	private MessageSource msgSource;
	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value="회원가입 폼 요청 URL")
	@GetMapping("/join")
	public JSONResult joinform() {
		return JSONResult.success(null);
	}
	
	@ApiOperation(value="아이디 중복체크")
	@GetMapping("/checkId")
	public JSONResult checkId(@RequestParam(value="id") String id) {
		Boolean checkId = memberService.checkId(id);
		
		return JSONResult.success(checkId?"가입가능":"중복된 아이디");
	}
	
	@ApiOperation(value="회원가입")
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody MemberVo memberVo, BindingResult result) {
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<MemberVo>> validatorResults = validator.validateProperty(memberVo, "password");
		validatorResults.addAll(validator.validateProperty(memberVo, "id"));
		validatorResults.addAll(validator.validateProperty(memberVo, "email"));
		validatorResults.addAll(validator.validateProperty(memberVo, "gender"));
		validatorResults.addAll(validator.validateProperty(memberVo, "name"));
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<MemberVo> validatorResult : validatorResults) {
				String message = "";
				switch(validatorResult.getPropertyPath().toString()) {
					case "id" : message = msgSource.getMessage("Id.memberVo.id", null, LocaleContextHolder.getLocale()); break;
					case "password" : message = msgSource.getMessage("Password.memberVo.password", null, LocaleContextHolder.getLocale()); break;
					case "name" : message = msgSource.getMessage("Name.memberVo.name", null, LocaleContextHolder.getLocale()); break;
					case "email" : message = msgSource.getMessage("Email.memberVo.email", null, LocaleContextHolder.getLocale()); break;
					case "gender" : message = msgSource.getMessage("Gender.memberVo.gender", null, LocaleContextHolder.getLocale()); break;
				}
				
				JSONResult jsonResult = JSONResult.fail(message);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResult);
				
			}
		}
		Boolean check = memberService.insertMember(memberVo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(check?"가입성공":"가입실패"));
	}
	
	@ApiOperation(value="로그인")
	@PostMapping("/login")
	public ResponseEntity<JSONResult> login(@RequestBody MemberVo memberVo, BindingResult result) {
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<MemberVo>> validatorResults = validator.validateProperty(memberVo, "password");
		validatorResults.addAll(validator.validateProperty(memberVo, "id"));
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<MemberVo> validatorResult : validatorResults) {
				String message = msgSource.getMessage("Login.memberVo.login", null, LocaleContextHolder.getLocale());
				
				JSONResult jsonResult = JSONResult.fail(message);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResult);
				
			}
		}
		Boolean check = memberService.login(memberVo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(check));
	}
	
	@ApiOperation(value="마이 페이지")
	@GetMapping("/{id}")
	public JSONResult getMyPage(@PathVariable(value="id") String id, @RequestBody MemberVo memberVo){
		
		Boolean check = memberService.myPage(memberVo.getNo());
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="배송지관리")
	@GetMapping("/{id}/delivery")
	public JSONResult getDeliveryPage(@PathVariable(value="id") String id, @RequestBody MemberVo memberVo){
		Boolean check = memberService.myDelivery(memberVo.getNo());
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="배송지추가")
	@PostMapping("/{id}/delivery")
	public JSONResult insertDelivery(@PathVariable(value="id") String id, @RequestBody DeliveryAddressVo daVo, @RequestBody MemberVo memberVo){
		Boolean check = memberService.myDeliveryAdd(memberVo.getNo(), daVo);
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="배송지삭제")
	@DeleteMapping("/{id}/delivery")
	public JSONResult deleteDelivery(@PathVariable(value="id") String id, @RequestBody DeliveryAddressVo daVo, @RequestBody MemberVo memberVo){
		Boolean check = memberService.myDeliveryDel(memberVo.getNo(), daVo);
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="내 정보 보기")
	@GetMapping("/{id}/myInfo")
	public JSONResult getMyInfo(@PathVariable(value="id") String id, @RequestBody MemberVo memberVo){
		Boolean check = memberService.getMyInfo(memberVo.getNo());
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="내 정보 수정")
	@PutMapping("/{id}/updateMyInfo")
	public JSONResult updateMyInfo(@PathVariable(value="id") String id, @RequestBody MemberVo memberVo){
		Boolean check = memberService.updateMyInfo(memberVo);
		return JSONResult.success(check);
	}
	
	@ApiOperation(value="장바구니 보기")
	@GetMapping("/showCart")
	public JSONResult showCart(@RequestBody String cartOwner){
		System.out.println(cartOwner);
		Boolean check = memberService.getShowCart(cartOwner);
		return JSONResult.success(check);
	}
	
}
