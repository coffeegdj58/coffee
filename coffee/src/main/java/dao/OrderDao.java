package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		
		String sql= "SELECT g.goods_name goodsName, g.goods_price goodsPrice, g.category_code categoryCode, c.cart_quantity cartQuantity FROM "
				+ "cart c INNER JOIN goods g ON c.goods_code = g.goods_code WHERE c.customer_id= ?";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Cart c = new Cart();
			c.setCartQuantity(rs.getInt("cartQuantity"));
			c.setGoodsName(rs.getString("goodsName"));
			c.setGoodsPrice(rs.getInt("goodsPrice"));
			c.setCategoryCode(rs.getInt("categoryCode"));
			
			list.add(c);
		}
		
		
		return list;
		
	}
	
	//orders insert 하는 쿼리
	public int insertOrdersByCart(ArrayList<Cart> list, int cartQuantity, Connection conn )throws Exception{
		int result= 0;
		
		for(Cart c : list) {
			String sql = "INSERT INTO orders(goods_code, customer_id, order_quantity, order_price)values(?, ?, ?, ?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getGoodsCode());
			stmt.setString(2, c.getCustomerId());
			
		}
		
		
		return result;
	}
}
