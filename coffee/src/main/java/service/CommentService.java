package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.*;
import util.*;
import vo.*;

public class CommentService {
	private CommentDao commentDao;
	
	//removeComment
	public int removeComment(int commentCode,int questionCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.commentDao= new CommentDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			row=commentDao.removeComment(conn, commentCode);
			if(row==1) {//답변을 삭제한다면 문의 사항에 flag 값을 N으로 변경하기 위해
				commentDao.updateFlagremove(conn, questionCode);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//addComment
	public int addComment(Comment comment) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.commentDao= new CommentDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			row=commentDao.addComment(conn, comment);
			if(row==1) {//답변이 추가 됐다면 문의 사항에 flag 값을 Y으로 변경하기 위해
				commentDao.updateFlagadd(conn, comment);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//noticeOne
	public Comment commentOne(int questionCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		Comment c = null;
		this.commentDao=new CommentDao();
		try {
			conn=dbUtil.getConnection();
			c=commentDao.commentOne(conn, questionCode);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}
}
