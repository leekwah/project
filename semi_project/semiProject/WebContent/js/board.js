function check_ok(){
	if(write_frm.b_category.value == "nonSelect"){
		alert("문의 유형을 선택해 주세요");
		write_frm.b_category.focus();
		return;
	}
	if(write_frm.b_title.value == ""){
		alert("제목을 작성해 주세요");
		write_frm.b_title.focus();
		return;
	}
	if(write_frm.b_content.value == ""){
		alert("내용을 작성해 주세요");
		write_frm.b_content.focus();
		return;
	}
	if(write_frm.b_pwd.value.length == 0){
		alert("비밀번호를 작성해 주세요");
		write_frm.b_pwd.focus();
		return;
	}
	if(write_frm.b_pwd.value.length < 4 || write_frm.b_pwd.value.length > 12){
		alert("비밀번호는 4자리 이상 12자리 이하로 작성해주세요");
		write_frm.b_pwd.focus();
		return;
	}
	document.write_frm.submit();
}

function delete_ok(){
	if(del_frm.pwd.value.length == 0){
		alert("비밀번호를 써주세요");
		del_frm.pwd.focus();
		return;
	}
	document.del_frm.submit();
}