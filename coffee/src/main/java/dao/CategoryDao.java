package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Category;

public class CategoryDao {
	public ArrayList<Category> selectCategoryList(Connection conn) throws Exception{ 
		ArrayList<Category> list = new ArrayList<Category>();
		
		String sql ="SELECT * FROM category";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Category c = new Category();
			c.setCategoryCode(rs.getInt("category_code"));
			c.setCategoryKind(rs.getString("category_kind"));
			c.setCategoryName(rs.getString("category_name"));
			list.add(c);
		}
		
		stmt.close();
		rs.close();
		
		return list;
	}
}
