<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>Home</title>
</head>
<script src="./resources/js/jquery.js"></script>
<script>
  $(document).ready(function () {
    $("#login_btn").on('click', function() {
      loginChk();
    })
  });

  function loginChk() {
    $.ajax({
      url: "/webservice/loginChk",
      type: "POST",
      data: {
        id:$("#member_id").val(),
        pw:$("#member_pw").val()
      },
      success: function(data){
        alert(data.Msg);
      },
      error: function(){
        alert("err");
      }
    });
  }
</script>
<body>
<table>
  <tr>
    <td>아이디 : </td>
    <td><input type="text" id="member_id"></td>
  </tr>
  <tr>
    <td>비밀번호:</td>
    <td><input type="password" id="member_pw"></td>
  </tr>
  <tr>
    <td><div id="login_btn" style="background-color:#ddd; cursor:pointer;">로그인</div>
  </tr>
</table>
</body>
</html>
