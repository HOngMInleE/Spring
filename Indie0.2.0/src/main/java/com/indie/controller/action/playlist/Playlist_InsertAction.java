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
import com.indie.dto.PlaylistVO;

public class Playlist_InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Playlist_InsertAction 실행");
		
		String url = "IndieServlet?command=Playlist_My_FormAction&mb_id="+request.getAttribute("loginUser.getMb_id");
		
		HttpSession session = request.getSession();
		PlaylistVO plVO = new PlaylistVO();
		PlaylistDAO plDAO = PlaylistDAO.getInstance();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int pl_num = Integer.parseInt(request.getParameter("pl_num"));
		
		
		String pl_title = request.getParameter("pl_title");
		
		plVO.setMb_id(loginUser.getMb_id());
		plVO.setPl_title(pl_title);
		
		plDAO.insertPlaylist();
		plDAO.insertPlaylist_Music(loginUser.getMb_id(), pl_num);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}