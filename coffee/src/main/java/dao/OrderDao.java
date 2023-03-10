package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Cart;
import vo.Order;


public class OrderDao {
	
	//cart에 goods 추가하는 쿼리
	public int insertCart(Cart cart, Connection conn) throws Exception {
		int result = 0;
		String sql = "INSERT INTO cart(goods_code, customer_id, cart_quantity) values (?, ?, ?)";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		stmt.setInt(3, cart.getCartQuantity());
		
		result= stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	
	//cartlist를 담는 쿼리
	public ArrayList<Cart> selectCartListById(String customerId, Connection conn) throws Exception {
		ArrayList<Cart> list = new ArrayList<Cart>();
		
		String sql= "SELECT "
				+ "c.goods_code goodsCode, c.cart_quantity cartQuantity, g.soldout soldout,c.selected selected, g.goods_name goodsName, (g.goods_price * c.cart_quantity) cartPrice, g.goods_price goodsPrice, c2.category_kind categoryKind, c2.category_name categoryName "
				+ "FROM cart c INNER JOIN goods g ON c.goods_code = g.goods_code inner join category c2 ON c2.category_code = g.category_code "
				+ "WHERE c.customer_id= ?";
		
		//cart table과 goods table, category table의 inner join를 위해 cart를 만들고  소비자에게 cart를 보여주고 order로써 넣기위한 colum를 집어넣는 쿼리
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Cart c = new Cart();
			c.setCartQuantity(rs.getInt("cartQuantity"));
			c.setGoodsName(rs.getString("goodsName"));
			c.setGoodsPrice(rs.getInt("goodsPrice"));
			c.setCategoryKind(rs.getString("categoryKind"));
			c.setCategoryName(rs.getString("categoryName"));
			c.setGoodsCode(rs.getInt("goodsCode"));
			c.setSelected(rs.getInt("selected"));
			c.setCartPrice(rs.getInt("cartPrice"));
			c.setSoldout(rs.getString("soldout"));
			list.add(c);
		}
		rs.close();
		stmt.close();
		
		return list;
		
	}
	
	//orders insert 하는 쿼리
	public int insertOrdersByCart(ArrayList<Cart> list, Connection conn, int addressCode, String customerId)throws Exception{
		int result= 0;
	
		
		for(Cart c : list) {
			
			String sql = "INSERT INTO orders(goods_code, customer_id, order_quantity, order_price, address_code)values(?, ?, ?, ?, ?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, c.getGoodsCode());
			stmt.setString(2, customerId);
			stmt.setInt(3, c.getCartQuantity());
			stmt.setInt(4, c.getCartPrice());
			stmt.setInt(5, addressCode);
			
			result= stmt.executeUpdate();
			stmt.close();
			
		}
		
		
		return result;
	}
	
	//결제 후 유저의 카트 데이터를 지우는 쿼리 (cart-order로 넘어가는 것이 결제 결제된 카트는 삭제)
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
		
