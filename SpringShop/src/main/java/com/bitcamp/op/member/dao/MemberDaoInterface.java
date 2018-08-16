package com.bitcamp.op.member.dao;

import com.bitcamp.op.member.model.MemberVO;


public interface MemberDaoInterface {
	
	// 이메일 찾기
	public MemberVO findIdByEmail(String email);
	
	// 비밀번호 찾기
	public MemberVO findPw(String id);
	
	// 아이디 조회(로그인)
	public MemberVO selectById(String id);
	
	// 회원가입
	public int insertMember(MemberVO memberVo);


}
