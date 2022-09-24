<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        *{
            list-style: none;
            padding: 0;
            margin: 0;
        }
        a{
            text-decoration: none;
            color: black;
            display: block;
            height: 30px;
        }
        button{
            background: inherit ; 
            border:none; 
            box-shadow:none; 
            border-radius:0; 
            padding:0; 
            overflow:visible; 
            cursor:pointer;
            font-size: 16px;
        }
        #nav_left span {
            font-size: 24px;
            font-weight: bold;
            display: block;
            height: 30px;
            line-height: 30px;
        }
        hr {
        	margin-bottom: 10px;
        }
        .tab {
            display: inline-block;
            height: 90px;
            width: 100%;
        }
        .tab > div {
            display: none;
            font-size: 14px;
            font-weight: 500;
        }
    </style>
</head>
<body>
    <div id="nav_left">
        <span>관리자 메뉴</span>
        <hr />
        <div class="tab">
            <button class="product_tab"><a href="?page=user_myPage.jsp">나의 정보 ></a></button>
        </div>
        <div class="tab">
            <button class="order_tab"><a href="?page=user_order_list.jsp">주문 내역 조회 ></a></button>
        </div>
        <div class="tab">
            <button class="board_tab"><a href="?page=user_question_list.jsp">문의 내역 ></a></button>
        </div>
        <div class="tab">
            <button class="admin_tab"><a href="?page=user_like_list.jsp">좋아요 ></a></button>
        </div>
        <div class="tab">
            <button class="admin_tab"><a href="?page=user_communication_list.jsp">커뮤니티 ></a></button>
        </div>
    </div>
</body>
</html>