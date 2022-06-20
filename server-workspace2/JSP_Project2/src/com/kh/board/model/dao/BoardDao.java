package com.kh.board.model.dao;
import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.PageInfo;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/db/board/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int listCount = 0;
		String sql = prop.getProperty("selectListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt= null;
		ArrayList<Board> list = new ArrayList<>();
		ResultSet rset = null;
		String sql =prop.getProperty("selectList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
						rset.getString("CATEGORY_NAME"),
						rset.getString("BOARD_TITLE"),
						rset.getString("USER_NAME"),
						rset.getInt("COUNT"),
						rset.getDate("CREATE_DATE")));
			}
;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

	public ArrayList<Category> selectCategoryList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Category(rset.getInt("CATEGORY_NO"),
						rset.getString("CATEGORY_NAME")));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertBoard(Connection conn, Board b) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getCategoryNo());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardWriter());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int insertAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	public int increaseCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result= 0;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public Board selectBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		Board b = null;
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO"),
						rset.getString("CATEGORY_NAME"),
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"),
						rset.getString("USER_NAME"),
						rset.getDate("CREATE_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public Attachment selectAttachment(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment a =null;
		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				a = new Attachment(rset.getInt("FILE_NO"),
							rset.getString("ORIGIN_NAME"),
							rset.getString("CHANGE_NAME"),
							rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return a;
	}
	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getCategoryNo());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		

		return result;
	}
	public int updateAttachmentNone(Connection conn, Attachment a) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateAttachmentNone");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getRefNo());
			pstmt.setString(2, a.getOriginName());
			pstmt.setString(3, a.getChangeName());
			pstmt.setString(4, a.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}
	public int updateAttachment(Connection conn, Attachment a) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateAttachment");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getOriginName());
			pstmt.setString(2,a.getChangeName());
			pstmt.setString(3,a.getFilePath());
			pstmt.setInt(4, a.getFileNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;

	}

	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteAttachment(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertThumbnailBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("insertThumbnailBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertThumbnailAttachment(Connection conn, ArrayList<Attachment> aList) {
		PreparedStatement pstmt = null;
		int result=1;
		String sql = prop.getProperty("insertThumbnailAttachment");
		
		try {
			for(Attachment a : aList) {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getOriginName());
			pstmt.setString(2, a.getChangeName());
			pstmt.setString(3, a.getFilePath());
			pstmt.setInt(4, a.getFileLevel());
			
			result = result * pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectThumbnail(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Board> aList = new ArrayList<>();
		
		String sql = prop.getProperty("selectThumbnailList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				aList.add(new Board(rset.getInt("BOARD_NO"),
						rset.getString("BOARD_TITLE"),
						rset.getInt("COUNT"),
						rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return aList;
	}

	public ArrayList<Board> selectThumbnailBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> bList = new ArrayList<Board>();
		String sql = prop.getProperty("selectThumbnailDetail");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				bList.add(new Board(rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"),
						rset.getString("USER_NAME"),
						rset.getDate("CREATE_DATE"),
						rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return bList;
	}

	public ArrayList<Reply> selectReplyList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> rList = new ArrayList<>();
		String sql = prop.getProperty("selectReplyList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				rList.add(new Reply(rset.getInt("REPLY_NO"),
						rset.getString("REPLY_CONTENT"),
						rset.getString("USER_NAME"),
						rset.getString("CREATE_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

	public int insertReply(Connection conn, Reply r) {
		int result=0;
		PreparedStatement pstmt = null;
	
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBno());
			pstmt.setInt(3, Integer.parseInt(r.getReplyWriter()));
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	

//	public ArrayList<Attachment> selectThumbnailAttachment(Connection conn, int boardNo) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<Attachment> aList = new ArrayList<Attachment>();
//		String sql = prop.getProperty("selectThumbnailAttachment");
//		
//		try {
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1, boardNo);
//			rset=pstmt.executeQuery();
//			if(rset.next()) {
//				b.setBoardTitle(rset.getString("BOARD_TITLE"));
//				b.setBoardContent(rset.getString("BOARD_CONTENT"));
//				b.setBoardWriter(rset.getString("USER_NAME"));
//				b.setCreateDate(rset.getDate("CREATE_DATE"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		return aList;
//	}
	
}