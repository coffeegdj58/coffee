package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Comment;
import vo.Notice;

public class CommentDao {
	
	//removeComment 
	// 답변이 삭제 되면 문의 사항에 flag 값을 N으로 변경하기 위해
	public int updateFlagremove(Connection conn,int questionCode) throws Exception{
		int row=0;
		String sql="UPDATE question SET flag = 'N' WHERE question_code=?;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,questionCode);
		row=stmt.executeUpdate();
		if (row == 1) {
			System.out.println("flag 수정 성공: dao");
		}
		stmt.close();
		return row;
	}
	//답변을 삭제하기 위해
	public int removeComment(Connection conn, int commentCode) throws Exception {
		int row=0;
		String sql = "DELETE FROM question_comment WHERE comment_code=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, commentCode);
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("삭제 성공: dao");
		}
		stmt.close();
		return row;
	}
	
	
	//addComment
	// 답변을 추가 되면 문의 사항에 flag 값을 Y으로 변경하기 위해
	public int updateFlagadd(Connection conn,Comment comment) throws Exception{
		int row=0;
		String sql="UPDATE question SET flag = 'Y' WHERE question_code=?;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, comment.getQuestionCode());
		row=stmt.executeUpdate();
		if (row == 1) {
			System.out.println("flag 수정 성공: dao");
		}
		stmt.close();
		return row;
	}
	//답변을 추가하기 위해
	public int addComment(Connection conn,Comment comment) throws Exception {
		int row=0;
		String sql = "INSERT INTO question_comment(question_code, comment_memo, createdate) VALUES (?,?,NOW());";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, comment.getQuestionCode());
		stmt.setString(2, comment.getCommentMemo());
		row=stmt.executeUpdate();
		if (row == 1) {
			System.out.println("추가 성공: dao");
		}
		stmt.close();
		return row;
	}
	//commentOne
	public Comment commentOne(Connection conn, int questionCode) throws Exception {
		String sql = "SELECT comment_code commentCode, comment_memo commentMemo, createdate FROM question_comment WHERE question_code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		ResultSet rs = stmt.executeQuery();
		Comment c = new Comment();
		if(rs.next()) {
			c.setCommentCode(rs.getInt("commentCode"));
			c.setCommentMemo(rs.getString("commentMemo"));
			c.setCreatedate(rs.getString("createdate"));
		}
		rs.close();
		stmt.close();
		return c;
	}
	
	
}
