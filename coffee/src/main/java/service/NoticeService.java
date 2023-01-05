package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.*;
import util.*;
import vo.*;

public class NoticeService {
	private NoticeDao noticeDao;
	
	//removeNotice
	public int deleteNotice(int noticeCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		noticeDao= new NoticeDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			conn.setAutoCommit(false);
			row=noticeDao.deleteNotice(conn, noticeCode);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
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
	
	//addNotice
	public int addNotice(Notice notice) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		noticeDao= new NoticeDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			conn.setAutoCommit(false);
			row=noticeDao.addNotice(conn, notice);
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
	public Notice getBoardOne(int noticeCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		Notice n = null;
		this.noticeDao=new NoticeDao();
		try {
			conn=dbUtil.getConnection();
			conn.setAutoCommit(false);
			n=noticeDao.noticeOne(conn, noticeCode);
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
		return n;
	}
	
	//
	public int selectNoticeCount() {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		noticeDao= new NoticeDao();
		int count=1; //sql의 경우 1번째 인덱스부터 시작

		try {
			conn=dbUtil.getConnection();
			conn.setAutoCommit(false);
			count=noticeDao.selectNoticeCount(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	
	//noticeList+페이징
	public ArrayList<Notice> getBoardListByPage(int beginRow, int rowPerPage){
	ArrayList<Notice> list=null;
	Connection conn=null;
	Dbutil dbUtil= new Dbutil();
	noticeDao= new NoticeDao();
	
	try {
		conn=dbUtil.getConnection();
		conn.setAutoCommit(false);
		list=noticeDao.selectNoticeListByPage(conn, beginRow, rowPerPage);
	} catch (Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
	}
	
	
}
