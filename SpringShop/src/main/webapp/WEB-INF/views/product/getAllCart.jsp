<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<title>Insert title here</title>

<link rel="stylesheet" href="./css/style.css" type="text/css"
	media="all" />
<style>
#totalprice {
	color: red;
}
</style>
</head>
<body>
	<!-- Shell -->
	<div class="shell">
		<!-- Header -->
		<%@ include file="../commons/header.jspf"%>

		<!-- 결제 시스템 창(start)  -->
		<div id="paymentForm">
			<p style="font-size: 15px; padding: 30px">카트</p>
			<table
				style="border-top: 2px solid black; border-bottom: 2px solid black; width: 100%">
				<tr>
					<th style="width: 5%; text-align: left;"><input
						type="checkbox" onclick="checkAll()"></th>
					<th style="width: 40%; text-align: center">상품명</th>
					<th style="width: 10%; text-align: center">정가</th>
					<th style="width: 10%; text-align: center">수량</th>
					<th style="width: 15%; text-align: center">합계</th>
					<th style="width: 10%; text-align: center">배송일</th>
					<th style="width: 10%; text-align: center">주문</th>
				</tr>
				<c:forEach items="${Cartlist}" var="Cart">
					<tr>
						<td style="width: 5%; text-align: left"><input
							name="checkclothes" type="checkbox" onclick="checkItem()"></td>
						<td style="width: 40%; text-align: top"><img
							src="<%= request.getContextPath() %>/uploadFile/productImage/${Cart.img_src}0.jpg"
							style="width: 100px; heigth: 100px; float: left;">${Cart.item_name}</td>

						<td style="width: 10%; text-align: center"><input
							name="itemprice" style="text-align: center; border: none"
							type="text" value="${Cart.item_one}" readonly></td>

						<td style="width: 10%; text-align: center"><input
							name="itemamount" type="text"
							style="width: 25px; height: 20px; text-align: right"
							value="${Cart.item_amount}"><br> <input
							name="totalchange" type="button" value="변경"
							style="margin-top: 5px"></td>

						<td style="width: 15%; text-align: center"><input
							name="totalprice" style="text-align: center; border: none"
							type="text" value="${Cart.item_price}" readonly></td>

						<td style="width: 10%; text-align: center">2018-01-01</td>

						<td style="width: 10%; text-align: center"><input
							type="button" style="width: 80%; margin: 3px;" value="카트"><br>
							<input type="button" style="width: 80%; margin: 3px;" value="리스트"><br>
							<input type="button" style="width: 80%; margin: 3px;"
							value="바로구매"></td>
				</c:forEach>

			</table>
			<form action="<%=request.getContextPath()%>/product/deleteCart"
				method="post">
				<input name="delete" type="submit"
					style="width: 100px; margin: 3px; align: right" value="전체삭제">
			</form>
		</div>
		<!-- 결제 시스템 창(end)  -->
		<%@ include file="../commons/footer.jspf"%>

		<!-- End Footer -->
	</div>
	<!-- End Shell -->
	<script>
		/* var a = 0;
		if(a == 0){
			window.location.href = "/CartController";
			a = 1;
		} */
		//window.location.href = "/CartController";//현재 창에 login.jsp 페이지가 열림, 뒤로가기 하면 호출한 페이지로 갈수 있음.
		var allCheck = document.getElementsByName("allCheck");
		var checkclothes = document.getElementsByName("checkclothes");
		var itemprice = document.getElementsByName("itemprice");
		var itemamount = document.getElementsByName("itemamount");
		var totalprice = document.getElementsByName("totalprice");
		var totalchange = document.getElementsByName("totalchange");

		function checkAll() {
			for (var i = 0; i < checkclothes.length; i++) {
				checkclothes[i].checked = true;
			}
		}

		function checkItem() {
			allCheck[0].checked = false;

			var cnt = 0;
			for (var i = 0; i < checkclothes.length; i++) {
				if (checkclothes[i].checked == true) {
					cnt++;
				}
			}
			if (cnt == 3) {
				allCheck[0].checked = true;
			}
		}
	</script>
</body>
</html>