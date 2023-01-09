package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ReviewDao;
import util.Dbutil;
import vo.Review;

public class ReviewService {
	private ReviewDao reviewDao;
	
	//review update 쿼리
	public int updateReview(Review re) {
		int result=0;
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.reviewDao= new ReviewDao();
		
		try {
			conn=dbUtil.getConnection();
			result=reviewDao.updateReview(re, conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//review delete 쿼리
	public int deleteReview(int orderCode) {
		int result=0;
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.reviewDao= new ReviewDao();
		
		try {
			conn=dbUtil.getConnection();
			result=reviewDao.deleteReview(orderCode, conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	//review insert 쿼리
	public int insertReviewByCustomer(Review review) {
		int result=0;
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.reviewDao= new ReviewDao();
		
		try {
			conn=dbUtil.getConnection();
			result=reviewDao.insertReviewByCustomer(review, conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//reviewSelect by goods 페이지에서 paging 예
	public ArrayList<Review> selectReviewByGoodsPaging(int goodsCode, int beginRow, int rowPerPage){
		ArrayList<Review> list=null;
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.reviewDao= new ReviewDao();
		
		try {
			conn=dbUtil.getConnection();
			list=reviewDao.selectReviewByGoodsPaging(goodsCode, beginRow, rowPerPage, conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//reviewSelect by customerPage에서
	public ArrayList<Review> selectReviewById(String customerId) {
		ArrayList<Review> list=null;
		Connection conn=null;
		Dbutil dbUtil= new Dbutil();
		this.reviewDao= new ReviewDao();
		
		try {
			conn=dbUtil.getConnection();
			list=reviewDao.selectReviewById(customerId, conn);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
