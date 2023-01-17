package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Address;
import vo.Customer;
import vo.Point;

public class CustomerDao {
	
	//customer insert 쿼리(회원가입)
	public int insertCustomer(Customer cust, Connection conn) throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO customer(customer_id, customer_pw, customer_name, customer_phone, customer_gender, customer_birth)VALUES(?,password(?),?,?,?,?)";
		
		
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

		//outid 에서찾는쿼리(customer, emp 모두 가입 시 outId로 똑같은 id가 들어가고 그 아이디는 중복 방지 용으로 select된다 탈퇴이후도 동일)
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
	public int updateCustomer(String customerId, String afterPassword, String beforePassword, Connection conn) throws Exception{
		int result= 0;
		String sql = "UPDATE customer SET customer_pw = password(?) WHERE customer_id= ? AND customer_pw = password(?) ";
		//and문으로 비밀번호까지 확인하는 쿼리
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, afterPassword);
	
		stmt.setString(2, customerId);
		stmt.setString(3, beforePassword);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	//pw update시에 pwhistory에 넣는 쿼리
	public int insertPwHistory(String customerId, String customerPw, Connection conn) throws Exception{
		int result = 0;
		
		String sql = "INSERT INTO pw_history(customer_id, pw) VALUES (?, password(?))";
		//동일한 비밀번호로 변경하는 것을 막기위한 table pw history에 insert하는 쿼리
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
	
	//insertoutid timing == insertcustomer 회원가입할때, 아웃아이디에 집어 넣는다
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
	
	//poinPage에서 볼 pointlist
	public ArrayList<Point> pointListById(Connection conn, String customerId) throws Exception{
		ArrayList<Point> list = new ArrayList<Point>();
		String sql = "SELECT * FROM point_history WHERE customer_id= ? ORDER BY createdate DESC";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Point p = new Point();
			p.setCreatedate(rs.getString("createdate"));
			p.setPoint(rs.getInt("point"));
			p.setPointKind(rs.getString("point_kind"));
			
			list.add(p);
			
		}
		rs.close();
		stmt.close();
		
		
		return list;
	}
	
	//포인트 적립시 실행 쿼리
	public int insertPointInCustomer(Customer cust, Connection conn, int sum) throws Exception{ 
		int result =0;
		
		String sql= "UPDATE customer SET point= ? WHERE customer_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, cust.getPoint()+(int)Math.floor(sum/100*3));
						//로그인된 회원의 포인트 더하기 구매가격의 3%를 추가
		stmt.setString(2, cust.getCustomerId());
		result = stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	//point history의 적립으로 insert하는 쿼리
	public int insertPointInHistory(String customerId, Connection conn, int sum) throws Exception {
		int result= 0;
		
		String sql = "INSERT INTO point_history(customer_id, point, point_kind) VALUES (?, ?, '적립')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, (int)Math.floor(sum/100*3));
		
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
		
	}
	
	//포인트 사용시 실행쿼리
	public int usePointUpdateCustomer(Customer cust, Connection conn, int useAmount) throws Exception{
		int result= 0;
		
		String sql = "UPDATE customer SET point= ? WHERE customer_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cust.getPoint()-useAmount);
		System.out.println("dado:" +(cust.getPoint()-useAmount));
		stmt.setString(2, cust.getCustomerId());
		result=stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
	//point history의 사용으로 insert하는 쿼리
	public int usePointInsertInHistory(String customerId, Connection conn, int useAmount) throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO point_history(customer_id, point, point_kind) VALUES (?, ?, '사용')";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, useAmount);
		
		result= stmt.executeUpdate();
		
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
	
	//address add 회원 주소 추가
	public int addAddress(String customerId, String address, int flag, Connection conn)throws Exception {
		int result = 0;
		String sql= "INSERT INTO customer_address (customer_id, address, flag) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setString(2, address);
		stmt.setInt(3, flag);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		return result;
	}
	
	//select address by list 회원 주소를 unique키인 customerid로 select하는 쿼리
	public ArrayList<Address> addressListById(String customerId,Connection conn) throws Exception{
		ArrayList<Address> list = new ArrayList<Address>();
		String sql = "SELECT * FROM customer_address WHERE customer_id= ? AND vision= 0 ORDER BY flag DESC";
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
	public int updateAddress(int addressCode, String address, int flag, Connection conn) throws Exception {
		int result = 0;
		String sql = "UPDATE customer_address SET address= ?, flag= ? WHERE address_code= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, address);
		stmt.setInt(2, flag);
		stmt.setInt(3, addressCode);
		
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
	
	//reset기본배송지 기본배송지로 설정 체크시 실행시켜 초기화하는 쿼리
	public int resetFlagById(String customerId, Connection conn )throws Exception{
		int result= 0;
		
		String sql = "UPDATE customer_address SET flag=0 WHERE customer_id=?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		result=stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
	
	//addressone
	
	public Address addressOneByAddresscode(Connection conn, int addressCode) throws Exception{
		
		Address address =new Address();
		
		String sql = "SELECT * FROM customer_address WHERE address_code= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, addressCode);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			address.setAddressCode(rs.getInt("address_code"));
			address.setAddress(rs.getString("address"));
			address.setFlag(rs.getInt("flag"));
		}
		
		stmt.close();
		rs.close();
		return address;
	}
	//order로 묶힌 address는 살리는 대신 안보이게 처리한다
	public int updateAddressOne(Connection conn, int addressCode) throws Exception{
		int result=0;
		
		String sql = "UPDATE customer_address SET vision= 1 WHERE address_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, addressCode);
		
		
		result = stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
}
