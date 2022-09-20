<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>주문 관리</h1>
		<form action="orderEdit.jsp?orderNm=" method="post">
		<table border="1">
			<tr>
				<td>주문 순서</td> <!-- 주문일자 순으로 Rank() -->
				<td>주문 번호</td>
				<td>제품명</td>
				<td>수량</td>
				<td>금액</td>
				<td>주문 상태</td>
				<td>주문 수정</td> <!-- 라디오 버튼  > 수정 버튼 > 정보 수정, 환불 처리 -->
			</tr>
			<tr>
				<td>1</td> <!-- 주문일자 순으로 Rank() -->
				<td>202209190001</td>
				<td>TEST</td>
				<td>3</td>
				<td>9000원</td>
				<td>배송 준비</td>
				<!-- <td>
					<select name="status">
                        <option value="입금 대기">입금 대기</option>
                        <option value="입금 완료">입금 완료</option>
                        <option value="주문 확인">주문 확인</option>
                        <option value="배송 준비">배송 준비</option>
                        <option value="배송중">배송중</option>
                        <option value="배송 완료">배송 완료</option>
                        <option value="구매 확정">구매 확정</option>
                    </select>
                </td> 주문 수정에서 변경 --> 
				<td>
					<input type="radio" value="주문 번호" />
				</td> <!-- 라디오 버튼  > 수정 버튼 > 정보 수정, 환불 처리 -->
			</tr>
		</table>	
		<input type="submit" value="주문 수정">
		</form>
	</center>
</body>
</html>