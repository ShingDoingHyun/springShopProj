<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/style.css" type="text/css"	media="all" />
<link rel="stylesheet" href="../css/member.css" type="text/css"	media="all" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
#confirmCheck{ visibility:hidden;}

th{
	
   text-align: left;
   padding : 10px; 
   background-color : #F8F8F8;
    
}


</style>

</head>
<body>
	<!-- Shell -->
	<div class="shell">
		<!-- Header -->
		<%@ include file="../commons/header.jspf"%>
		<!-- End Header -->
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			<!-- Content -->
			<div id="content">
				<div class="JoinPage">
					<br>
					<h1>회원정보수정</h1>
					<br>
					<br>
					<p class="required ">
						<img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /> 필수입력사항
					</p>
					<br>
					<div class="boardWrite">
						<form method="post" enctype="multipart/form-data">
							<table summary="">
								<tbody>
									<tr>
									<% String check = (String)request.getAttribute("check"); 
										if(check == null) { check = "uncheckd"; }
									
									%>
										<th scope="row">아이디 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="memberId" name="memberId" placeholder=""	value="${sessionID.memberId }" type="text" maxlength="16" readonly/> (영문소문자/숫자,4~16자)
										<input type="checkbox" id="confirmCheck" name="cofirmCheck" display="none" <%=check %>>
										 </td>
									</tr>
									<tr>
										<th scope="row">비밀번호 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="passwd" name="memberPwd"	autocomplete="off" maxlength="16" value="" type="password" maxlength="16" /> 
										(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)</td>
									</tr>
									<tr>
										<th scope="row">비밀번호 확인 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="user_passwd_confirm"	name="memberPwdConfirm" autocomplete="off" maxlength="16" value="" type="password" /> </td>
									</tr>
									<tr class="">
										<th scope="row">비밀번호 확인 질문 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><select id="hint" name="hint">
												<option value="hint_01">기억에 남는 추억의 장소는?</option>
												<option value="hint_02">자신의 인생 좌우명은?</option>
												<option value="hint_03">자신의 보물 제1호는?</option>
												<option value="hint_04">가장 기억에 남는 선생님 성함은?</option>
												<option value="hint_05">타인이 모르는 자신만의 신체비밀이 있다면?</option>
												<option value="hint_06">추억하고 싶은 날짜가 있다면?</option>
												<option value="hint_07">받았던 선물 중 기억에 남는 독특한 선물은?</option>
												<option value="hint_08">유년시절 가장 생각나는 친구 이름은?</option>
												<option value="hint_09">인상 깊게 읽은 책 이름은?</option>
												<option value="hint_10">읽은 책 중에서 좋아하는 구절이 있다면?</option>
												<option value="hint_11">자신이 두번째로 존경하는 인물은?</option>
												<option value="hint_12">친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
												<option value="hint_13">초등학교 때 기억에 남는 짝꿍 이름은?</option>
												<option value="hint_14">다시 태어나면 되고 싶은 것은?</option>
												<option value="hint_15">내가 좋아하는 캐릭터는?</option>
										</select></td>
									</tr>
									<tr class="">
										<th scope="row">비밀번호 확인 답변 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="hint_answer" name="hint_answer"
											class="inputTypeText" placeholder="" value="" type="text" /></td>
									</tr>
									<tr>
										<th scope="row" id="memberName">이름 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="memberName" name="memberName" class="inputTypeText" placeholder="" value="${sessionID.memberId}" type="text" readOnly />
											<span id="under14Msg" class="displaynone">14세 미만 사용자는 법정대리인 동의가 필요합니다.</span></td>
									</tr>
									<tr>
										<th scope="row" id="memberAge">나이 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="memberAge" name="memberAge" class="inputTypeText" placeholder="" value="" type="text" onKeyPress="return numkeyCheck(event)"/></td>
									</tr>
									<tr>
										<th scope="row">성별 <img	src="<c:url value='/css/images/ico_required.gif'/>" class="" alt="필수" /></th>
										<td><input id="is_sex0" name="memberGender" value="0" type="radio" /><label>남자</label>
										    <input id="is_sex1" name="memberGender" value="1 " type="radio" /><label>여자</label></td>
									</tr>

									<tr class="">
										<th scope="row">주소 <img	src="<c:url value='/css/images/ico_required.gif'/>" class="" alt="필수" /></th>
										<td><input id="postcode" name="postCode"	class="inputTypeText" placeholder="우편번호" maxlength="14" value="" type="text"/>우편번호
											<input type="button" onclick="searChpostcode()" value="우편번호찾기" /><br/>
											<input id="address" name="addr1"	class="inputTypeText" placeholder="주소" value="" type="text" />도로명주소<br/>
											<input id="address2" name="addr2"	class="inputTypeText" placeholder="상세주소" value="	" type="text" />지명주소</td>
											<span id="guide" style="color:#999"></span>	
									</tr>
									<tr class="">
										<th scope="row">일반전화 <img src="<c:url value='/css/images/ico_required.gif'/>" class="displaynone" alt="필수" /></th>
										<td><select id="phone1" name="phone1" >
												<option value="02">02</option>
												<option value="031">031</option>
												<option value="032">032</option>
												<option value="033">033</option>
												<option value="041">041</option>
												<option value="042">042</option>
												<option value="043">043</option>
												<option value="044">044</option>
												<option value="051">051</option>
												<option value="052">052</option>
												<option value="053">053</option>
												<option value="054">054</option>
												<option value="055">055</option>
												<option value="061">061</option>
												<option value="062">062</option>
												<option value="063">063</option>
												<option value="064">064</option>
												<option value="0502">0502</option>
												<option value="0503">0503</option>
												<option value="0504">0504</option>
												<option value="0505">0505</option>
												<option value="0506">0506</option>
												<option value="0507">0507</option>
												<option value="070">070</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="018">018</option>
												<option value="019">019</option>
										</select>-
										<input id="phone2" name="phone2" maxlength="4" value=""	type="text" onKeyPress="return numkeyCheck(event)" />-<input id="phone3" name="phone3" value="" type="text" onKeyPress="return numkeyCheck(event)"/></td>
									</tr>
									<tr class="">
										<th scope="row">휴대전화 <img
											src="<c:url value='/css/images/ico_required.gif'/>" class="" alt="필수" /></th>
										<td><select id="mobile1" name="mobile1">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="018">018</option>
												<option value="019">019</option>
										</select>-<input id="mobile2" name="mobile2" maxlength="4" value=""	type="text" onKeyPress="return numkeyCheck(event)"/>
										-<input id="mobile3" name="mobile3"	maxlength="4" onKeyPress="return numkeyCheck(event)"/></td>
									</tr>
									<tr class="">
										<th scope="row">SMS 수신여부 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><label><input id="is_sms0"	name="is_sms" class="ec-base-chk" value="T" type="checkbox" />동의함</label>
										<p>쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.</p></td>
									</tr>
									<tr>
										<th scope="row">이메일 <img src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><input id="email1" name="email1" class="mailId"	value="" type="text" readonly/>@<input id="email2" name="email2" class="mailAddress" value="" type="text" readonly />
										<select	id="email3" onchange="chageLangSelect()">
												<option value="" selected="selected" >- 이메일 선택 -</option>
												<option value="naver.com">naver.com</option>
												<option value="daum.net">daum.net</option>
												<option value="nate.com">nate.com</option>
												<option value="hotmail.com">hotmail.com</option>
												<option value="yahoo.com">yahoo.com</option>
												<option value="empas.com">empas.com</option>
												<option value="korea.com">korea.com</option>
												<option value="dreamwiz.com">dreamwiz.com</option>
												<option value="gmail.com">gmail.com</option>
												<option value="etc">직접입력</option>
										</select> <span id="emailMsg"></span></td>
									</tr>
										<tr class="">
										<th scope="row">이메일 수신여부 <img	src="<c:url value='/css/images/ico_required.gif'/>" alt="필수" /></th>
										<td><label><input id="is_news_mail0" name="is_news_mail"  value="T" type="checkbox" />동의함</label>
										<p>쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.</p></td>
									</tr>
									<tr class="">
										<th scope="row">프로필사진 </th>
										<td><input id="image" name="photoFile" type="file" />
									</tr>
									
								</tbody>
							</table>
							<input type="submit" name="join" value="회원정보수정" id="loginBtn">
							<input type="button" name="cancle" value="취소" id="joinBtn" onClick="location.href='<c:url value="/" />'">
						</form>
						<% String msg = (String)request.getAttribute("msg"); %>
				        <% if(msg != null) {%>
				        	<p id="msg"><%=msg %></p>
				        <% } else {  %>
				    		<p id = "msg"> &nbsp; </p>
				    	<% } %>
					</div>
				</div>
			</div>
			<!-- End Content -->
			<!-- Sidebar -->

			<%@ include file="../commons/sidebar.jspf"%>

			<!-- End Sidebar -->
			<div class="cl">&nbsp;</div>
		</div>
		<!-- End Main -->
		<!-- Side Full -->

		<!-- End Side Full -->
		<!-- Footer -->

		<%@ include file="../commons/footer.jspf"%>

		<!-- End Footer -->
	</div>
	<!-- End Shell -->
	
	
	<script type="text/javascript"> 
		
		<!-- 회원정보 로드 -->
		window.onload = function(){
			
			var email="${sessionID.memberEmail}";
			var arr = email.split("@");
			
			document.getElementById("email1").value=arr[0];
			document.getElementById("email2").value=arr[1];
			
		}
		
	
	
		<!-- 나이에 숫자만 오도록 입력 -->
		function numkeyCheck(e) { 
			var keyValue = event.keyCode; if( ((keyValue >= 48) && (keyValue <= 57)) ) return true; 
			else return false; 
		}
		
		//	<!-- 메일선택시 mail2란에 입력채움 -->
		function chageLangSelect(){
		    var select = document.getElementById("email3");
		     
		    // select element에서 선택된 option의 value가 저장된다.
		    var selectValue = select.options[select.selectedIndex].value;
		    
		    // 선택된 값을 email2에 저장한다
		    var email2 = document.getElementById("email2");
		    email2.value = selectValue;
		 		    
		}
		
		function checkId(){						// id 특수문자 및  공백, 검사
			
			var id = document.getElementById("memberId").value;
			
			if(!id){							// 아이디를 입력하지 않는 경우
				alert("아이디를 입력하지 않았네요");
				return false;
			}
			else if((id < '0' || id > '9') && (id < 'a' || id > 'z') && (id < 'A' || id > 'Z') ) {
				alert("한글 및 특수문자는 아디로 사용할수 없다 이것아!!");		// 특수문자 사용한 경우
			}
			else if(id > 'A' && id < 'Z'){	// 대문자를 사용한 경우
				alert("대문자를 사용하시면 아니되오")
			}
			else if(id.length<4){
				alert("아이디는 최소 4자이상 되어야 하오!!");		// 특수문자 사용한 경우
				
			}			
			else{
				var parm = "id="+id;
				var url = "/member/confirm.jsp?"+parm;
				open(url,"confirm","toolbar=no,location=no,memubar=no,scrollbars=no,resizable=no,width=360,height=200")
				
			}
		}
					
		  function searChpostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var fullAddr = ''; // 최종 주소 변수
		                var extraAddr = ''; // 조합형 주소 변수

		                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    fullAddr = data.roadAddress;

		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    fullAddr = data.jibunAddress;
		                }

		                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
		                if(data.userSelectedType === 'R'){
		                    //법정동명이 있을 경우 추가한다.
		                    if(data.bname !== ''){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있을 경우 추가한다.
		                    if(data.buildingName !== ''){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
		                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
		                }

		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
		                document.getElementById('address').value = fullAddr;

		                // 커서를 상세주소 필드로 이동한다.
		                document.getElementById('address2').focus();
		            }
		        }).open();
		    }
		
	</script>

	
</body>
</html>