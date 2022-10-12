<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="order.OrderManageDBBean"%>
<%@page import="order.OrderManageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String name = (String)request.getParameter("name");
     String id = (String)request.getParameter("id"); // 세션으로 받기
     String email = (String)request.getParameter("email");
     String phone1 = (String)request.getParameter("phone1");
     String phone2 = (String)request.getParameter("phone2");
     String phone3 = (String)request.getParameter("phone3");
     String raddr = (String)request.getParameter("raddr");
     String jibun = (String)request.getParameter("jibun");
     String detailaddr = (String)request.getParameter("detailaddr");
     String pcode = (String)request.getParameter("pcode");
     String p_name = (String)request.getParameter("p_name");
     String requested = (String)request.getParameter("requested");
     
     int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
     int p_num = Integer.parseInt(request.getParameter("p_num"));
     int count = Integer.parseInt(request.getParameter("count"));
     int price = Integer.parseInt(request.getParameter("price"));
     String phone = phone1+phone2+phone3;
     String address = raddr+detailaddr;
     
     // 주문번호, 상세번호 생성
	Date nowDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss"); 
	String today = sdf.format(nowDate); 
	String orderDNum = p_num+today; 
	long o_dNum = Long.parseLong(orderDNum);
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMddHHmmssSSS"); 
	String orderNum = sdf2.format(nowDate); 
     
     OrderManageBean omb = new OrderManageBean();
     OrderManageDBBean omdb = OrderManageDBBean.getInstance(); //setOrder 만들기
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kakao</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<%
	omb.setUser_id(id);
	omb.setReceiver_name(name);
	omb.setReceiver_phone1(phone1);
	omb.setReceiver_phone2(phone2);
	omb.setReceiver_phone3(phone3);
	omb.setReceiver_pcode(pcode);
	omb.setReceiver_raddr(raddr);
	omb.setReceiver_jibun(jibun);
	omb.setReceiver_detailaddr(detailaddr);
	omb.setProduct_name(p_name);
	omb.setProduct_number(p_num);
	omb.setProduct_count(count);
	omb.setProduct_price(totalPrice);
	omb.setRequested(requested);
	omb.setOrder_detail_number(o_dNum);
	omb.setOrder_number(orderNum);
	int re = omdb.insertOrder(omb);

	if(re==1){
%>

    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp04783078'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '<%= p_name %>',
            amount : <%=totalPrice%>,
            buyer_email : '<%=email%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=phone%>',
            buyer_addr : '<%=address%>',
            buyer_postcode : '<%= pcode %>',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/buy/", //cross-domain error가 발생하지 않도록 주의해주세요
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    data: {
                        imp_uid : rsp.imp_uid,
                        merchant_uid: rsp.merchant_uid,
                        amount : rsp.paid_amount,
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                       msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
               location.href='main.jsp?pages=paySuccess?orderDNum='+o_dNum;
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="main.jsp?pages=payFail";
                alert(msg);
            }
        });
        
    });
    </script> 
<% 
	} else if(re==2){
%>
	<script type="text/javascript">
		alert("재고가 부족합니다.");
		location.href="main.jsp?pages=../buy/buy_body&p_name=<%= p_name %>&p_num=<%= p_num %>&count=<%= count %>&price=<%= price %>";
	</script>
<%
	} else {
		%>
		<script type="text/javascript">
			alert("주문에 실패했습니다.");
			location.href="main.jsp?pages=../buy/buy_body&p_name=<%= p_name %>&p_num=<%= p_num %>&count=<%= count %>&price=<%= price %>";
		</script>
	<%		
	}
%>
</body>
</html>