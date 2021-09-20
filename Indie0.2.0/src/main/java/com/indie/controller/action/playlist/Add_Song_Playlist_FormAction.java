package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.indie.dto.PlaylistVO;

public class Add_Song_Playlist_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Add_Song_Playlist_FormAction 실행");
		String url = "/playlist/playlist_add.jsp";
		
		HttpSession session = request.getSession();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		System.out.println(loginUser);
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		
		List<PlaylistVO> my_playlist = plDAO.getPlaylistById(loginUser.getMb_id());
		
		request.setAttribute("my_playlist", my_playlist);
		request.setAttribute("m_id", m_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
