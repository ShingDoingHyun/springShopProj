package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.model.MemberVO;

public class MemberRegService {
	
	// Spring + Mybatics : 자동매퍼 생성 기능을 이용한 DAO 구현
	@Autowired
	SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;
	
	public int insertMember(MemberVO memberVo) {
		
		int result;
		
		memberDao = template.getMapper(MemberDaoInterface.class);
		
		// 주소, 이메일, 전화번호 합체
		memberVo.generateAdress();
		memberVo.generateEmail();
		memberVo.generatePhone();
		
		result = memberDao.insertMember(memberVo);
		
		return result;
		
				
	}
	
}
