package com.bitcamp.op.member.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {
	
	
	@Autowired
	MemberRegService regService;
		
	// 회원가입 폼 전송
	@RequestMapping(method=RequestMethod.GET)
	public String memberRegForm() {
		
		
		return "member/join";
	}
	
	
	// 회원가입 폼 받아서 처리
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(MemberVO memberVo, HttpServletRequest request) throws Exception {
		
		// 가입성공여부 판단 변수
		int result;
		
				
		result = regService.insertMember(memberVo, request);
		
		if(result > 0) {
			System.out.println("가입성공");
			return "index";
			
		}
		
		return "/member/joinFail";
				
	}
	
	
}
