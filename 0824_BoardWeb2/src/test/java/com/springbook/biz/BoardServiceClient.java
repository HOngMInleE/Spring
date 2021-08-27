package com.springbook.biz;

import java.util.List;
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
		int menu = 0;
		int seq = 0;
		String title = "";
		String writer = "";
		String content = "";
		
		while (menu != 6) {
			System.out.println();
			System.out.println("1.글추가 2.전체글조회 3.특정글조회 4.글정보수정 5.글삭제 6.프로그램종료");
			System.out.print("메뉴 선택 >> ");
			menu = sc.nextInt();
			
			sc.nextLine(); // 남겨진 개행문자 입력 처리
			
			switch (menu) {
				default : 
					System.out.println("1 ~ 6 번 중 입력하세요.");
					break;
				case 1 : 
					System.out.println("등록할 글 정보를 입력하세요.");
					System.out.print("글제목 : ");
					title = sc.nextLine();
					System.out.print("작성자 : ");
					writer = sc.nextLine();
					System.out.print("글 내용 : ");
					content = sc.nextLine();
					
//					vo.setSeq(seq);// transaction 테스트위해 작성
					// 실행 중 문제가 생겨서 transaction이 롤백함.
					
					vo.setTitle(title);
					vo.setWriter(writer);
					vo.setContent(content);
					boardService.insertBoard(vo);
					break;
				case 2 :
					boardService.getBoardList(vo);
					List<BoardVO> boardList = boardService.getBoardList(vo);
					System.out.println();
					for (BoardVO board : boardList) {
						System.out.println("--->" + board.toString());
					}
					break;
				case 3 : 
					System.out.print("조회 글 번호 입력 : ");
//					seq = sc.nextInt();
//					sc.nextLine(); // 남겨진 개행문자 입력 처리
					
					vo.setSeq(9);
					boardService.getBoard(vo);
					System.out.println(vo.toString());
					break;
				case 4 :
					System.out.print("수정 글 번호 입력 : ");
					seq = sc.nextInt();
					sc.nextLine(); // 남겨진 개행문자 입력 처리
					
					vo.setSeq(seq);
					System.out.print("글 제목 :");
					title = sc.nextLine();
					vo.setTitle(title);
					System.out.print("글 내용 : ");
					content = sc.nextLine();
					vo.setContent(content);
					
					boardService.updateBoard(vo);
					break;
				case 5 :
					System.out.print("삭제 글 번호 입력 : ");
					seq = sc.nextInt();
					vo.setSeq(seq);
					boardService.deleteBoard(vo);
					boardService.getBoardList(vo);
					break;
				case 6 :
					System.out.println("프로그램 종료");
					break;
			}// switch
		}// while
		
		
		// close
		sc.close();
		factory.close();
		
	}// main()

	
	
	
	
}
