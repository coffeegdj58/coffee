package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Comment;
import vo.Notice;

public class CommentDao {
	
	//removeComment
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
	public int addComment(Connection conn,Comment comment) throws Exception {
		int row=0;
		String sql = "INSERT question_comment(question_code questionCode,comment_memo commentMemo,createdate) VALUES (?,?,NOW());";
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
