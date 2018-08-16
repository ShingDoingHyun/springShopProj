<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>

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
					<h1>&nbsp;&nbsp;상품 추가</h1>
					<br> <br> <br>
					<div class="cl">&nbsp;</div>

					<form style="margin-left: 40px" method="post"
						enctype="multipart/form-data">
						<table>
							<tr>
								<td>상품이름 :</td>
								<td><input type="text" name="productName" size="81"></td>
							</tr>
							<tr>
								<td>상품가격 :</td>
								<td><input type="number" name="productPrice">
								<td>
							</tr>
							<tr>
								<td>상품타입 :</td>
								<td>남성용 <input type="radio" name="productType" value="men"
									checked> 여성용 <input type="radio" name="productType"
									value="women">
								<td>
							</tr>
							<tr>
								<td>상품사진 :</td>
								<td><input type="file" id="upload" name="photoFile">
								<td>
							</tr>
							<tr>
								<td>사진이미지 :</td>
								<td colspan="2"><div id="holder"></div></td>
							</tr>
							<tr>
								<td>상품설명 :</td>
								<td><textarea rows="10" cols="80" name="productDetail"></textarea></td>
							</tr>
							<tr>
								<td colspan="2"><center>
										<input type="submit" value="상품추가">
									</center></td>
							</tr>
						</table>
					</form>


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


<!-- 사진 첨부시 이미지 화면에 출력 낮은버전 IE에서는 안될수도 -->
<script>
	var upload = document.getElementsByTagName('input')[4], holder = document
			.getElementById('holder');

	upload.onchange = function(e) {
		e.preventDefault();

		var file = upload.files[0], reader = new FileReader();
		reader.onload = function(event) {
			var img = new Image();
			img.src = event.target.result;
			// note: no onload required since we've got the dataurl...I think! :)
			img.style.width = '230px';
			img.style.height = '300px';
			
			holder.innerHTML = '';
			holder.appendChild(img);
		};
		reader.readAsDataURL(file);

		return false;
	};
</script>
</html>