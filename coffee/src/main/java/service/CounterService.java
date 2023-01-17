package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CounterDao;
import util.Dbutil;

public class CounterService {
	private CounterDao counterDao;
	//오늘: 접속자가 처음 발생
	public void insertCounter() {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.counterDao=new CounterDao();
		try {
			conn=dbutil.getConnection();
			counterDao.insertCounter(conn);
			conn.commit();
			//System.out.println("커밋 됨");
		}catch (Exception e) {
			try {
				conn.rollback();
				//System.out.println("롤백 됨");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		//오늘: 접속자가 처음이 아닐 경우
	public void updateCounter() {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.counterDao=new CounterDao();
		try {
			conn=dbutil.getConnection();
			counterDao.updateCounter(conn);
			conn.commit();
			//System.out.println("커밋 됨");
		}catch (Exception e) {
			try {
				conn.rollback();
				//System.out.println("롤백 됨");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//오늘 접속자 수 확인
	public int selectTodayCount() {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.counterDao=new CounterDao();
		int todayCount=0;
		try {
			conn=dbutil.getConnection();
			todayCount=counterDao.selectTodayCount(conn);
			conn.commit();
			//System.out.println("커밋 됨");
		}catch (Exception e) {
			try {
				conn.rollback();
				//System.out.println("롤백 됨");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return todayCount;
	}
	//전체 접속 수 확인
	public int selectTotalCount() {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.counterDao=new CounterDao();
		int totalCount=0;
		try {
			conn=dbutil.getConnection();
			totalCount=counterDao.selectTodayCount(conn);
			conn.commit();
			//System.out.println("커밋 됨");
		}catch (Exception e) {
			try {
				conn.rollback();
				//System.out.println("롤백 됨");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
		
}
