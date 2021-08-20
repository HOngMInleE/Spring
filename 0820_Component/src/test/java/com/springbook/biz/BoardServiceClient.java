package com.springbook.biz;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("tttt");
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) factory.getBean("boardService");
		
		BoardVO vo = new BoardVO(); 
		
		Scanner sc = new Scanner(System.in);
		String title = "";
		String writer = "";
		String content = "";
		
		System.out.println(" ===== 새로운 글 등록하기 ===== ");
		System.out.println("제목을 입력하세요.");
		title = sc.nextLine();
		System.out.println("작성자를  입력하세요.");
		writer = sc.nextLine();
		System.out.println("내용을 입력하세요.");
		content = sc.nextLine();
		
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		boardService.insertBoard(vo);
		
		sc.close();
		factory.close();
		
		
	}// main()

	
	
	
	
}
