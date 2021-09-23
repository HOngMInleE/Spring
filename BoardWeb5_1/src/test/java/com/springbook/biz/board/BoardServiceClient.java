package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClient {
	
	public static void main(String[] args) {
	
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis_title");
		vo.setWriter("myBatis_writer");
		vo.setContent("myBatis_content");
		
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		for(BoardVO board : boardList) {
			System.out.println(">> " + board.toString());
		}
		
	}

}