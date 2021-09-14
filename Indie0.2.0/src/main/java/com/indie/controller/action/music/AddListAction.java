package com.indie.controller.action.music;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.MemberDAO;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.MemberVO;

public class AddListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "";
		HttpSession session = request.getSession();
		
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		String list = request.getParameter("list");
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "IndieServlet?command=login";
		}else {
			PlaylistDAO playlistDAO = PlaylistDAO.getInstance();
			playlistDAO.addPlaylist(m_id,loginUser.getMb_id());
			
			switch(list) {
			case "allpop" :
				url = request.getContextPath() + "/IndieServlet?command=AllPopular";
				break;
			case "korpop" :
				url = request.getContextPath() + "/IndieServlet?command=KorPopular";
				break;
			case "forpop" :
				url = request.getContextPath() + "/IndieServlet?command=ForPopular";
				break;
			case "allnew" :
				url = request.getContextPath() + "/IndieServlet?command=AllNewest";
				break;
			case "kornew" :
				url = request.getContextPath() + "/IndieServlet?command=KorNewest";
				break;
			case "fornew" :
				url = request.getContextPath() + "/IndieServlet?command=ForNewest";
				break;
			case "allbal" :
				url = request.getContextPath() + "/IndieServlet?command=AllBallad";
				break;
			case "korbal" :
				url = request.getContextPath() + "/IndieServlet?command=KorBallad";
				break;
			case "forbal" :
				url = request.getContextPath() + "/IndieServlet?command=ForBallad";
				break;
			case "alldan" :
				url = request.getContextPath() + "/IndieServlet?command=AllDance";
				break;
			case "kordan" :
				url = request.getContextPath() + "/IndieServlet?command=KorDance";
				break;
			case "fordan" :
				url = request.getContextPath() + "/IndieServlet?command=ForDance";
				break;
			case "allhip" :
				url = request.getContextPath() + "/IndieServlet?command=AllHiphop";
				break;
			case "korhip" :
				url = request.getContextPath() + "/IndieServlet?command=KorHiphop";
				break;
			case "forhip" :
				url = request.getContextPath() + "/IndieServlet?command=ForHiphop";
				break;
			case "allin" :
				url = request.getContextPath() + "/IndieServlet?command=AllIndie";
				break;
			case "korin" :
				url = request.getContextPath() + "/IndieServlet?command=KorIndie";
				break;
			case "forin" :
				url = request.getContextPath() + "/IndieServlet?command=ForIndie";
				break;
				
			}
				
		}
		
		response.sendRedirect(url);
		
	}

}
