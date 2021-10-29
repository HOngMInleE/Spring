<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<!-- 회원가입 화면 -->
<div class="container">
	<div class="py-3 text-center">
	<img class="d-block mx-auto mb-4" src="resources/images/LOGO.png" alt="Logo" width="250" height="150">
		<h2>회원가입</h2>
	</div>
	
	<div class="row" style="float: none;margin:0 auto;width: 700px;">
		<!-- <div class="col-md-8 order-md-1"> -->
		<div class="col-md-12">
			<form class="needs-validation bg-light text-dark" name="formm" id="regForm" style="padding:15px;">
				<h5 class="mb-3">기본 정보 입력(필수)</h5>
				<br>
				<div class="mb-3">
					<label for="userid">아이디</label>
					<div class="input-group">
						<input type="text" class="form-control" name="userid" id="userid" placeholder="아이디" required>
						<button class="btn btn-primary btn-lg btn-block" id="idChk" type="button" onclick="idcheck()">중복확인</button>
					</div>
				</div>
				<div class="mb-3">
					<label for="pwd">비밀번호 </label>
					<input type="password" class="form-control" name="pwd" id="pwd" placeholder="비밀번호">
				</div>
				<div class="mb-3">
					<label for="pwdChk">비밀번호 확인 </label>
					<input type="password" class="form-control" name="pwdChk" id="pwdChk" placeholder="비밀번호 확인">
				</div>
				<div class="mb-3">
					<label for="name">이름 </label>
					<input type="text" class="form-control" name="name" id="name" placeholder="이름">
				</div>
				<div class="mb-3">
					<label for="email">이메일 </label>
					<input type="email" class="form-control" name="email" id="email" placeholder="you@example.com">
				</div>
				<div class="mb-3">
					<label for="nickname">닉네임</label>
					<div class="input-group">
						<input type="text" class="form-control" name="nickname" id="nickname" placeholder="닉네임" required>
						<button class="btn btn-primary btn-lg btn-block" type="button" onclick="idcheck()">중복확인</button>
					</div>
				</div>
				<hr class="mb-4">
				<h5 class="mb-3">선택 입력 사항</h5><br>
				<div class="mb-3">
					<label for="profile">프로필 사진</label>
					<input type="file" class="form-control" name="profile" id="profile">
				</div>
				<div class="mb-3">
					<label for="phone">휴대폰 번호</label>
					<input type="tel" class="form-control" name="phone" id="phone" placeholder="휴대폰 번호">
				</div>
				<div class="mb-3">
					<label for="zipnum">우편번호</label>
					<div class="input-group">
						<input type="number" class="form-control" name="zipnum" id="zipnum" placeholder="우편번호" required>
						<button class="btn btn-primary btn-lg btn-block" type="button" onclick="">우편번호 검색</button>
					</div>
				</div>
				<div class="mb-3">
					<label for="address">기본 주소</label> 
					<input type="text" class="form-control" name="address" id="address" placeholder="기본 주소" required>
				</div>

				<div class="mb-3">
					<label for="address2">상세 주소<span class="text-muted">(선택 사항)</span></label>
					<input type="text" class="form-control" name="address2" id="address2" placeholder="상세 주소">
				</div>
				
			</form>
			<div class="mb-3 text-center">
				<button class="btn btn-primary btn-lg btn-block"  onclick="#">취소</button>
				<button class="btn btn-primary btn-lg btn-block" id="submit" onclick="go_save()">확인</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$("#cancel").on("click", function() {
			location.href = "join.do";
		})

		$("#submit").on("click", function() {
			var idChkVal = $("#idChk").val();
			
			if ($("#userid").val() == "") {
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				return false;
			}else if ($("#pwd").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#pwd").focus();
				return false;
			}else if ($("#pwdChk").val() == "") {
				alert("비밀번호를 확인해주세요.");
				$("#pwd").focus();
				return false;
			}else if ($("#pwd").val() != $("#pwdChk").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#pwd").focus();
				return false;
			}else if ($("#name").val() == "") {
				alert("성명을 입력해주세요.");
				$("#userName").focus();
				return false;
			}else if ($("#email").val() == "") {
				alert("이메일을 입력해주세요.");
				$("#email").focus();
				return false;
			}else if ($("#nickname").val() == "") {
				alert("닉네임을 입력해주세요.");
				$("#nickname").focus();
				return false;
			}
			if (idChkVal == "N") {
				alert("중복확인 버튼을 눌러주세요.");
			} else if (idChkVal == "Y") {
				$("#regForm").submit();
			}
		});
	})

	function fn_idChk() {
		$.ajax({
			url : "/member/idChk",
			type : "post",
			dataType : "json",
			data : {
				"userid" : $("#userid").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 아이디입니다.");
				} else if (data == 0) {
					$("#idChk").attr("value", "Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		})
	}
</script>
<%@ include file="../footer.jsp"%>