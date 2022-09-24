function check_ok(){
	if(write_frm.b_category.value == "nonSelect"){
		alert("문의유형을 선택해주세요");
		write_frm.b_category.focus();
		return;
	}
	if(!write_frm.b_title.value){
		alert("제목을 작성해주세요");
		write_frm.b_title.focus();
		return;
	}
	if(!write_frm.b_content.value){
		alert("문의내용을 작성해주세요");
		write_frm.b_content.focus();
		return;
	}
	if(!write_frm.b_pwd.value){
		alert("비밀번호를 작성해주세요");
		write_frm.b_pwd.focus();
		return;
	}
	
	if(write_frm.b_pwd.value.length < 4 || write_frm.b_pwd.value.length > 12){
		alert("비밀번호는 4자 이상 12자 이하로 작성해주세요");
		write_frm.b_pwd.focus();
		return;
	}
	document.write_frm.submit();
}

function delete_ok(){
	if(del_frm.b_pwd.value.length == 0){
		alert("비밀번호를 작성해주세요");
		del_frm.b_pwd.focus();
		return;
	}
	document.del_frm.submit();
}

 window.onload = function(){
    target = document.getElementById('qnaImg');
    target.addEventListener('change', function(){
        fileList = "";
        for(i = 0; i < target.files.length; i++){
            fileList += target.files[i].name + '<br>';
        }
        target2 = document.getElementById('showFiles');
        target2.innerHTML = fileList;
    });
}
/*
function checkFile(file) {

	var file_path = file.value;
	var reg = /(.*?)\.(jpg|bmp|jpeg|png)$/;
        // 허용되지 않은 확장자일 경우
	if (file_path != "" && (file_path.match(reg) == null || reg.test(file_path) == false)) {
		if ($.browser.msie) { // ie 일때 
			file.parentNode.replaceChild(file.cloneNode(), file);
		} else {
			file.value = "";
		}

		alert("이미지 파일만 업로드 가능합니다.");
	}
}
*/
function getPageNum(event) {
	document.getElementById('result').innerText = 
    event.target.value;
	console.log(event.target.value);
}
