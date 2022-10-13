function check_ok() {
	if(reg_frm.user_id.value.length == 0){
		alert("아이디를 써주세요.");
		reg_frm.user_id.focus();
		return;
	}
	
	if(reg_frm.user_id.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		reg_frm.user_id.focus();
		return;
	}
	
	if(reg_frm.user_pwd.value.length == 0){
		alert("패스워드는 반드시 입력해야 합니다.");
		reg_frm.user_pwd.focus();
		return;
	}
	
	if(reg_frm.user_pwd.value != reg_frm.user_pwdch.value){
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.user_pwdch.focus();
		return;
	}
	
	if(reg_frm.user_name.value.length == 0){
		alert("이름을 써주세요.");
		reg_frm.user_name.focus();
		return;
	}
	
	if(reg_frm.user_email.value.length == 0){
		alert("Email을 써주세요.");
		reg_frm.user_email.focus();
		return;
	}
	
	document.reg_frm.submit();
}
function update_check_ok() {
	if(upd_frm.user_pwd.value.length == 0){
		alert("패스워드는 반드시 입력해야 합니다.");
		upd_frm.user_pwd.focus();
		return;
	}
	
	if(upd_frm.user_pwd.value != upd_frm.user_pwdcheck.value){
		alert("패스워드가 일치하지 않습니다.");
		upd_frm.user_pwdcheck.focus();
		return;
	}
	
	if(upd_frm.user_email.value.length == 0){
		alert("Email을 써주세요.");
		upd_frm.user_email.focus();
		return;
	}
	
	document.upd_frm.submit();
}








