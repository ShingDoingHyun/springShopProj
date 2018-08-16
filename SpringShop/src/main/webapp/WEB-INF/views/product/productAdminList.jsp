<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>



<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
<style>
img {
	width: 200px;
	height: 130px;
	align: center;
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

				<div class="products">
					<br>
					<h1>&nbsp;&nbsp;상품 관리</h1>
					<br> <br> <br>
					<table>
						<tr height=70>
						<td width="35%">상품이미지</td>
						<td width="25%">상품이름</td>
						<td width="20%">상품가격</td>
						<td width="20%">관리</td>
						</tr>	
						<c:forEach items="${product.productList }" var="productDTO">
							<tr height=70>
								<td>
									<img src='<%= request.getContextPath() %>/uploadFile/productImage/${productDTO.productImage}' />
								</td>
								<td>
									<p style='text-align: center'>${productDTO.productName}</p>
								</td>
								<td>
									<p style='text-align: center'>${productDTO.productPrice}￦</p>
								</td>
								<td ><a href="/op/product/productUpdate/${productDTO.productNo}">수정</a>  / <a href="/product/productDelete/${productDTO.productNo}">삭제</a></td>
							</tr>
						</c:forEach>

						<tr height="50"><td colspan="4"><center><a href="/op/product/productAdd">상품추가</a></center></td></tr>
					</table>


					<div class="cl">&nbsp;</div>
				</div>

			</div>


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