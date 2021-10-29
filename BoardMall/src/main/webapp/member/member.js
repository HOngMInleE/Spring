function go_save() {
	if (document.formm.userId.value == "") {
		alert("아이디를 입력하여 주세요.");
		document.formm.userId.focus();
	} else if (document.formm.userId.value != document.formm.reid.value) {
		alert("중복확인을 클릭하여 주세요.");
		document.formm.userId.focus();
	} else if (document.formm.userPwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.formm.userPwd.focus();
	} else if ((document.formm.userPwd.value != document.formm.userPwdChk.value)) {
		alert("비밀번호가 일치하지 않습니다.");
		document.formm.userPwd.focus();
	} else if (document.formm.userName.value == "") {
		alert("이름을 입력해 주세요.");
		document.formm.userName.focus();
	} else if (document.formm.email.value == "") {
		alert("이메일을 입력해 주세요.");
		document.formm.email.focus();
	} else {
		document.formm.action = "NonageServlet?command=join";
		document.formm.submit();
	}
}

function idcheck() {
	if (document.formm.userId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.userId.focus();
		return;
	}
	var url = "NonageServlet?command=id_check_form&id="
			+ document.formm.userId.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400px, height=250px");
}
