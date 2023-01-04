package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmpDao;
import util.*;
import vo.Emp;

public class EmpService {
	private EmpDao empDao;
	
	//관리자 회원가입
	public int signUpEmp(Emp emp) {
		Connection conn=null;
		Dbutil dbutil=null;
		this.empDao=new EmpDao();
		int row=0;
		try {
			conn=dbutil.getConnection();
			conn.setAutoCommit(false);
			empDao.signUpEmpByOutid(conn, emp);
			empDao.signUpEmp(conn, emp);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//관리자 회원가입 전 아이디 중복 확인
	public boolean idCkEmp(String empId) {
		Connection conn=null;
		Dbutil dbutil=null;
		this.empDao=new EmpDao();
		boolean result=false;
		try {
			conn=dbutil.getConnection();
			conn.setAutoCommit(false);
			result=empDao.idCkEmp(conn, empId);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//관리자 로그인
	public Emp loginEmp(Emp emp) {
		Connection conn=null;
		Dbutil dbutil=null;
		this.empDao= new EmpDao();
		Emp resultEmp=null;
		try {
			conn=dbutil.getConnection();
			conn.setAutoCommit(false);
			resultEmp=empDao.loginEmp(conn, emp);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultEmp;
	}
	
	
	
}
