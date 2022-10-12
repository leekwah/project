function check_ok() {
	if(reg_frm.category_code.value.length == 0){
		alert("카테고리를 지정해주세요.");
		reg_frm.category_code.focus();
		return;
	}
	
	if(reg_frm.product_name.value.length == 0){
		alert("상품이름을 써주세요.");
		reg_frm.product_name.focus();
		return;
	}
	
	if(reg_frm.product_price.value.length == 0){
		alert("상품가격을 써주세요.");
		reg_frm.product_price.focus();
		return;
	}
	
	if(reg_frm.product_stock.value.length == 0){
		alert("재고수량을 써주세요.");
		reg_frm.product_stock.focus();
		return;
	}
	
	/*if(reg_frm.product_desc.value.length == 0){
		alert("상품설명을 써주세요.");
		reg_frm.product_desc.focus();
		return;
	}*/
	const element = document.getElementsByClassName("ql-editor")[0];
	
	document.getElementById("content").value = element.innerHTML;
	
	document.reg_frm.submit();
}