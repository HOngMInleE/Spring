package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller // bean 등록
public class InsertBoardController {
	
	// 어노테이션 방식	value: 요청 url 값 
	@RequestMapping(value="/insertBoard.do") // RequestMapping : forward방식
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		/* vo : command object*/
//		command object : 명령에 대한 처리 해줌 // 기능 같음, 생성 및 대입 포함
		System.out.println("글 등록 처리");
		
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle(title);
//		boardVO.setWriter(writer);
//		boardVO.setContent(content);
		
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}

}
