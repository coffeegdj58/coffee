package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDao;
import util.Dbutil;
import vo.Address;
import vo.Customer;
import vo.Point;

public class CustomerService {
	private CustomerDao customerDao;
	private Dbutil db;
	
	public int insertCutomer(Customer cust) {
		Connection conn=null;
		int result = 0;
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			customerDao = new CustomerDao();
			result = customerDao.insertCustomer(cust, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	public int checkCustomerId(String customerId) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.checkCustomerId(customerId, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public int updateCustomer(String customerId, String afterPassword, String beforePassword) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.updateCustomer(customerId, afterPassword, beforePassword, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int insertPwHistory(String customerId, String customerPw) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.insertPwHistory(customerId, customerPw, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int pwCheck(String customerId, String customerPw ) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.pwCheck(customerId, customerPw, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteCustomer(String customerId, String customerPw) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.deleteCustomer(customerId, customerPw, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int signUpCustomerByOutid(String customerId) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.signUpCustomerByOutid(conn, customerId);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	
	public int insertPointInCustomer(Customer cust, int sum) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.insertPointInCustomer(cust, conn, sum);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	
	public int insertPointInHistory (String customerId, int sum) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.insertPointInHistory(customerId, conn, sum);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int usePointUpdateCustomer(Customer cust, int useAmount) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.usePointUpdateCustomer(cust, conn, useAmount);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int usePointInsertInHistory(String customerId, int useAmount) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.usePointInsertInHistory(customerId, conn, useAmount);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	
	public Customer loginCustomer (String customerId, String customerPw) {
		Customer c =new Customer();
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			c = customerDao.loginCustomer(customerId, conn, customerPw);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
		
	}
	
	public int adddAddress(String customerId, String address, int flag) {
		
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.addAddress(customerId, address, flag, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public ArrayList<Address> addressListById(String customerId){
		ArrayList<Address> list = null;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			list = customerDao.addressListById(customerId, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	public int updateAddress(String address, int flag, int addressCode) {
		
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.updateAddress(addressCode, address, flag, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//기본배송지 아이디 초기화쿼리
	public int resetAddressFlag(String customerId) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.resetFlagById(customerId, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public int deleteAddress(int addressCode) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.deleteAddress(addressCode, conn);
			
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Point> pointListById(String customerId){
		ArrayList<Point> list = new ArrayList<Point>();
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			list = customerDao.pointListById(conn, customerId);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
		
	}
	public Address addressOne(int addressCode) {
		Address address= new Address();
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			address = customerDao.addressOneByAddresscode(conn, addressCode);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return address;
	}
	
	public int updateVisionAddress(int addressCode) {
		int result =0;
		Connection conn =null;
		try {
			db = new Dbutil();
			conn =db.getConnection();
			customerDao =new CustomerDao();
			
			result = customerDao.updateAddressOne(conn, addressCode);
			
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
