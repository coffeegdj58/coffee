package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Goods;

public class GoodsDao {
	
	public ArrayList<Goods> selectListFromGoods(Connection conn, int categoryCode) throws Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		
		String sql = "SELECT * FROM goods WHERE category_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, categoryCode);
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			Goods c = new Goods();
			c.setCategoryCode(rs.getInt("categoryCode"));
			
			list.add(c);
		}
		rs.close();
		stmt.close();				
		
		return list;
		
	}
	
	// insertGoods
	
}

