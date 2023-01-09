package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NoticeDao;
import util.Dbutil;
import vo.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
		
	//modifyNotice Form
	public Notice selectModifyNotice(int noticeCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.noticeDao= new NoticeDao();
		Notice n=new Notice();
		try {
			conn=dbUtil.getConnection();
			n=noticeDao.selectModifyNotice(conn, noticeCode);
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
		return n;
	}
	
	
	//modifyNotice ACtion
	public int modifyNotice(Notice notice) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.noticeDao= new NoticeDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			row=noticeDao.modifyNotice(conn, notice);
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
	
	//removeNotice
	public int removeNotice(int noticeCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.noticeDao= new NoticeDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
			row=noticeDao.removeNotice(conn, noticeCode);
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
		this.noticeDao= new NoticeDao();
		int row=0;
		try {
			conn=dbUtil.getConnection();
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
	public Notice noticeOne(int noticeCode) {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		Notice n = null;
		this.noticeDao=new NoticeDao();
		try {
			conn=dbUtil.getConnection();
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
	
	//total count
	public int selectNoticeCount() {
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.noticeDao= new NoticeDao();
		int count=1; //sql의 경우 1번째 인덱스부터 시작

		try {
			conn=dbUtil.getConnection();
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
	this.noticeDao= new NoticeDao();
	
	try {
		conn=dbUtil.getConnection();
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
