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
	
	public int insertOrdersByCart(ArrayList<Cart> list, int addressCode, String customerId) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.insertOrdersByCart(list, conn, addressCode, customerId);
			
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
	
	public int insertCartlevel2(String customerId, int goodsCode, int quantity) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.insertCartlevel2(conn, customerId, goodsCode, quantity);
			
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
	
	public Cart selectCartlevel2(String customerId) {
		Cart c = null;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			c= orderdao.selectCartlevel2(conn, customerId);
			
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
	
	public int deletecartlevel2(String customerId) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.deleteCartlevel2(customerId, conn);
			
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
	
	public ArrayList<Cart> selectCartListlevel1(String customerId){
		ArrayList<Cart> list = new ArrayList<Cart>();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			list = orderdao.selectCartListlevel1(customerId, conn);
			
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
	
	public int updateSelectAll(String customerId) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.updateSelectAll(conn, customerId);
			
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
	
	public int updateSelectOne(String customerId, int selected, int goodsCode) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.updateSelectOne(conn, customerId, selected, goodsCode);
			
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
	
	public int updateCartQuantity(String customerId, int quantity, int goodsCode) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.updateCartQuantity(conn, customerId, quantity, goodsCode);
			
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
	
	public int DeleteCartOne(String customerId, int goodsCode) {
		int result = 0;
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			orderdao = new OrderDao();
			
			result = orderdao.deleteCartOne(conn, customerId, goodsCode);
			
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

