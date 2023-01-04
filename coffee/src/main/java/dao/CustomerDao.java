package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	//customer id check 쿼
	public int checkCustomeId(String customerId, Connection conn) throws Exception{
		int result= 0;
		
		String sql = "SELECT customer FROM customer WHERE customer_id= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		result= stmt.executeUpdate();
		
		String sql1 = "SELECT id FROM outid WHERE id= ?";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		stmt1.setString(1, customerId);
		
		result = stmt1.executeUpdate();
		
		
		
		return result;
	}
}
