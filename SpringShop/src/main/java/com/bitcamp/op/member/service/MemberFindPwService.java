package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.security.MessageDigest.Sha256;

public class MemberFindPwService {

	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	Sha256 sha256;
	
	@Autowired
	MemberModifyService modify;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public String findPwResultMsg(String id, String email) throws Exception {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		MemberVO memberVO = memberDao.findPw(id);
		
		String tmPwd="";		// 임시비밀번호 담는 변수
		String result = "";
		
			
		if(memberVO != null) {
			String resultEmail = memberVO.getMemberEmail();
						
			if(resultEmail.equals(email)) {
				
				// 임시 비밀번호 생성
				for(int i=0; i<10; i++) {
					
					tmPwd += Integer.toString((int)(Math.random()*10));
						
				}
				
				//테스트코드
				System.out.println("임시비밀번호 : "+tmPwd);
				
				//임시비밀번호로 변경
				memberVO.setMemberPwd(tmPwd);
														
										
				//메일 발송
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("testemailforshoppingmall@gmail.com");
				message.setTo(resultEmail);
				message.setSubject("비밀번호 입니다.");
				message.setText("비밀번호는 " + tmPwd + " 입니다.");
								
				mailSender.send(message);
				
				result ="가입하신 email로 비밀번호를 발송 하였습니다.";
				
				// 임시비밀번호로 비밀번호 바꾸고 DB에 수정
				modify.updateMember(memberVO, null);
				
			} else {
				result = "id 또는 email 주소가 틀렸습니다";
			}
		} else {
			result = "id 또는 email 주소가 틀렸습니다";
		}
		
		
		return result;
	}
}
