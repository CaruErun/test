package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ThumbnailInsertController
 */
@WebServlet("/insert.th")
public class ThumbnailInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/thumbnail_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			Board b = new Board();
			
			b.setBoardWriter(multiRequest.getParameter("userNo"));
			b.setBoardTitle(multiRequest.getParameter("boardTitle"));
			b.setBoardContent(multiRequest.getParameter("boardContent"));
			
			ArrayList<Attachment> aList = new ArrayList<>();
			
			for(int i=1;i<=4;i++) {
				String key = "files"+i;
				if(multiRequest.getOriginalFileName("files"+i)!=null) {
					Attachment a = new Attachment(multiRequest.getOriginalFileName(key),
							multiRequest.getFilesystemName(key));
					a.setFilePath("resources/thumbnail_upfiles/");
					if(i==1) a.setFileLevel(1);
					else a.setFileLevel(2);
					aList.add(a);
				}
			}
			int result = new BoardService().insertThumbnailBoard(b,aList);
			
			if(result>0) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "사진게시판 작성이 완료되었습니다.");
				response.sendRedirect(request.getContextPath()+"/list.th");
			}else {
				request.setAttribute("errorMsg", "사진게시판 작성에 실패하였습니다.");
				request.getRequestDispatcher("/views/common/errorPage.jsp");
			}
			
			
			
			
			
			
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