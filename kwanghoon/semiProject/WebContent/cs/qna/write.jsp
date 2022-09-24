<%@ page import="cs.QnABoardBean"%>
<%@ page import="cs.QnABoardDBBean"%>
<%@ page import="login.UserBean" %>
<%@ page import="login.UserDBBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	// login.jsp 에서 input의 name값을 받아옴
	
	UserDBBean manager = UserDBBean.getInstance();
	// getInstance() 메서드를 통해서 manager 객체 생성

	int check = manager.userCheck(id, pwd);
	UserBean ur = manager.getUser(id);
	// 아이디가 일치하는 멤버의 정보를 mb객체에 저장
	
	if(ur == null) {
%>	
	<script>
		alert("존재하지 않는 회원");
		response.sendRedirect("../main/login.jsp"); // 수정필요
	</script>
<%
	} else {
		// ur객체의 name을 받아서, String name으로 대입한다. 
		String name = ur.getUser_name();
		
		if(check == 1) {
			// session 을 넘겨서, main에서 출력한다.
			// main.jsp 로 이동하기 전에, session에 추가한다.
			session.setAttribute("user_id", id);
			session.setAttribute("user_name", name);
			session.setAttribute("user", "yes");
			// 임의로 user일 경우 "yes"값을 준다. URL로만 로그인하는 것을 막기 위해서이다.
			response.sendRedirect("main.jsp");			
		}else if(check == 0){
%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			// history.go(-1);
			// response.sendRedirect("main.jsp"); 수정필요 
		</script>
<%
		}else{
%>
		<script>
			alert("아이디가 맞지 않습니다.");
			// history.go(-1);
			// response.sendRedirect("main.jsp"); 수정필요 
		</script>	
<%
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD:kwanghoon/semiProject/WebContent/cs/qna/write.jsp
<title>Insert title here</title>
<script type="text/javascript" src="../../js/board.js" charset="UTF-8"></script>
</head>
<body>
	<% 
		String id = "admin";
		String grade = "admin";
=======
<title>write</title>
<script type="text/javascript" src="../js/board.js" charset="UTF-8"></script>
</head>
<body>
	<%-- 
		// String id = "";
>>>>>>> b22d46c6612903351459196e2ec30dda63f34c11:kwanghoon/semiProject/WebContent/cs/write.jsp
		session.setAttribute("id", id); 
		session.setAttribute("grade", grade); 
		String b_title="";
		if(session.getAttribute(id) == null){
			response.sendRedirect("login.jsp");
		}
	--%>
	<h1>문의 작성</h1>
    <hr>
    <form action="write_ok.jsp" method="post" name="write_frm" enctype="multipart/form-data">
    	<table>
            <tr>
                <td>문의유형</td>
                <td>
                    <select name="b_category" id="category">
                        <option value="nonSelect">문의 유형을 선택해 주세요.</option>
                        <option value="회원정보">회원정보</option>
                        <option value="상품문의">상품문의</option>
                        <option value="주문/결제">주문/결제</option>
                        <option value="배송">배송</option>
                        <option value="교환/취소">교환/취소</option>
                        <option value="서비스">서비스</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" name="name" />
                </td>
            </tr>
            <tr>
                <td>휴대전화</td>
                <td>
                    <input type="text" name="phone" />
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input type="text" name="email" />
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
					<input type="text" name="b_title" placeholder="제목을 입력해주세요." />
                </td>
            </tr>
            <tr>
                <td>문의내용</td>
                <td>
                    <textarea name="b_content" cols="30" rows="10" placeholder="내용을 입력해주세요."></textarea>
                </td>
            </tr>
            <tr>
                <td>사진</td>
                <td>
                   <label for="qnaImg" style="width: 50px; height: 50px; display: inline-block;" >
                       <img src="../../images/upload.png" alt="upload" style="pointer-events: none; width: 100%;">
                   </label>
                   <input type="file" name="b_fname" id="qnaImg" onchange="checkFile(this);" style="display: none;"/>
                   <div id="showFiles">( 업로드한 파일이 없습니다. )</div>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                	<input type="password" name="b_pwd" />
                </td>
                <td>비밀글</td>
                <td>
                	<input type="checkbox" name="b_secret" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="button" value="취소" onclick="location.href=list.jsp" />
                    <input type="reset" value="다시작성" />
                    <input type="button" value="작성하기" onclick="check_ok();" />
                </td>
            </tr>
        </form>
    </table>
</body>
</html>