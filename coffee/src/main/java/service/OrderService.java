package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.OrderDao;
import util.Dbutil;
import vo.Cart;

public class OrderService {
	private OrderDao orderdao;
	private Dbutil db;
	public int insertCart(Cart cart) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.insertCart(cart, conn);
			
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
	public ArrayList<Cart> selectCartListbyId(String customerId) {
		ArrayList<Cart> list = new ArrayList<Cart>();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			list = orderdao.selectCartListById(customerId, conn);
			
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
	
	public int insertOrdersByCart(ArrayList<Cart> list) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.insertOrdersByCart(list, conn);
			
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
	
	public int deleteCartById(String customerId) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.deleteCartById(customerId, conn);
			
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
	
	public int selectSumGoodsPrice(String customerId) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.selectSumGoodsPrice(customerId, conn);
			
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
	
	public int updateOrderState (String orderState, int orderCode) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.updateOrderState(conn, orderState, orderCode);
			
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
	
	public int updategoodsHit(ArrayList<Cart> list) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.updateGoodsHit(list, conn);
			
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
	
	public ArrayList<HashMap<String, Object>> selectOrderListByid(String customerId){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			list = orderdao.selectOrderListById(customerId, conn);
			
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
}

