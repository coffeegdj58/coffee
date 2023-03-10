package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Goods;

public class GoodsDao {
		
	// 상품 리스트 by 카테고리
	public ArrayList<Goods> selectGoodsList(Connection conn, int categoryCode) throws Exception {
		ArrayList<Goods> list = new ArrayList<>();
		
		String sql = "SELECT g.goods_name goodsName, g.goods_price goodsPrice, g.soldout soldout, g.goods_code goodsCode, c.category_kind categoryKind, c.category_name categoryName "
				+ "FROM goods g INNER JOIN category c ON g.category_code = c.category_code"
				+ " WHERE c.category_code= ? ORDER BY g.hit DESC";
		//inner join을 이용한 굿즈를 카테고리 코드로 식별하는 리스트를 select하는 쿼리
		
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
	
	// 상품 상세 정보 by primary code
	public Goods selectGoodsOne(Connection conn, int goodsCode) throws Exception {
		Goods g= null;
		
		String sql = "SELECT * FROM goods g INNER JOIN category c ON g.category_code= c.category_code WHERE g.goods_code= ?";
		//category와의 inner join을 통한 goods One select
		
		
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
		//primary key인 goods_code를 통한 goods_one update
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
		//primary key인 goods_code를 통한 goods_one delete
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
	
	//hit 순으로
	public ArrayList<Goods> goodsListbyHits(Connection conn) throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		
		String sql= "SELECT * FROM goods ORDER BY hit DESC LIMIT 0,4";
		//사이트내의 기능인 bestseller를 구현하기위한 hit(판매량)이 높은 순으로 4개의 goods를 select하는 쿼리
		
		PreparedStatement stmt =conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Goods g = new Goods();
			g.setGoodsCode(rs.getInt("goods_code"));
			g.setGoodsName(rs.getString("goods_name"));
			g.setGoodsPrice(rs.getInt("goods_price"));		
			list.add(g);
		}
		rs.close();
		stmt.close();
		
		return list;
	}
	//검색기능
	public ArrayList<Goods> selectGoodsBySearch(String word, Connection conn) throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT goods_code, goods_name, goods_price FROM goods WHERE goods_name LIKE ? ORDER BY hit DESC";
		//사이트내 검색기능을 구현 하기 위한 쿼리
		
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, "%"+word+"%");
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Goods g = new Goods();
			g.setGoodsName(rs.getString("goods_name"));
			g.setGoodsPrice(rs.getInt("goods_price"));
			g.setGoodsCode(rs.getInt("goods_code"));
			list.add(g);
			
		}
		
		stmt.close();
		rs.close();
		
		return list;
	}

}

