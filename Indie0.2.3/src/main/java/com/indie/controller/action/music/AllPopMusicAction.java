package com.indie.controller.action.music;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indie.controller.action.Action;
import com.indie.dao.MusicDAO;
import com.indie.dto.MusicVO;

public class AllPopMusicAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String url = "/music/allPopChart.jsp";
		
		String value = request.getParameter("B1");
		
		MusicDAO musicDAO = MusicDAO.getInstance();
		
		ArrayList<MusicVO> getAllPopular = (ArrayList<MusicVO>) musicDAO.getAllPopular();
		
		request.setAttribute("getAllPopular", getAllPopular);
		request.setAttribute("value", value);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
