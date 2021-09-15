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

public class Playlist_Delete_SongAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Playlist_DeleteAction 실행");
		String url = "playlist/playlist_detail.jsp";
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		String m_id = request.getParameter("m_id");
		
		plDAO.deleteSongsInPlaylist(loginUser.getMb_id(), pl_num, m_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
