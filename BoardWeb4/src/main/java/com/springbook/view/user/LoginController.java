package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAOSpring;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService; // UserServiceImpl
	
	@RequestMapping(value= "/login.do", method=RequestMethod.GET)
	public String loginView(/* @ModelAttribute("user") */UserVO vo) {
		
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	// id, password 처리 메소드
	@RequestMapping(value= "/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		
		UserVO user = userService.getUser(vo);
		if (user != null) {
			
			session.setAttribute("userName", user.getName());
			
			return "getBoardList.do";
		}
		else
			return "login.jsp";
	}

}