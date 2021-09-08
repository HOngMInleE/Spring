package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("로그인처리");
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2.DB 연동 처리
		UserVO userVO = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		userVO.setId(id);
		userVO.setPassword(password);
		UserVO user = userDAO.getUser(userVO);

		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		
		if (user!= null) {
			System.out.println("로그인 성공");
			mav.setViewName("redirect:getBoardList.do");
		}else {
			System.out.println("로그인 실패");
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
		
//		if (user != null) {
//			System.out.println("로그인 성공");
//			return "getBoardList.do"; // 페이지 이동 바로하지않고 url값만 넘김(Spring의원리이해위해)
//		} else {
//			System.out.println("로그인 실패");
//			return "login"; //.jsp 지움, ViewResolver가 확장자 생성해줌.
//		}
		
	}//handelRequest()

}
