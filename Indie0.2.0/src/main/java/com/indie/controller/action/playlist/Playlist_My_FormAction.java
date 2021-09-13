package com.indie.controller.action.playlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.PlaylistDAO;
import com.indie.dto.PlaylistVO;

public class Playlist_My_FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Playlist_My_FormAction 실행");
		String url = "playlist/MyPlaylist.jsp";
		
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		String mb_id = request.getParameter("mb_id");
		List<PlaylistVO> my_playlist = plDAO.getPlaylistById(mb_id);
		
		request.setAttribute("my_playlist", my_playlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
