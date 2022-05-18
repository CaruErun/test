package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
		int listCount;//현재 총 게시글 개수
		int currentPage;//현재페이지(사용자 요청 페이지)
		int pageLimit; //페이지 하단 페이징 페이지 처리 개수
		int boardLimit; //한 페이지에서 보여지는 게시글 개수
		int maxPage; //가장 마지막 페이지
		int startPage; // 페이지 하단 보여질 페이징 시작수
		int endPage; //페이지 하단에 보여질 페이징 수 
		
		listCount = new BoardService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit=10;
		
		boardLimit=10;
		
		maxPage = (listCount/boardLimit)+((listCount%boardLimit==0) ? 0 : 1);
		
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		endPage = startPage+pageLimit-1;
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		//1.페이징바를 만들때 필요한 객체
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<Board> list = new BoardService().selectList(pi);
//		System.out.println(pi);
//		System.out.println(list);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequesct request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}