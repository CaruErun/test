package com.kh.board.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.PageInfo;
import com.kh.member.model.dao.MemberDao;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().selectListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn=getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn,pi);
		
		close(conn);
//		System.out.println(list);
		return list;
		
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		return list;
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		int result1 = new BoardDao().insertBoard(conn,b);
		int result2 = 1;
		if(at!=null) {
			result2 = new BoardDao().insertAttachment(conn,at);
		}
		
		close(conn);
		
		if(result1>0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result1*result2;
	}

	public int increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, boardNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return result;
	}
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Board b = new BoardDao().selectBoard(conn,boardNo);
		
		close(conn);
		return b;
	}

	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		
		Attachment a = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		return a;
	}

	public int updateBoard(Board b, Attachment a) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().updateBoard(conn, b);
		int result2=1;
		if(a!=null) {
			if(a.getFileNo()==0) {
				result2 = new BoardDao().updateAttachmentNone(conn, a);
			}else {
				result2 = new BoardDao().updateAttachment(conn, a);
			}
		}
		result1 = result1 * result2;
		if(result1>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		
		int result1 = 0;
		int result2=0;
		
		result1 = new BoardDao().deleteBoard(conn,boardNo);
		result2 = new BoardDao().deleteAttachment(conn,boardNo);
		
		if(result1>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}

	public int insertThumbnailBoard(Board b, ArrayList<Attachment> aList) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertThumbnailBoard(conn,b);
		int result2 = new BoardDao().insertThumbnailAttachment(conn, aList);
		
		if((result1*result2)>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1*result2;
		
	}

	public ArrayList<Board> selectThumbnail() {
		Connection conn = getConnection();
		
		ArrayList<Board> aList = new BoardDao().selectThumbnail(conn);
		close(conn);
		return aList;
	}

	public ArrayList<Board> selectThumbnailBoard(int boardNo) {
		Connection conn = getConnection();
		ArrayList<Board> bList = new BoardDao().selectThumbnailBoard(conn,boardNo);
		close(conn);
		return bList;
	}

	public ArrayList<Reply> selectReplyList(int boardNo) {
		Connection conn = getConnection();
		
		ArrayList<Reply> rList = new BoardDao().selectReplyList(conn,boardNo);
		
		close(conn);
		
		return rList;
		
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn,r);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
	}



}