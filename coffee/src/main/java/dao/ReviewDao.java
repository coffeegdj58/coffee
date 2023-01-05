package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Review;

public class ReviewDao {

	//review insert 쿼리
	public int insertReviewByCustomer(Review review, Connection conn) throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO review (order_code, review_memo, goods_code, customer_id, rating) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt= conn.prepareStatement(sql);
		stmt.setInt(1, review.getOrderCode());
		stmt.setString(2, review.getReviewMemo());
		stmt.setInt(3, review.getGoodsCode());
		stmt.setString(4, review.getCustomerId());
		stmt.setInt(5, review.getRating());
		
		result=stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	//reviewSelect by goods 페이지에서 paging 예
	public ArrayList<Review> selectReviewByGoodsPaging(int goodsCode, int beginRow, int rowPerPage, Connection conn) throws Exception {
		ArrayList<Review> list = new ArrayList<Review>();
		
		String sql = "SELECT * FROM WHERE goods_code= ? ORDER BY createdate DESC LIMIT ?, ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Review r = new Review();
			r.setCustomerId(rs.getString("customer_id"));
			r.setRating(rs.getInt("rating"));
			r.setReviewMemo(rs.getString("review_memo"));
			
			list.add(r);
		}
		rs.close();
		stmt.close();
		
		return list;
	}
	
	//reviewSelect by customerPage에서
	public ArrayList<Review> selectReviewById(String customerId, Connection conn) throws Exception {
		ArrayList<Review> list = new ArrayList<Review>();
		
		String sql = "SELECT * FROM WHERE customer_id= ? ORDER BY createdate DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			Review r = new Review();
			r.setCustomerId(rs.getString("customer_id"));
			r.setRating(rs.getInt("rating"));
			r.setReviewMemo(rs.getString("review_memo"));
			r.setOrderCode(rs.getInt("order_code"));
			list.add(r);
		}
		rs.close();
		stmt.close();
		
		return list;
	}
	
	//review update 쿼리
	public int updateReview(Review re, Connection conn) throws Exception {
		int result = 0;
		
		String sql = "UPDATE review SET review_memo=?, rating= ? WHERE order_code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, re.getReviewMemo());
		stmt.setInt(2, re.getRating());
		stmt.setInt(3, re.getOrderCode());
		
		result= stmt.executeUpdate();
		stmt.close();
		
		return result;
	}
	//review delete 쿼리
	public int deleteReview(int orderCode, Connection conn ) throws Exception{
		int result= 0;
		
		String sql = "DELETE FROM review WHERE order_code= ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		
		result= stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
	}
}
