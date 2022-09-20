<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="findinfo.js" charset="utf-8"></script>
</head>
<body>
	<form name="i_frm" method="post" action="findIdResult.jsp">
			<div class = "search-title">
				<h3>휴대폰 본인확인</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>이름</label>
				<input type="text" name="user_name" class = "btn-name" placeholder = "등록한 이름">
			<br>
			</div>
			<div class = "find-phone">
				<label>번호</label>
				<select name = "user_phone1">
						<option value = "010">010</option>
						<option value = "02">02</option>
						<option value = "031">031</option>
						<option value = "051">051</option>
				</select>
				<input type="text" name="user_phone2" size ="10" maxlength="4">
				<input type="text" name="user_phone3" size ="10" maxlength="4">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<!-- <input type="button" name="enter" value="찾기"  onClick="id_search()"> -->
		<input type="submit" name="enter" value="찾기">
		<input type="reset" name="cancle" value="취소" >
 	</div>
 </form>
</body>
</html>