package com.kh.serviceCenter.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.memManage.model.dao.memManageDao;
import com.kh.memManage.model.vo.Member;
import com.kh.serviceCenter.model.dao.ScDao;
import com.kh.serviceCenter.model.vo.FAQ; 
public class ScService {

	public int selectFAQListCount() {
		Connection conn = getConnection();
		
		int listCount = new ScDao().selectFAQListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<FAQ> selectFAQList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<FAQ> FAQList = new ScDao().selectFAQList(conn,pi);
		
		close(conn);
		return FAQList;
	}

	public void ajaxHideSc(int[] fnoArr) {
		Connection conn = getConnection();
		
		int result = new ScDao().ajaxHideSc(conn, fnoArr);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	public int insertFAQ(FAQ faq) {
		Connection conn = getConnection();
		
		int result = new ScDao().insertFAQ(conn, faq);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int updateFAQ(FAQ faq) {
		Connection conn = getConnection();
		
		int result = new ScDao().updateFAQ(conn, faq);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int searchFAQCount(String faqCate, String searchFaq) {
		Connection conn = getConnection();
		
		int listCount = new ScDao().searchFAQCount(conn, faqCate, searchFaq);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<FAQ> searchFAQ(String faqCate, String searchFaq, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<FAQ> fList = new ScDao().searchFAQ(conn, faqCate, searchFaq, pi);
		
		close(conn);
		return fList;
	}

}
