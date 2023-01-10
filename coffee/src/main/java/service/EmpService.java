package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.*;
import util.*;
import vo.Emp;

public class EmpService {
	private EmpDao empDao;
	//최고관리자가 하위 관리자 정보 수정 때 모든 정보 불러오기
	public Emp selectModifyEmp(int empCode) {
		Emp emp=null;
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.empDao=new EmpDao();
		try {
			conn=dbutil.getConnection();
			emp=empDao.selectModifyEmp(conn, empCode);
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
		return emp;
	}
	
	//최고관리자가 active 및 ahtoCode 변경
	public int modifyEmp(Emp emp) {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.empDao=new EmpDao();
		int row=0;
		try {
			conn=dbutil.getConnection();
			row=empDao.modifyEmp(conn, emp);
			//System.out.println(emp+"<==서비스");
			conn.commit();
			//System.out.println("커밋 됨");
		} catch (Exception e) {
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
		return row;
	}
	
	//최고 관리자가 하위 관리가 삭제
	public int removeEmp(int empCode) {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.empDao=new EmpDao();
		int row=0;
		try {
			conn=dbutil.getConnection();
			row=empDao.removeEmp(conn, empCode);
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
	
	//관리자 회원가입
	public int signUpEmp(Emp emp) {
		Connection conn=null;
		Dbutil dbutil=new Dbutil();
		this.empDao=new EmpDao();
		int row=0;
		try {
			conn=dbutil.getConnection();
			row=empDao.signUpEmp(conn, emp);
			if(row==1) {
				empDao.signUpEmpByOutid(conn, emp);
			}
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
		Dbutil dbutil=new Dbutil();
		this.empDao=new EmpDao();
		boolean result=false;
		try {
			conn=dbutil.getConnection();
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
		Dbutil dbutil=new Dbutil();
		this.empDao= new EmpDao();
		Emp resultEmp=null;
		try {
			conn=dbutil.getConnection();
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
	
	//관리자 멤버 리스트
		public ArrayList<Emp> selectEmpList(){
			Connection conn=null;
			Dbutil dbutil=new Dbutil();
			this.empDao= new EmpDao();
			ArrayList<Emp> list= null;
			try {
				conn=dbutil.getConnection();
				list=empDao.selectEmpList(conn);
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
			return list;
		}
}
