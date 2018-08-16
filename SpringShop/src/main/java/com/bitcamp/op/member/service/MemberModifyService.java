package com.bitcamp.op.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.model.MemberVO;
import com.bitcamp.op.security.MessageDigest.Sha256;

public class MemberModifyService {

	@Autowired
	SqlSessionTemplate template;
	
	@Autowired
	Sha256 sha256;
	
	private MemberDaoInterface memberDao;
	
	public int updateMember(MemberVO memberVo, HttpServletRequest request) throws Exception{
		
		int result;

		memberDao = template.getMapper(MemberDaoInterface.class);

		// 물리적인 저장시작
		
		// 0. 저장용 파일이름 , 물리적저장, DB 저장용
		String imgName = "";

		// 1. 저장 경로 설정
		String uploadUri = "/uploadFile/memberPhoto";
		// 2. 시스템의 물리적인 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		// 테스트 코드(경로 잘 들어가는지 확인)
		System.out.println(dir);

		// 3. 사용자의 업로드 파일을 물리적으로 저장
		if (!memberVo.getPhotoFile().isEmpty()) {
			// imgName =
			// System.currentTimeMillis()+memberVo.getPhotoFile().getOriginalFilename();
			imgName = memberVo.getMemberId() + "_" + memberVo.getPhotoFile().getOriginalFilename();
			// cool + _ + mini.jpg

			// 저장
			memberVo.getPhotoFile().transferTo(new File(dir, imgName));

			// DB에 저장할 파일 이름을 SET
			memberVo.setImgContext(imgName);
		} // 물리적인 저장 끝

		// 주소, 이메일, 전화번호 합체
		memberVo.generateAdress();
		memberVo.generateEmail();
		memberVo.generatePhone();
		
		// 받은 패스워드를 암호화 처리
		memberVo.setMemberPwd(sha256.encrypt(memberVo.getMemberPwd()));

		result = memberDao.updateMember(memberVo);

		return result;

		
		
	}
	
	
	
}
