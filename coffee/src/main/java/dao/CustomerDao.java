package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Customer;

public class CustomerDao {
	
	//customer insert 쿼리
	public int insertCustomer(Customer cust, Connection conn) throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO(customer_id, customer_pw, customer_name, customer_phone, customer_gender, customer_birth)VALUES(?,password(?),?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, cust.getCustomerId());
		stmt.setString(2, cust.getCustomerPw());
		stmt.setString(3, cust.getCustomerName());
		stmt.setString(4, cust.getCustomerPhone());
		stmt.setString(5, cust.getCustomerGender());
		stmt.setString(6, cust.getCustomerBirth());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	//customer id check 쿼리
	public int checkCustomeId(String customerId, Connection conn) throws Exception{
		int result= 0;
		
		
		//customer table에서 찾는 쿼리
		String sql = "SELECT customer FROM customer WHERE customer_id= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			result= 1;
		}
		
		
		//outid 에서찾는쿼리
		String sql1 = "SELECT id FROM outid WHERE id= ?";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		stmt1.setString(1, customerId);
		
		ResultSet rs1= stmt.executeQuery();
		
		if(rs1.next()) {
			result=1;
		}
		
		rs.close();
		rs1.close();
		stmt.close();
		stmt1.close();
		
		return result;
	}
	
	//customer update 쿼리
	public int updateCustomer(Customer customer, String customerPw, Connection conn) throws Exception{
		int result= 0;
		String sql = "UPDATE customer SET "
				+ "customer_pw = password(?), customer_name= ?, customer_phone = ?, customer_gender= ?, customer_birth= ?"
				+ " WHERE customer_id= ? AND customer_pw = password(?) ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getCustomerPw());
		stmt.setString(2, customer.getCustomerName());
		stmt.setString(3, customer.getCustomerPhone());
		stmt.setString(4, customer.getCustomerGender());
		stmt.setString(5, customer.getCustomerBirth());
		stmt.setString(6, customer.getCustomerId());
		stmt.setString(7, customerPw);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	//pw update시에 pwhistory에 넣는 쿼리
	public int insertPwHistory(String customerId, String customerPw, Connection conn) throws Exception{
		int result = 0;
		
		String sql = "INSERT INTO pw_history(customer_id, pw) VALUES (?, password(?))";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, customerPw);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
	//pw update시 pwhistory에서 중복된 것을 찾는 쿼리
	public int pwCheck(String customerId, String customerPw, Connection conn)  throws Exception{
		int result = 0;
		
		String sql = "SELECT * FROM pw_history WHERE customer_id=? AND pw=password(?)";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, customerPw);
		
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			result=1;
		}
		rs.close();
		stmt.close();
		
		return result;
	}
	
	//회원 삭제 쿼리
	public int deleteCustomer(String customerId, String customerPw, Connection conn) throws Exception{
		int result= 0;
		
		String sql = "DELETE FROM customer WHERE customer_id=? AND customer_pw= password(?)";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, customerPw);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		return result;
		
	}
	
	//insertoutid timing == insertcustomer
	public int signUpEmpByOutid(Connection conn, String customerId) throws Exception{
	      int row=0;
	      String sql="INSERT INTO outid(id) VALUES (?);";
	      PreparedStatement stmt=conn.prepareStatement(sql);
	      stmt.setString(1, customerId);
	      row=stmt.executeUpdate();
	      if(row==1) {
	         System.out.println("관리자 회원가입 성공");
	         
	      }
	      stmt.close();
	      return row;
	   }
	
	//insertpoint 고객 테이블에 넣는 쿼리
	public int insertPointInCustomer(String customerId, Connection conn, int sum) throws Exception{ 
		int result =0;
		
		String sql= "UPDATE customer SET point= ? WHERE customer_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, (int)Math.floor(sum/100*3));
		stmt.setString(2, customerId);
		result = stmt.executeUpdate();
		
		return result;
	}

	//updatepoint
	
	
}
