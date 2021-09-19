package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indie.controller.action.Action;
import com.indie.dao.BoardDAO;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.BoardVO;
import com.indie.dto.MemberVO;

public class Add_Song_Playlist_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Playlist_FormAction 실행");
		String url = "playlist/playlist.jsp";
		
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		HttpSession session = request.getSession();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		
		plDAO.insertPlaylist_Music(loginUser.getMb_id(), pl_num);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
