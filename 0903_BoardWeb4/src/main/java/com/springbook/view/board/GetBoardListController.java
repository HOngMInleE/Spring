package com.springbook.view.board;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리 ");
		
//		BoardVO boardVO = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
//		HttpSession session = request.getSession(); // mav가 세션역할해줌.
//		session.setAttribute("boardList", boardList);
		
//		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList",boardList);
		mav.setViewName("getBoardList.jsp");
		
		return mav;	
	}

}
