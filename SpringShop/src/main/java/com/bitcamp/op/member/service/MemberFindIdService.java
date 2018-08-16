package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.model.MemberVO;

public class MemberFindIdService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public String findIdResultMsg(String email) {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		MemberVO memberVO = memberDao.findIdByEmail(email);
		
		String result = "";
		
		if(memberVO == null) {
			result = "아이디를 찾을 수 없습니다";
		} else {
			result = "당신의 ID는 " + memberVO.getMemberId() + " 입니다";
		}
		
		return result;
	}
	
}
