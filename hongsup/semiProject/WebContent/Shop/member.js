function update_check_ok() {
	if(upd_frm.user_pwd.value.length == 0){
		alert("비밀번호는 반드시 입력해야 합니다.");
		upd_frm.use_pwd.focus();
		return;
	}
	if(upd_frm.user_pwd.value != upd_frm.pwd_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		upd_frm.pwd_check.focus();
		return;
	}
	if(upd_frm.user_email.value.length == 0){
		alert("이메일을 입력해주세요.");
		upd_frm.user_email.focus();
		return;
	}
	
	upd_frm.submit();
	// memberUpdateOk.jsp 로 전송
}