package com.bitcamp.op.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {

	@RequestMapping("/member/mypage")
	public String mypage() {
		
		
		
		return "/member/mypage";
	}
	
}
