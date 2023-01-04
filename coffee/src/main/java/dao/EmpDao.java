package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.*;

public class EmpDao {
	
	
	//관리자 회원가입
	//outid에 저장 쿼리
	public int signUpEmpByOutid(Connection conn, Emp emp) throws Exception{
		int row=0;
		String sql="INSERT INTO outid(id) VALUES (?);";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("관리자 회원가입 성공");
			return 1;
		}
		stmt.close();
		return row;
	}
	//emp에 저장 쿼리
	public int signUpEmp(Connection conn, Emp emp) throws Exception{
		int row=0;
		String sql="INSERT INTO emp(emp_id, emp_pw, emp_name) VALUES (?,PASSWORD(?),?);";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		stmt.setString(2, emp.getEmpPw());
		stmt.setString(3, emp.getEmpName());
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("관리자 회원가입 성공");
			return 1;
		}
		stmt.close();
		return row;
	}
	
	//관리자 회원가입 id 중복확인
	public boolean idCkEmp(Connection conn, String empId) throws Exception{
		boolean result=false;
		String sql="SELECT id FROM outId WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, empId);
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			System.out.println("중복된 아이디입니다: dao");
			result=true;
		}
		rs.close();
		stmt.close();
		return result;
	}
	
	//관리자 로그인
	public Emp loginEmp(Connection conn, Emp emp) throws Exception{
		Emp resultEmp=null;
		String sql="SELECT emp_id empId, emp_pw empPw, emp_name empName, active, auth_code authCode, createdate  FROM emp WHERE emp_id=? AND emp_pw=PASSWORD(?); ";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		stmt.setString(2, emp.getEmpPw());
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			resultEmp= new Emp();
			resultEmp.setEmpId(rs.getString("empId"));
			resultEmp.setEmpName(rs.getString("empName"));
			resultEmp.setActive(rs.getString("active"));
			resultEmp.setAuthCode(rs.getString("authCode"));
			resultEmp.setCreatedate(rs.getString("createdate"));
		}
		rs.close();
		stmt.close();
		return resultEmp;
	}
}
