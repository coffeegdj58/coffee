package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Goods;

public class GoodsDao {
		
	// 상품 리스트
	public ArrayList<Goods> selectGoodsList(Connection conn, int categoryCode) throws Exception {
		ArrayList<Goods> list = new ArrayList<>();
		
		String sql = "SELECT g.goods_name goodsName, g.goods_price goodsPrice, g.soldout soldout, g.goods_code goodsCode, c.category_kind categoryKind, c.category_name categoryName FROM goods g INNER JOIN category c ON g.category_code = c.category_code WHERE c.category_code= ? ORDER BY g.hit DESC";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, categoryCode);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Goods g = new Goods();
			g.setCategoryKind(rs.getString("categoryKind"));
			g.setCategoryName(rs.getString("categoryName"));
			g.setGoodsName(rs.getString("goodsName"));
			g.setGoodsPrice(rs.getInt("goodsPrice"));
			g.setGoodsCode(rs.getInt("goodsCode"));
			g.setSoldout(rs.getString("soldout"));
			
			list.add(g);
			
			
		}
		
		if(rs != null) {rs.close();}
		if(stmt != null) {stmt.close();}
		
		return list;
	}
	
	// 상품 상세 정보
	public Goods selectGoodsOne(Connection conn, int goodsCode) throws Exception {
		Goods g= null;
		
		String sql = "SELECT * FROM goods g INNER JOIN category c ON g.category_code= c.category_code WHERE g.goods_code= ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			g=  new Goods();
			g.setCategoryKind(rs.getString("c.category_kind"));
			g.setCategoryName(rs.getString("c.category_name"));
			g.setGoodsCode(rs.getInt("g.goods_code"));
			g.setGoodsContent(rs.getString("g.goods_content"));
			g.setGoodsInfo(rs.getString("g.goods_info"));
			g.setGoodsName(rs.getString("g.goods_name"));
			g.setGoodsPrice(rs.getInt("g.goods_price"));
			g.setSoldout(rs.getString("g.soldout"));
			
		}
		
		if(rs != null) {rs.close();}
		if(stmt != null) {stmt.close();}
		
		return g;
	}
	
	// 상품 수정
	public int updateGoods(Connection conn, Goods goods) throws Exception {
		
		String sql = "UPDATE goods SET goods_name= ?, goods_price= ?, soldout= ?, category_code= ?, goods_content= ?, goods_info= ? WHERE goods_code= ? ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goods.getGoodsName());
		stmt.setInt(2, goods.getGoodsPrice());
		stmt.setString(3, goods.getSoldout());
		stmt.setInt(4, goods.getCategoryCode());
		stmt.setString(5, goods.getGoodsContent());
		stmt.setString(6, goods.getGoodsInfo());
		stmt.setInt(7, goods.getGoodsCode());
		int result = stmt.executeUpdate();
		
		if(stmt != null) {stmt.close();}
		
		return result;
	}
	
	// 상품 삭제
	public int deleteGoods(Connection conn, int goodsCode) throws Exception {
		
		String sql = "DELETE FROM goods WHERE goods_code = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		int result = stmt.executeUpdate();
		
		if(stmt != null) {stmt.close();}
		
		return result;
	}
	
	// 상품 추가
	public int insertGoods(Connection conn, Goods goods, String empId) throws Exception{
		
		int result = 0;
		
		String sql = "INSERT INTO goods (goods_name, goods_price, soldout, emp_id, category_code, goods_content, goods_info) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goods.getGoodsName());
		stmt.setInt(2, goods.getGoodsPrice());
		stmt.setString(3, goods.getSoldout());
		stmt.setString(4, empId);
		stmt.setInt(5, goods.getCategoryCode());
		stmt.setString(6, goods.getGoodsContent());
		stmt.setString(7, goods.getGoodsInfo());
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
	

}

