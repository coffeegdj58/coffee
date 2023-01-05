package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Address;
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
	public int checkCustomerId(String customerId, Connection conn) throws Exception{
		int result= 0;

		//outid 에서찾는쿼리
		String sql1 = "SELECT id FROM outid WHERE id= ?";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		stmt1.setString(1, customerId);
		
		ResultSet rs1= stmt1.executeQuery();
		
		if(rs1.next()) {
			result=1;
		}
		
	
		rs1.close();
	
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
	public int signUpCustomerByOutid(Connection conn, String customerId) throws Exception{
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
	
	//포인트 적립시 실행 쿼리
	public int insertPointInCustomer(String customerId, Connection conn, int sum) throws Exception{ 
		int result =0;
		
		String sql= "UPDATE customer SET point= ? WHERE customer_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, (int)Math.floor(sum/100*3));
		stmt.setString(2, customerId);
		result = stmt.executeUpdate();
		stmt.close();
		
		return result;
	}

	public int insertPointInHistory(String customerId, Connection conn, int sum) throws Exception {
		int result= 0;
		
		String sql = "INSERT INTO point_history(customer_id, point, point_kind) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, (int)Math.floor(sum/100*3));
		stmt.setString(3, "적립");
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
		
	}
	
	//포인트 사용시 실행쿼리
	public int usePointUpdateCustomer(Customer cust, Connection conn, int useAmount) throws Exception{
		int result= 0;
		
		String sql = "UPDATE customer SET point= ? WHERE customer_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cust.getPoint()-useAmount);
		stmt.setString(2, cust.getCustomerId());
		
		stmt.close();
		return result;
	}
	public int usePointInsertInHistory(String customerId, Connection conn, int useAmount) throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO point_history(customer_id, point, point_kind) VALUES (?, ?, ?)";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, useAmount);
		stmt.setString(3, "사용");
		stmt.close();
		
		
		return result;
	}
	//loginaction
	public Customer loginCustomer(String customerId, Connection conn, String customerPw) throws Exception{
		Customer c= new Customer();
		
		String sql = "SELECT * FROM customer WHERE customer_id= ? AND customer_pw=password(?)";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, customerPw);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			c.setCustomerId(rs.getString("customer_id"));
			c.setCustomerName(rs.getString("customer_name"));
			c.setCustomerPhone(rs.getString("customer_phone"));
			c.setPoint(rs.getInt("point"));
			c.setCustomerGender(rs.getString("customer_gender"));
			c.setCustomerBirth(rs.getString("customer_birth"));
			
		}
		
		rs.close();
		stmt.close();
		
		return c;
	}
	
	//address add
	public int addAddress(String customer_id, String address, Connection conn)throws Exception {
		int result = 0;
		String sql= "INSERT INTO customer_address (customer_id, address) VALUES (?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer_id);
		stmt.setString(2, address);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	//select address by list
	public ArrayList<Address> addressListById(String customerId,Connection conn) throws Exception{
		ArrayList<Address> list = new ArrayList<Address>();
		String sql = "SELECT * FROM customer_address WHERE customer_id= ? ORDER BY flag DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Address a = new Address();
			a.setAddress(rs.getString("address"));
			a.setAddressCode(rs.getInt("address_code"));
			a.setCustomerId(rs.getString("customer_id"));
			a.setFlag(rs.getInt("flag"));
			a.setCreatedate(rs.getString("createdate"));
			
			list.add(a);
			
		}
		
		stmt.close();
		rs.close();
		
		return list;
	}
	
	//update address
	public int updateAddress(String address, int flag, Connection conn) throws Exception {
		int result = 0;
		String sql = "UPDATE customer_address SET address= ? flag= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, address);
		stmt.setInt(2, flag);
		
		result= stmt.executeUpdate();
		stmt.close();
		
		
		return result;
	}
	
	//delete address
	public int deleteAddress(int addressCode, Connection conn) throws Exception {
		int result =0;
		
		String sql ="DELETE FROM customer_address WHERE address_code= ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setInt(1, addressCode);
		
		result= stmt.executeUpdate();
		stmt.close();
		
		return result;
	}

	
}
