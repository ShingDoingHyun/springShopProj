package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.member.service.MemberFindIdService;

@Controller
public class MemberFindIdController {

	@Autowired
	MemberFindIdService memberFindIdService;
	
	@RequestMapping(value="/member/findMyId" , method=RequestMethod.GET)
	public String findIdForm() {
		
		return "member/findMyId";
	}
	
	@RequestMapping(value="/member/findMyId" , method=RequestMethod.POST)
	public String findId(@RequestParam("email") String email, Model model) {
		
		String resultMsg = memberFindIdService.findIdResultMsg(email);
		model.addAttribute("resultMsg", resultMsg);
		
		return "member/findMyId";
	}

}
