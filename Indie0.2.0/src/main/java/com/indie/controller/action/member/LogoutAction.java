package com.indie.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="IndieServlet?command=index";
	    
	    HttpSession session=request.getSession(false);
	    if(session!=null){
	      session.invalidate();
	    }    
	    
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
