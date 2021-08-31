// 장바구니 js 기능

function go_cart() {
	if (document.formm.quantity.value == "") {
		alert("수량을 입력하여 주세요.");
		document.formm.quantity.focus();
	} else {
		document.formm.action = "NonageServlet?command=acrt_insert";
		document.formm.submit();
	}
}

function go_cart_delete() {
	var count = 0;
	
	if (document.formm.cseq.length == undefined) {
		if (document.formm.cseq.checked = true) {
			count++;
		}
	}
	
	for (var i=0; i<document.formm.cseq.length; i++) {
		alert("" + document.formm.cseq[i].checked);
		if (document.formm.cseq[i].checked == true) {
			count++;
			alert("" + count);
		}
	}
	
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요.");
	} else {
		document.formm.action = "NonageServlet?command=cart_delete";
		document.formm.submit();
	}
}// go_cart_delete()

function go_order() {
	document.formm.action = "NonageServlet?command=mypage";
	document.formm.submit();
}
