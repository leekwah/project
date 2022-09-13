function check_ok(){
    if(document.form.b_name.value == ""){
        alert("작성자를 입력하세요");
        form.b_name.focus();
        return;
    }
    if(document.form.b_title.value == ""){
        alert("제목을 입력하세요");
        form.b_title.focus();
        return;
    }
    if(document.form.b_content.value.length == 0){
        alert("내용을 입력하세요");
        form.b_content.focus();
        return;
    }
    if(document.form.b_pwd.value.length <= 3){
        alert("비밀번호를 4자리 이상 입력하세요");
        form.b_pwd.focus();
        return;
    }

    document.form.submit();
}

function delete_ok(){
    if(document.d_form.b_pwd.value.length ==0){
        alert("비밀번호을 입력하세요.");
        d_form.b_pwdchk.focus();
        return;
    }
    document.d_form.submit();
}