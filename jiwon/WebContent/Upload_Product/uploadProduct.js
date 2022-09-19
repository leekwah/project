function check_ok() {
	if(up_prodc.category_code.value.length == 0){
		alert("카테고리를 지정해주세요.");
		up_prodc.category_code.focus();
		return;
	}
	
	if(up_prodc.product_name.value.length == 0){
		alert("상품이름을 써주세요.");
		up_prodc.product_name.focus();
		return;
	}
	
	if(up_prodc.product_price.value.length == 0){
		alert("상품가격을 써주세요.");
		up_prodc.product_price.focus();
		return;
	}
	
	if(up_prodc.product_stock.value.length == 0){
		alert("재고수량을 써주세요.");
		up_prodc.product_stock.focus();
		return;
	}
	
	if(up_prodc.product_desc.value.length == 0){
		alert("상품설명을 써주세요.");
		up_prodc.product_desc.focus();
		return;
	}
	
	document.up_prodc.submit();
}