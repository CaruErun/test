package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			int boardNo = Integer.parseInt(multiRequest.getParameter("bno"));
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			Board b = new Board(boardNo,category,boardTitle,boardContent);
			
			Attachment a = null;
			if(multiRequest.getOriginalFileName("reUpfile") != null) {
				//originName,changeName,filePath
				a = new Attachment(multiRequest.getOriginalFileName("reUpfile"),
						multiRequest.getFilesystemName("reUpfile"),
						"resources/board_upfiles/");
				if(multiRequest.getParameter("originFileNo")!=null) {
					a.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
				}else {
					a.setRefNo(boardNo);
				}
			}
			System.out.println(a);
			int result = new BoardService().updateBoard(b,a);
			
			if(result>0) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "수정이 완료되었습니다.");
				response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+boardNo);
			}else {
				request.setAttribute("errorMsg", "수정실패");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
