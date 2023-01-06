package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Cart;


public class OrderDao {
	
	//cart에 goods 추가하는 쿼리
	public int insertCart(Cart cart, Connection conn) throws Exception {
		int result = 0;
		String sql = "INSERT INTO cart(goods_code, customer_id, cart_quantity) values (?, ?, ?)";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		stmt.setInt(3, cart.getCartQuantity()+1);
		
		result= stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	
	//cartlist를 담는 쿼리
	public ArrayList<Cart> selectCartListById(String customerId, Connection conn) throws Exception {
		ArrayList<Cart> list = new ArrayList<Cart>();
		
		String sql= "SELECT g.goods_name goodsName, g.goods_price goodsPrice, g.category_code categoryCode, c.cart_quantity cartQuantity, g.goods_code, goodsCode FROM "
				+ "cart c INNER JOIN goods g ON c.goods_code = g.goods_code WHERE c.customer_id= ? AND c.selected= 1";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Cart c = new Cart();
			c.setCartQuantity(rs.getInt("cartQuantity"));
			c.setGoodsName(rs.getString("goodsName"));
			c.setGoodsPrice(rs.getInt("goodsPrice"));
			c.setCategoryCode(rs.getInt("categoryCode"));
			c.setGoodsCode(rs.getInt("goodsCode"));
			list.add(c);
		}
		
		
		return list;
		
	}
	
	//orders insert 하는 쿼리
	public int insertOrdersByCart(ArrayList<Cart> list, Connection conn )throws Exception{
		int result= 0;
		int quantity = 0;
		
		for(Cart c : list) {
			quantity++;
			String sql = "INSERT INTO orders(goods_code, customer_id, order_quantity, order_price)values(?, ?, ?, ?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getGoodsCode());
			stmt.setString(2, c.getCustomerId());
			stmt.setInt(3, quantity);
			stmt.setInt(4, c.getGoodsPrice());
			
			result= stmt.executeUpdate();
			stmt.close();
			
		}
		
		
		return result;
	}
	
	//결제 후 유저의 카트 데이터를 지우는 쿼리
	public int deleteCartById(String customerId, Connection conn) throws Exception {
		int result =0;
		
		String sql = "DELETE FROM cart WHERE customer_id= ? AND selected= 1";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		result = stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
	//장바구니 총 가격을 알려주는 쿼리
	public int selectSumGoodsPrice(String customerId, Connection conn )throws Exception{
		int sum = 0;
		
		String sql = "SELECT SUM(goods_price) s FROM cart WHERE customer_id= ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			sum = rs.getInt("s");
		}
		
		
		return sum;
	}
	
	//orders의 state를 바꾸는 쿼리
	public int updateOrderState (Connection conn, String orderState, int orderCode) throws Exception{
		int result = 0;
		
		String sql = "UPDATE orders SET order_state = ? WHERE order_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, orderState);
		stmt.setInt(2, orderCode);
		
		result = stmt.executeUpdate();
		
		return result;
	}
	
	//cart - orders에 넘어갈때 hit을 높이는 쿼리
	public int updateGoodsHit(ArrayList<Cart> list, Connection conn ) throws Exception {
		int hit= 0;
		int result= 0;
		
		for(Cart c : list) {
			hit++;
			String sql="UPDATE goods SET hit= ? WHERE goods_code= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, hit);
			stmt.setInt(2, c.getGoodsCode());
			result= stmt.executeUpdate();
			
			stmt.close();
			
		}
		
		
		return result;
	}
	public ArrayList<HashMap<String, Object>> selectOrderListById(String customerId, Connection conn) throws Exception{
		ArrayList<HashMap<String, Object>> list =new ArrayList<HashMap<String, Object>>();
		
		String sql = "SELECT c.category_name categoryName, c.category_kind categoryKind, o.order_code orderCode, o.order_state orderState, g.goods_name goodsName, g.goods_price goodsPrice "
				+ "FROM orders o INNER JOIN goods g ON g.goods_code= o.goods_code INNER JOIN category c ON g.category_code= c.category_code"
				+ " WHERE o.customer_id = ? ORDER BY o.createdate";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			HashMap<String, Object> o = new HashMap<String, Object>();
			o.put("categoryName", rs.getString("categoryName"));
			o.put("categoryKind", rs.getString("categoryKind"));
			o.put("orderCode", rs.getInt("orderCode"));
			o.put("orderState", rs.getString("orderState"));
			o.put("goodsName", rs.getString("goodsName"));
			o.put("goodsPrice", rs.getInt("goodsPrice"));
			
			list.add(o);
		}
		
		stmt.close();
		rs.close();
		
		return list;
	}

}
