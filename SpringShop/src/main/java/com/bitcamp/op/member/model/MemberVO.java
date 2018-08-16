package com.bitcamp.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String phone1;
	private String phone2;
	private String phone3;
	private String memberPhone;
	private String postCode;
	private String addr1;
	private String addr2;
	private String memberAdress;
	private String email1;
	private String email2;
	private String memberEmail;
	private MultipartFile photoFile;
	private String imgContext;
		
	
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
		
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAdress() {
		return memberAdress;
	}
	public void setMemberAdress(String memberAdress) {
		this.memberAdress = memberAdress;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
		
	public boolean isMatchPassword(String userPw){
		
		if(this.memberPwd.equals(userPw)) {
			return true;
		}
		
		return false;
		
	}
	
	public MultipartFile getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}
	public String getImgContext() {
		return imgContext;
	}
	public void setImgContext(String imgContext) {
		this.imgContext = imgContext;
	}
	public void generatePhone() {
		
		this.memberPhone=this.phone1+")"+this.phone2+this.phone3;
	}
	
	public void generateAdress() {
		
		this.memberAdress= this.postCode+")"+this.addr1+" "+this.addr2;
	}
	
	public void generateEmail() {
		this.memberEmail = this.email1 +"@"+this.email2;
		
	}
	
	
	
	
}
