package com.bitcamp.op.member.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
public class MemberRegController {
	
	
	@Autowired
	MemberRegService regService;
		
	// 회원가입 폼 전송
	
	@RequestMapping(value="/member/reg",method=RequestMethod.GET)
	public String memberRegForm() {
		
		
		return "member/join";
	}
	
	
	// 회원가입 폼 받아서 처리
	@RequestMapping(value="/member/reg", method=RequestMethod.POST)
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
	
	
	@RequestMapping(value="/member/idCheck")
	@ResponseBody
	public Map<Object, Object> idCheck(@RequestBody String userId) {
		
		int result = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
						
		System.out.println("여기까지1");
		System.out.println("userId값 : " + userId);		
				
		// 결과값: 조회값(0보다크면 중복)
		result = regService.idCheck(userId);
		System.out.println("MemberRegController result: "+result);
		
		map.put("cnt", result);
		
		return map;
				
	}
	
}
