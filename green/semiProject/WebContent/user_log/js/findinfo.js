function id_search() { 

	 	if (i_frm.user_name.value.length < 1) {
		  alert("이름을 입력해주세요");
		  return;
		 }

		if (i_frm.user_phone2.value.length < 1) {
			  alert("핸드폰번호를 정확하게 입력해주세요");
			  return;
		 }
		 if (i_frm.user_phone3.value.length < 1) {
			  alert("핸드폰번호를 정확하게 입력해주세요");
			  return;
		 }

	 document.idsearch.submit();  
	 }