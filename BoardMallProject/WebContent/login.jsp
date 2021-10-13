<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<!-- 로그인 화면 구성 -->
<main class="text-center position-absolute top-50 start-50 translate-middle">
  <form class="" method="post">
    <h1 class="h3 mb-5 fw-normal">회원 로그인</h1>

    <div class="form-floating">
      <input class="form-control mb-3" type="text" id="floatingInput">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control mb-3" id="floatingPassword">
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div class="mb-3" style=" float : left;">
      <label>
        <input type="checkbox" value=""> 아이디 저장
      </label>
    </div>
    <div class="mb-3" style=" float : right;">
    <label>
        <a class="text-decoration-none text-dark" href="#">아이디</a>  /
      </label>
      <label>
        <a class="text-decoration-none text-dark" href="#">비밀번호 찾기</a>
      </label>
     </div>

    <button class="w-100 btn btn-lg btn-primary mb-3" type="submit">로그인</button>
    <button class="w-100 btn btn-lg btn-light" type="" style="border: 1px solid black;">회원가입</button>
  </form>
</main>




<section style="height:1000px;">
	
</section>


<%@ include file="../footer.jsp" %>