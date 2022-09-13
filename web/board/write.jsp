<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>write</title>
  <script type="text/javascript" src="board.js" charset="utf-8"></script>
</head>
<body>
<center>
  <h1 align="center">글올리기</h1>
  <form method="post" action="write_ok.jsp">
    <table>
      <tr height="30">
        <td width="80">작성자</td>
        <td width="140">
          <input type="text" size="10" maxlength="20" name="b_name"> <!-- 최대길이 20 -->
        </td>
      </tr>
      <tr height="30">
        <td width="80">이메일</td>
        <td width="240">
          <input type="text" size="24" maxlength="50" name="b_email"> <!-- 최대길이 50 -->
        </td>
      </tr>
      <tr height="30">
        <td width="80">글제목</td>
        <td colspan="3" width="460"> <!-- 셀 3개 병합 -->
          <input type="text" size="55" maxlength="80" name="b_title"> <!-- 최대길이 50 -->
        </td>
      </tr>
      <tr>
        <td colspan="4"> <!-- 셀 4개 병합 -->
          <textarea rows="10" cols="65" name="b_content"></textarea>
        </td>
      </tr>
      <tr height="50" align="center">
        <td colspan="4">
          <input type="submit" value="전송" >
          &nbsp;
          <input type="reset" value="다시작성">
        </td>
      </tr>
    </table>
  </form>
</center>
</body>
</html>