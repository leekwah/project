<%@page import="magic.Board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="board" class="magic.Board.BoardBean"/>
<jsp:setProperty property="*" name="board"/>

<%
    BoardDBBean db = BoardDBBean.getInstance();
    int re = db.insertBoard(board);

    if(re == 1){
%>
<script>
    alert("글쓰기가 완료되었습니다.");
    history.go(-1) // history.go(-1) 메서드를 통해서 이전으로 간다.
</script>
<%
}else{
%>
<script>
    alert("글쓰기에 실패하였습니다.");
    history.go(-1) // history.go(-1) 메서드를 통해서 이전으로 간다.
</script>
<%
    }
%>