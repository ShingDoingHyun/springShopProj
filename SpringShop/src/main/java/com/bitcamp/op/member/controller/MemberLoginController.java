package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService loginService;
	

	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		
		
		return "member/login";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login( HttpServletRequest request, LoginRequest loginRequest) throws Exception {
		
		boolean result;
		
		// 테스트 코드
		System.out.println("id:"+loginRequest.getId()+"pw:"+loginRequest.getPwd());

		result = loginService.login(request, loginRequest);
		
		if(result) {		
			
			return "index";
		}
		else {
			
			// 테스트 코드
			System.out.println("로그인 실패");
			
			return "member/login";			
			
		}
			
	}
	
}
