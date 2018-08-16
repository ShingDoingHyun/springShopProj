package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.model.MemberVO;

public class MemberFindPwService {

	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public String findPwResultMsg(String id, String email) {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		MemberVO memberVO = memberDao.findPw(id);

		String result = "";
		
		if(memberVO != null) {
			String resultEmail = memberVO.getMemberEmail();
			if(resultEmail.equals(email)) {
				
				//메일 발송
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("testemailforshoppingmall@gmail.com");
				message.setTo(resultEmail);
				message.setSubject("비밀번호 입니다.");
				message.setText("비밀번호는" + memberVO.getMemberPwd() + "입니다.");

				mailSender.send(message);
				
				result ="가입하신 email로 비밀번호를 발송 하였습니다.";
			} else {
				result = "id 또는 email 주소가 틀렸습니다";
			}
		} else {
			result = "id 또는 email 주소가 틀렸습니다";
		}
		
		
		return result;
	}
}
