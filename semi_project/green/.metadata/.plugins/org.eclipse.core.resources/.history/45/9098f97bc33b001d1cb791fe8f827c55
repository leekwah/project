package product;

import java.sql.Timestamp;

public class ProductBean {
	
	//product table
	
	private int product_number;
	private String category_code;
	private String product_name;
	private int product_price;
	private int product_stock;
	private String product_desc;
	private Timestamp product_date;
	private int product_ordered_count;
	
	//product_imagefile table
	private int file_number;
	private String orgin_file_name;
	private String stored_file_name;
	private String stored_thumbnail;
	private int file_size;
	private Timestamp create_date;
	
	//페이징 변수
	public static int pageSize = 10; //한패이지에 보여줄 글 갯수
	public static int pageCount = 1; //총 페이지 갯수
	public static int pageNum = 1; //총 페이지 갯수
	//페이지 메소드
	
	/*
	 * 작 성 자 : 이민하
	 * 작업일자 : 2022.09.22
	 * 작업내용 : 수정 => [다음] a태그를 생성할 때 조건절 startPage - limit <= pageCount를
	 *             => startPage + limit <= pageCount로 변경
	 * 추가작업 : 수정 => a태그를 꾸미기 위해서 class 추가
	 * */
	public static String pageNumber(int limit) {
		String str = "";
		int temp = (pageNum-1) % limit;
		int startPage = pageNum - temp;
		
		if(startPage - limit > 0) {
			str = "<a class=\"page-link\" href='list.jsp?pageNum="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
		}
		
		for (int i = startPage; i < (startPage+limit); i++) {//안쪽 페이지 번호
			if(i==pageNum) {
				str += "["+i+"]&nbsp;&nbsp;";
			}else {
				str += "<a class=\"page-link\" href='list.jsp?pageNum="+i+"'>"+"["+i+"]"+"</a>&nbsp;&nbsp;";
			}
			if(i>= pageCount) break;
		}
		if(startPage + limit <= pageCount) {
			str += "<a class=\"page-link\" href = 'list.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
		}
		return str;
	}
	
	/*
	 * 작 업 자 : 이민하
	 * 작업일자 : 2022.09.22
	 * 작업내용 : 추가 => url 을 수정할 일이 존재할 경우 이 메소드를 사용함. => 오버로딩
	 * */
	/*
	 * 수 정 자 : 황우성
	 * 작업일자 : 2022.09.22
	 * 작업내용 : 버튼 디자인을 위한 수정
	 * */
	
	public static String pageNumber(int limit, String url) {
		String str = "";
		int temp = (pageNum-1) % limit;
		int startPage = pageNum - temp;
		
		if(startPage - limit > 0) {
			str ="<li class=\"page-item\"><a class=\"page-link\" href ='"+url+".jsp?pageNum="+(startPage-limit)+"&pages=productList'>이전</a></li>";
		}
		for (int i = startPage; i < (startPage+limit); i++) {//안쪽 페이지 번호
			str+="<li class=\"page-item\"><a class=\"page-link\" href='"+url+".jsp?pageNum="+i+"&pages=productList'>"+i+"</a></li>";
			if (i >= pageCount) { 
				break;
			}
		}
		if ((startPage + limit) <= pageCount) {
			str += "<li class=\"page-item\"><a class=\"page-link\" href = '"+url+".jsp?pageNum="+(startPage+limit)+"&pages=productList'>다음</a></li>";
		}
		return str;
	}
	//페이징 변수 끝
	
	public int getFile_number() {
		return file_number;
	}
	public void setFile_number(int file_number) {
		this.file_number = file_number;
	}
	public String getOrgin_file_name() {
		return orgin_file_name;
	}
	public void setOrgin_file_name(String orgin_file_name) {
		this.orgin_file_name = orgin_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public Timestamp getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Timestamp product_date) {
		this.product_date = product_date;
	}
	public int getProduct_ordered_count() {
		return product_ordered_count;
	}
	public void setProduct_ordered_count(int product_ordered_count) {
		this.product_ordered_count = product_ordered_count;
	}

	public String getStored_thumbnail() {
		return stored_thumbnail;
	}

	public void setStored_thumbnail(String stored_thumbnail) {
		this.stored_thumbnail = stored_thumbnail;
	}
	
	
}