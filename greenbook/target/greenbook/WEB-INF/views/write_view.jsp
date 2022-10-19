<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write_view</title>
</head>
<body>
	<table width="500" border="1">
		<form method="post" action="write">
			<tr>
				<td>카테고리</td>
				<td>
					<input type="text" name="category" size="50">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" size="50">
				</td>
			</tr>
			<tr>
				<td>작가</td>
				<td>
					<input type="text" name="author" size="50">
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" size="50">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>