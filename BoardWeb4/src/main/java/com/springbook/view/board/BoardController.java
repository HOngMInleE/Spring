package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;   //BoardServiceImpl
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) { // true : empty.
			String fileName = uploadFile.getOriginalFilename();
			try {						// 경로 정보
				uploadFile.transferTo(new File("D:\\" + fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("file 생성 실패");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("file 생성 실패");
			}
		}
		
		boardService.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		//System.out.println("작성자 이름 : " + vo.getWriter());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board",boardService.getBoard(vo));
		return "getBoard.jsp";
	}

	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditonMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		
		// TITLE = ""(빈문자) -> 전체 검색
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp";  //View 이름 리턴
	}
	
	

}

