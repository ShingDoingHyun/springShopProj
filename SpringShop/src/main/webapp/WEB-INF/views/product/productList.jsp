<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<title>Insert title here</title>

<style>
img {
	width: 220px;
	height: 290px;
	align: center;
	margin: 10px;
}

a {
	text-decoration: none;
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

				<%
					String cate = "";
					if (category == "")
						cate = "전체상품";
					else if (category.equals("men"))
						cate = "남성품";
					else if (category.equals("women"))
						cate = "여성용";
				%>
				<br>
				<h1>
					&nbsp;&nbsp;<%=cate%></h1>
				<br> <br> <br>
				<table>
					<c:set var="count" value="0" />
					<c:set var="num" value="3" />
					<c:forEach items="${product.productList }" var="productDTO">
						<c:if test="${count%num==0 }">
							<tr>
						</c:if>




						<td width=240 height=350><a
							href="productDetail/${productDTO.productNo}"> <img
								src='<c:url value='/uploadFile/productImage/${productDTO.productImage}'/>'><br>
								<p style='text-align: center'>${productDTO.productName}</p>
								<p style='text-align: center'>${productDTO.productPrice}￦</p>
						</a></td>

						<c:if test="${count%num== num-1 }">
							</tr>
						</c:if>

						<c:set var="count" value="${count+1 }" />
					</c:forEach>


				</table>
   
        
				<p style='text-align: center'>
					<c:forEach begin="1" end="${product.pageTotalCount }" var="i">
						<a href="<c:url value='/product/productList?page=${ i}&keyword=${param.keyword}&category=${param.category }&row_price=${param.row_price}&high_price=${param.high_price}'/>"
							style="display: inline;">${ i}</a>
					</c:forEach>
					<br>
				</p>
				<!-- 이곳에 목록 추가 --> 

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
</body>
</html>
<script>
	
</script>