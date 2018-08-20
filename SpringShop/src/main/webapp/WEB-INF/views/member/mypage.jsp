<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 프로필 사진 있을때  -->
<c:if test="${loginInfo.imgcontext ne null}">
<c:url var="myImg" value="/uploadFile/memberPhoto/${loginInfo.imgContext}"/>
</c:if>

<!-- 프로필 사진 없을때는 기본값(짱구얼굴)으로 로드 -->
<c:if test="${loginInfo.imgcontext eq null}">
<c:url var="myImg" value="/uploadFile/memberPhoto/myImg.png"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value='/css/member.css'/>" type="text/css" media="all" />
</head>
<body>
<!-- Shell -->
<div class="shell">
  <!-- Header -->
  <%@ include file="../commons/header.jspf" %>
  <!-- End Header -->
  <!-- Main -->
  <div id="main">
    <div class="cl">&nbsp;</div>
   	
    <!-- Content -->
    <div id="content">
    
    <div id="mypage">
        	
    	<div style="width: 500px; margin: 15px auto; padding-top:50px;">
			
			<div style="width: 200px; height: 200px;  border: 1px solid #DDDDDD; 
				margin: 15px auto; border-radius: 100px;background-image: url('${myImg}');
				background-size: 100%">
			</div>
			
			<table width="100%" style="margin:auto;">
				<tr>
					<td>회원번호</td>
					<td>${sessionID.memberNo}</td>
				</tr>
				<tr>
					<td>회원아이디</td>
					<td>${sessionID.memberId}</td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td>${sessionID.memberName}</td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td>${sessionID.memberAdress}</td>
				</tr>
			</table>
			<br/>
			<a  href="<c:url value='/member/modify' />" style="float:right;">회원정보수정</a>     
		</div>
    	
          
    </div>
    
    
    </div>
    <!-- End Content -->
    <!-- Sidebar -->
   
   <%@ include file="../commons/sidebar.jspf" %>
   
    <!-- End Sidebar -->
    <div class="cl">&nbsp;</div>
  </div>
  <!-- End Main -->
  <!-- Side Full -->
  
  <!-- End Side Full -->
  <!-- Footer -->
  
  <%@ include file="../commons/footer.jspf" %>
  
  <!-- End Footer -->
</div>
<!-- End Shell -->
</body>
</html>
