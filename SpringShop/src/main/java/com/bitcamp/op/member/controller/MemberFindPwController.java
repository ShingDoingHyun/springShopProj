package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.MemberFindPwService;

@Controller
@RequestMapping("/member/findMyPw")
public class MemberFindPwController {
	
	@Autowired
	MemberFindPwService memberFindPwService;

	@RequestMapping(method=RequestMethod.GET)
	public String findPwForm() {
		
		return "member/findMyPw";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String findPw(@RequestParam("id") String id, @RequestParam("email") String email, Model model) {
		
		String resultMsg = memberFindPwService.findPwResultMsg(id, email);
		
		model.addAttribute("resultMsg", resultMsg);
		
		return "member/findMyPw";
	}
}
