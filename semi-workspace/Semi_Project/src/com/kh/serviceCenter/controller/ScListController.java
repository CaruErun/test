package com.kh.serviceCenter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.PageInfo;
import com.kh.serviceCenter.model.service.ScService;
import com.kh.serviceCenter.model.vo.FAQ;

/**
 * Servlet implementation class ScListController
 */
@WebServlet("/ScList.sc")
public class ScListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ajaxSwitch = 0;
		if(request.getParameter("ajaxSwitch")!=null) ajaxSwitch = Integer.parseInt(request.getParameter("ajaxSwitch"));
		
		int listCount = new ScService().selectFAQListCount();
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int pageLimit = 5;
		int boardLimit = 10;
		int maxPage = (listCount/boardLimit) + ((listCount % boardLimit != 0) ? 1 : 0);
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit-1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage, endPage);
		
		ArrayList<FAQ> FAQList = new ScService().selectFAQList(pi);
		if(FAQList!=null) {
		request.setAttribute("adCate",9);
		request.setAttribute("pi",pi);
		request.setAttribute("FAQList", FAQList);
		if(ajaxSwitch==1) {
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(FAQList,response.getWriter());
		}
		else request.getRequestDispatcher("/views/admin/serviceCenter/FAQList.jsp").forward(request, response);
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
