package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.member.service.MemberModifyService;

@Controller
@RequestMapping("/member/modify")
public class MemberModifyController {
	
	@Autowired
	MemberModifyService modifyService;
	

	@RequestMapping(method=RequestMethod.GET)
	public String modifyForm() {
		
		
		return "member/modifyMypage";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String modify(MemberVO memberVo, HttpServletRequest request) throws Exception {
		
		int result=0;
		
		result = modifyService.updateMember(memberVo, request);
		
		if(result>0) {
			
			return "index";
		}
						
		return "member/modifyMypage";
		
	}
	
	
}
