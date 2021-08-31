package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
		request.setCharacterEncoding("UTF-8");
		
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		System.out.println(path);
		
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO userVO = new UserVO();
			UserDAO userDAO = new UserDAO();
			userVO.setId(id);
			userVO.setPassword(password);
			
			UserVO user = userDAO.getUser(userVO);

			if (user != null) {
				System.out.println("로그인 성공");
				response.sendRedirect("getBoardList.do");
			} else {
				System.out.println("로그인 실패");
				response.sendRedirect("login.do");
			}
			
		}else if (path.equals("/getBoardList.do")) { // url을 직접적으로 요청할 때
			System.out.println("글 목록 검색 처리 ");
			
			BoardVO boardVO = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(boardVO);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
			
		}else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			String seq = request.getParameter("seq");
			
			BoardVO boardVO = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			boardVO.setSeq(Integer.parseInt(seq));
			
			BoardVO board = boardDAO.getBoard(boardVO);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		}else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle(title);
			boardVO.setWriter(writer);
			boardVO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(boardVO);
			
			// jsp로 바동이동하지 않고 데이터 처리 위해 do로 이동
			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle(title);
			boardVO.setContent(content);
			boardVO.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(boardVO);
			
			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			String seq = request.getParameter("seq");
			
			BoardVO boardVO = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			boardVO.setSeq(Integer.parseInt(seq));
			boardDAO.deleteBoard(boardVO);
			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("logout.do")) {
			System.out.println("로그아웃 처리");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
		
	}//process()


}
