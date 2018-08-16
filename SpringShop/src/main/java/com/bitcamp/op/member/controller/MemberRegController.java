package com.bitcamp.op.member.controller;

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
		
	
	@RequestMapping(method=RequestMethod.GET)
	public String memberRegForm() {
		
		
		return "member/join";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(MemberVO memberVo) {
		
		// 가입성공여부 판단 변수
		int result;
		
		result = regService.insertMember(memberVo);
		
		if(result > 0) {
			System.out.println("가입성공");
			return "index";
			
		}
		
		return "/member/joinFail";
		
		
	}
	
	
	

}
