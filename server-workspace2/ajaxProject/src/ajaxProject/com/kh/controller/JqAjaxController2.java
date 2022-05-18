package ajaxProject.com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import ajaxProject.com.kh.model.vo.Member;

/**
 * Servlet implementation class JqAjaxController2
 */
@WebServlet("/jqAjax2.do")
public class JqAjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		//ajax는 결과를 하나만 응답할 수 있음
		
//		String responseData = "이름" + name + "나이" + age;
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(responseData);
		//	-하나의 문자열로 이어져서 응답
		
		//여러 개 데이터 응답 JSON 방식
		/*
		 * JSON (JavaScript Object Notation : 자바스크립트 객체 표기법)
		 * -ajax 통신시 데이터 전송에 사용되는 포맷 형식 중 하나
		 * - https://code.google.com/archive/p/json-simple/downloads
		 * 
		 * 
		 * JSONArray[value, ...] - 배열형태
		 * JSONObject[key:value, ...] - 객체 형태
		 * 
		 * GSON : Google JSON
		 * GSON 라이브러리 이용해야함
		 */
		
//		JSONArray jarr = new JSONArray();
//		jarr.add(name);
//		jarr.add(age);
//		response.setContentType("application/json; charset=UTF-8" );
//		response.getWriter().print(jarr);
		
		JSONObject jobj= new JSONObject();
		Member m = new Member("요요요",123);
//		jobj.put("name", name);
//		jobj.put("age", age);
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		gson.toJson(m,response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
