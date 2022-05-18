package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Connection conn=JDBCTemplate.getConnection();
		
		Member m = new MemberDao().loginMember(conn,userId,userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int insertMember(Member m) {
		Connection conn=JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
		
	}

	public Member updateMember(Member m) {
		Connection conn=JDBCTemplate.getConnection();
		Member updateMem = null;
		int result = new MemberDao().updateMember(conn, m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			//db에는 데이터가 변경되었으나 session loginUser객체정보는 갱신되지 않았음으로 처리해줘야함
			updateMem = new MemberDao().selectMember(conn,m.getUserId());
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return updateMem;
	}

	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updatePwdMember(conn,userId,userPwd,updatePwd);
		Member updateMem = null;
		if(result>0) {
			JDBCTemplate.commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, userId);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return updateMem;
	}

	public int deleteMember(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn,userId,userPwd);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int idCheck(String checkId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
		
	}

}
