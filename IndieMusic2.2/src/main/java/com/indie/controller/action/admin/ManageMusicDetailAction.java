package com.indie.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class ManageMusicDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("뮤직 상세 컨트롤러 실행");
		String url = "/adminMode/music/detailMusicForm.jsp";

		String m_id = request.getParameter("m_id");

		MusicDAO musicDAO = MusicDAO.getInstance();
		MusicVO musicInfo = musicDAO.getMusic(Integer.parseInt(m_id));

		request.setAttribute("selected", "music");
		request.setAttribute("musicInfo", musicInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