		String sql = "SELECT sum(g.goods_price*c.cart_quantity) sum FROM cart c INNER JOIN goods g ON c.goods_code = g.goods_code WHERE c.customer_id = ? AND c.selected = 1";
		//goods_price * cart_quantity 가격 * 수량의 총합를 구하는 쿼리
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			sum = rs.getInt("sum");
		}
		rs.close();
		stmt.close();
		
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
		stmt.close();
		
		return result;
	}
	
	//cart - orders에 넘어갈때(구매 시) hit(판매량)을 높이는 쿼리
	public int updateGoodsHit(ArrayList<Cart> list, Connection conn ) throws Exception {
		int hit= 0;
		int result= 0;
		//
		for(Cart c : list) {
			String sql1= "SELECT hit FROM goods WHERE goods_code= ?";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, c.getGoodsCode());
			ResultSet rs = stmt1.executeQuery();

			if(rs.next()) {
				hit= rs.getInt("hit");
			}
			
			stmt1.close();
			rs.close();
			System.out.println(hit+"hit");
			
			
			
			String sql="UPDATE goods SET hit= ? WHERE goods_code= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, hit+(1*c.getCartQuantity()));
			stmt.setInt(2, c.getGoodsCode());
			result= stmt.executeUpdate();
			
			stmt.close();
			
		}
		
		
		return result;
	}
	public ArrayList<HashMap<String, Object>> selectOrderListById(String customerId, Connection conn) throws Exception{
		ArrayList<HashMap<String, Object>> list =new ArrayList<HashMap<String, Object>>();
		
		String sql = "SELECT o.createdate createdate, o.order_price, o.order_quantity, c.category_name categoryName, o.goods_code goodsCode, c.category_kind categoryKind, o.order_code orderCode, o.order_state orderState, g.goods_name goodsName, g.goods_price goodsPrice "
				+ "FROM orders o INNER JOIN goods g ON g.goods_code= o.goods_code INNER JOIN category c ON g.category_code= c.category_code"
				+ " WHERE o.customer_id = ? AND o.vision = '0' ORDER BY o.createdate DESC";
		
		//회원이 볼 수 있는 화면에서의 오더(주문)의 식별을 위한 order, goods, category 세 테이블의 innerjoin를 통한 select
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
			o.put("goodsCode", rs.getInt("goodsCode"));
			o.put("createdate", rs.getString("createdate"));
			o.put("orderPrice", rs.getInt("o.order_price"));
			o.put("orderQuantity", rs.getInt("o.order_quantity"));
			list.add(o);
		}
		
		stmt.close();
		rs.close();
		
		return list;
	}
	
	//바로구매를 위한쿼리 selected level를 2로 올려서 구분한다
	public int insertCartlevel2(Connection conn, String customerId, int goodsCode, int quantity)throws Exception{
	
		int result=0;
		
		String sql= "INSERT INTO cart(customer_id, goods_code, cart_quantity, selected)values(?, ?, ?, 2)";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, goodsCode);
		stmt.setInt(3, quantity);
		
		result =stmt.executeUpdate();
		
		stmt.close();
		
		
		
		return result;
	}
	//select level2
	
	public Cart selectCartlevel2(Connection conn, String customerId) throws Exception{
		Cart c = new Cart();
		
		String sql= "SELECT (c.cart_quantity* g.goods_price) cartPrice, g.goods_name goodsName, g.goods_code goodsCode, c.cart_quantity cartQuantity FROM cart c INNER JOIN goods g ON c.goods_code = g.goods_code WHERE c.customer_id= ? AND selected= 2";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			c.setCartPrice(rs.getInt("cartPrice"));
			c.setGoodsName(rs.getString("goodsName"));
			c.setGoodsCode(rs.getInt("goodsCode"));
			c.setCartQuantity(rs.getInt("cartQuantity"));
		}
		stmt.close();
		rs.close();
		return c;
	}
	
	//delete level2
	public int deleteCartlevel2(String customerId, Connection conn) throws Exception {
		int result =0;
		
		String sql = "DELETE FROM cart WHERE customer_id= ? AND selected= 2";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		result = stmt.executeUpdate();
		
		stmt.close();
		return result;
	}
	
	//실구매할 cartlist level1
	
	public ArrayList<Cart> selectCartListlevel1(String customerId, Connection conn) throws Exception {
		ArrayList<Cart> list = new ArrayList<Cart>();
		
		String sql= "SELECT "
				+ "c.goods_code goodsCode, c.cart_quantity cartQuantity, c.selected selected, g.goods_name goodsName, (g.goods_price * c.cart_quantity) cartPrice, g.goods_price goodsPrice, c2.category_kind categoryKind, c2.category_name categoryName "
				+ "FROM cart c INNER JOIN goods g ON c.goods_code = g.goods_code inner join category c2 ON c2.category_code = g.category_code "
				+ "WHERE c.customer_id= ? AND c.selected= 1 AND g.soldout='N'";
		
		///실 구매할 cartlist를 구현 selected 1 = level 1 장바구니에 있고 선택 됨 soldout==n 품절되지 않은 상품
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Cart c = new Cart();
			c.setCartQuantity(rs.getInt("cartQuantity"));
			c.setGoodsName(rs.getString("goodsName"));
			c.setGoodsPrice(rs.getInt("goodsPrice"));
			c.setCategoryKind(rs.getString("categoryKind"));
			c.setCategoryName(rs.getString("categoryName"));
			c.setGoodsCode(rs.getInt("goodsCode"));
			c.setSelected(rs.getInt("selected"));
			c.setCartPrice(rs.getInt("cartPrice"));
			list.add(c);
		}
		
		rs.close();
		stmt.close();
		return list;
		
	}
	
	//장바구니 전체 선택시 실행 쿼리
	
	public int updateSelectAll(Connection conn, String customerId) throws Exception{
		int result = 0;
		String sql ="UPDATE cart SET selected= 1 WHERE customer_id= ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		
		stmt.setString(1, customerId);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
	
	//장바구니에서 하나 선택시 실행쿼리
	
	public int updateSelectOne(Connection conn, String customerId, int selected, int goodsCode) throws Exception {
		int result= 0;
		
		String sql ="UPDATE cart SET selected= ? WHERE customer_id= ? AND goods_code = ?";
		
		//장바구니에서의 선택 selected을 update
		
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setInt(1, selected);
		stmt.setString(2, customerId);
		stmt.setInt(3, goodsCode);
		
		result = stmt.executeUpdate();
		stmt.close();
		
		
		return result;
	}
	
	//장바구니에서 수량 변경시 실행쿼리
	public int updateCartQuantity(Connection conn, String customerId, int quantity, int goodsCode) throws Exception{
		
		int result = 0;
		
		//장바구니에서의 수량 변경 cart에서의 cartquantity update
		String sql = "UPDATE cart SET cart_quantity = ? WHERE customer_id=? AND goods_code= ? ";
		PreparedStatement stmt =conn.prepareStatement(sql);
		
		stmt.setInt(1, quantity);
		stmt.setString(2, customerId);
		stmt.setInt(3, goodsCode);
		
		result = stmt.executeUpdate();
		stmt.close();
		
		return result;	
	}
	
	//하나의 카트를 지정해서 삭제하는 쿼리
	public int deleteCartOne(Connection conn, String customerId, int goodsCode) throws Exception{
		int result=0;
		String sql = "DELETE FROM cart WHERE customer_id= ? AND goods_code= ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, goodsCode);
		
		result =stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
	//바로구매 카트 담긴걸 order로 넘기기
	public int insertPayment2Order(Connection conn, Cart cart, int addressCode) throws Exception {
		int row=0;
		String sql= "INSERT INTO orders(goods_code,customer_id, order_quantity, order_price , address_code) VALUES(?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		stmt.setInt(3, cart.getCartQuantity());
		stmt.setInt(4, cart.getCartPrice());
		stmt.setInt(5, addressCode);
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("구입 성공 : Dao");
		}
		return row;
	}
	
	//하나의 오더를 select by ordercode
	public Order selectOrderOne(Connection conn, int orderCode) throws Exception{
		Order o = new Order();
		
		String sql ="SELECT * FROM orders WHERE order_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			o.setOrderPrice(rs.getInt("order_price"));
			o.setOrderQuantity(rs.getInt("order_quantity"));
			o.setGoodsCode(rs.getInt("goods_code"));
			o.setOrderState(rs.getString("order_state"));
			o.setCreatedate(rs.getString("createdate"));
			o.setAddressCode(rs.getInt("address_code"));
		}
		stmt.close();
		rs.close();
		
		
		return o;
	}
	
	//하나의 오더를 삭제하는 것처럼보이지만 안보이게함(order의 삭제는 없다 다만 고객에게 안 보일뿐) db의보존
	public int deleteOrderOne(Connection conn, int orderCode) throws Exception{
		int result= 0;
		String sql= "UPDATE orders SET vision= 1 WHERE order_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
		
	}
	//장바구니현재갯수
	public int selectCartCount(Connection conn, String customerId) throws Exception{
		int count = 0;
		
		String sql="SELECT COUNT(*) FROM cart WHERE customer_id= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt("COUNT(*)");
		}
		
		stmt.close();
		rs.close();
		return count;
	}
	
}	
