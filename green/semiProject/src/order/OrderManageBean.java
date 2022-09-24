package order;

import java.sql.Timestamp;

public class OrderManageBean {
	private String order_number;
	private int order_detail_number;
	private String product_name;
	private int product_number;
	private int product_count;
	private int product_price;
	private String order_detail_status;
	private String refund_check;
	private String shipment;
	
	private String user_id;
	private Timestamp order_date;
	private String receiver_name;
	private String receiver_phone1;
	private String receiver_phone2;
	private String receiver_phone3;
	private String receiver_pcode;
	private String receiver_raddr;
	private String receiver_jibun;
	private String receiver_detailaddr;
	
	
	//����¡ ����
		public static int pageSize = 10; //���������� ������ �� ����
		public static int pageCount = 1; //�� ������ ����
		public static int pageNum = 1; //�� ������ ����
	//������ �޼ҵ�
		public static String pageNumber(int limit, String url) {
			String str = "";
			int temp = (pageNum-1) % limit;
			int startPage = pageNum - temp;
			
			if(startPage - limit > 0) {
				str ="<li class=\"page-item\"><a class=\"page-link\" href ='adminIndex.jsp?pageNum="+(startPage-limit)+"&pages="+url+"'>����</a></li>";
			}
			for (int i = startPage; i < (startPage+limit); i++) {//���� ������ ��ȣ
				str+="<li class=\"page-item\"><a class=\"page-link\" href='adminIndex.jsp?pageNum="+i+"&pages="+url+"'>"+i+"</a></li>";
				if (i >= pageCount) { 
					break;
				}
			}
			if ((startPage + limit) <= pageCount) {
				str += "<li class=\"page-item\"><a class=\"page-link\" href = 'adminIndex.jsp?pageNum="+(startPage+limit)+"&pages="+url+"'>����</a></li>";
			}
			return str;
		}
		//����¡ ���� ��
	
		
	public String getReceiver_phone1() {
		return receiver_phone1;
	}
	public String getShipment() {
		return shipment;
	}
	public void setShipment(String shipment) {
		this.shipment = shipment;
	}
	public void setReceiver_phone1(String receiver_phone1) {
		this.receiver_phone1 = receiver_phone1;
	}
	public String getReceiver_phone2() {
		return receiver_phone2;
	}
	public void setReceiver_phone2(String receiver_phone2) {
		this.receiver_phone2 = receiver_phone2;
	}
	public String getReceiver_phone3() {
		return receiver_phone3;
	}
	public void setReceiver_phone3(String receiver_phone3) {
		this.receiver_phone3 = receiver_phone3;
	}
	public String getReceiver_pcode() {
		return receiver_pcode;
	}
	public void setReceiver_pcode(String receiver_pcode) {
		this.receiver_pcode = receiver_pcode;
	}
	public String getReceiver_raddr() {
		return receiver_raddr;
	}
	public void setReceiver_raddr(String receiver_raddr) {
		this.receiver_raddr = receiver_raddr;
	}
	public String getReceiver_jibun() {
		return receiver_jibun;
	}
	public void setReceiver_jibun(String receiver_jibun) {
		this.receiver_jibun = receiver_jibun;
	}
	public String getReceiver_detailaddr() {
		return receiver_detailaddr;
	}
	public void setReceiver_detailaddr(String receiver_detailaddr) {
		this.receiver_detailaddr = receiver_detailaddr;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public int getOrder_detail_number() {
		return order_detail_number;
	}
	public void setOrder_detail_number(int order_detail_number) {
		this.order_detail_number = order_detail_number;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getOrder_detail_status() {
		return order_detail_status;
	}
	public void setOrder_detail_status(String order_detail_status) {
		this.order_detail_status = order_detail_status;
	}
	public String getRefund_check() {
		return refund_check;
	}
	public void setRefund_check(String refund_check) {
		this.refund_check = refund_check;
	}
	
	
}