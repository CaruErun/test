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
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
//		String category =request.getParameter("category");
//		String title = request.getParameter("title");
		
		//전송방식이 multipart/form-data로 전송하는 경우
		//request에서 값을 못꺼내므로 http://www.servlets.com/cos/ 에서 lib 를 통해 multipart 객체에 값을 받아와야함.
		
		//파일 크기를 10mbyte로 제한
		int maxSize = 10 * 1024 * 1024;
		
		/*
		 * 1_2 전달 파일 저장할 서버 폴더 경로 알아내기 (String savePath)
		 * 세션객체에서 제공하는 getRealPath 메소드를 통해서 알아내기
		 * WebContent 폴더로부터 board_upfiles 폴더까지 경로 제시
		 * 
		 * 경로 마지막에 /(slash) 추가해야함 (파일을 넣어야 함으로)
		 * 
		 * 
		 * 
		 */
		String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
		
		
		/*
		 * 2.전달된 파일명 수정과 서버에 업로드 작업
		 * -HttpServletRequest request -> MultipartRequest multiRequest 로 변환
		 * 
		 * 매개변수 생성자로 생성(cos.jar 에서 제공)
		 * MultipartRequest multiRequest = new MultipartRequest(request,저장될폴더경로,용량제한,인코딩값,파일명수정객체);
		 * 
		 * 위에 구문 한줄로 첨부파일이 해당 폴더에 업로드 된다.
		 * 보통 사용자가 올린 파일명을 그대로 사용하지 않고 변경해서 사용함(파일명 수정객체)
		 *  - 같은 파일명일 경우, 한글/특문/띄어쓰기 포함 경우 서버에 따라 문제가 생길 수 있기 때문에 변경하여 저장함
		 *  
		 * 기본제공 파일명 수정 객체
		 * DefaultFileRenamePolicy 객체 (cos.jar에서 제공하는 객체)
		 * 내부적으로 rename() 메소드가 실행이 되면서 파일명 수정이 진행된다.
		 * 만약 동일한 파일명을 가진 파일이 업로드 되면 파일명 뒤에 숫자를 카운트해서 붙여준다.
		 * 
		 * 
		 * 
		 * 
		 * com.kh.common.MyFileRenamePolicy
		 * 
		 */

		MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
		
		
		/*
		 * 3.DB에 기록할 데이터들을 뽑아서 Attachment 객체에 담기
		 * -카테고리 제목 내용 작성자번호 가져와서 board 테이블에 넣기
		 * 첨부파일도 넘어왔다면 원본명, 수정명, 경로 뽑아서 Attachment 객체에 넣어야함
		 * 
		 */
		String category = multiRequest.getParameter("category");
		String boardTitle = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String boardWriter = multiRequest.getParameter("userNo");
		
		Board b = new Board(category,boardTitle,content,boardWriter);
		
		Attachment at = null;
//		multiRequest.getOriginFileName();
//		첨부파일이 있으면 원본명 /없으면 null;
		if(multiRequest.getOriginalFileName("upfile")!=null) {
			at = new Attachment(multiRequest.getOriginalFileName("upfile"),
					multiRequest.getFilesystemName("upfile"));
			at.setFilePath("resources/board_upfiles/");
		}
		
		//4.서비스 요청
		int result =  new BoardService().insertBoard(b,at);
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "작성이 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.bo?cpage=1");
		}else {
			if(at!=null) {
				new File(savePath+at.getChangeName()).delete();
			}
			request.setAttribute("errorMsg", "게시글 작성 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
		}
//		
//		
//		if(ServletFileUpload.isMultipartContent(request)) {
//			System.out.println("1");
//		}
//		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}