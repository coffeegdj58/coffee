package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Emp;

public class EmpDao {
	
	//최고관리자가 하위 관리자 정보 수정 때 모든 정보 불러오기
	public Emp selectModifyEmp(Connection conn, int empCode)throws Exception {
		Emp emp=null;
		String sql="SELECT emp_code empCode,emp_id empId, emp_name empName, active active,auth_code authCode,createdate createdate FROM emp WHERE emp_code=?;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, empCode);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			emp= new Emp();
			emp.setEmpId(rs.getString("empId"));
			emp.setEmpName(rs.getString("empName"));
			emp.setActive(rs.getString("active"));
			emp.setAuthCode(rs.getInt("authCode"));
			emp.setCreatedate(rs.getString("createdate"));
			emp.setEmpCode(rs.getInt("empCode"));
		}
		rs.close();
		stmt.close();
		return emp;
	}
	
	//최고관리자가 active 및 ahtoCode 변경
	public int modifyEmp(Connection conn, Emp emp) throws Exception {
		int row=0;
		String sql="UPDATE emp SET active=?, auth_code=? WHERE emp_code=?; ";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emp.getActive());
		stmt.setInt(2, emp.getAuthCode());
		stmt.setInt(3, emp.getEmpCode());
		//System.out.println(stmt);
		row=stmt.executeUpdate();
		if(row==1) {
			//System.out.println(row+"row: dao");
			//System.out.println("수정성공: dao");
		}
		stmt.close();
		return row;
	}
	
	//최고 관리자가 하위 관리가 삭제
	public int removeEmp(Connection conn, int empCode) throws Exception{
		int row=0;
		String sql="DELETE FROM emp WHERE emp_code=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, empCode);
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("삭제성공: dao");
		}
		stmt.close();
		return row;
	}
	
	//관리자 회원가입
	//outid에 저장 쿼리
	public int signUpEmpByOutid(Connection conn, Emp emp) throws Exception{
		int row=0;
		String sql="INSERT INTO outid(id) VALUES (?);";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("관리자 회원가입 성공: outIdEmpDao");
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
			System.out.println("관리자 회원가입 성공: empDao");
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
			resultEmp.setAuthCode(rs.getInt("authCode"));
			resultEmp.setCreatedate(rs.getString("createdate"));
		}
		rs.close();
		stmt.close();
		return resultEmp;
	}
	
	//관리자 멤버 리스트
	public ArrayList<Emp> selectEmpList(Connection conn) throws Exception{
		ArrayList<Emp> list= new ArrayList<Emp>();
		String sql="SELECT emp_code empCode,emp_id empId,emp_name empName,active,auth_code authCode,createdate FROM emp ORDER BY createdate";
		PreparedStatement stmt= conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Emp e=new Emp();
			e.setEmpCode(rs.getInt("empCode"));
			e.setEmpId(rs.getString("empId"));
			e.setEmpName(rs.getString("empName"));
			e.setActive(rs.getString("active"));
			e.setAuthCode(rs.getInt("authCode"));
			e.setCreatedate(rs.getString("createdate"));
			list.add(e);
		}
		return list;
	}
	
	
}
