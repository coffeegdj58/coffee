package service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CategoryDao;
import dao.GoodsDao;
import util.Dbutil;
import vo.Category;
import vo.Goods;

public class GoodsService {
	private GoodsDao goodsDao;
	private CategoryDao categoryDao;
	private Dbutil db;
	
	// 상품 리스트
	public ArrayList<Goods> getGoodsList(int categoryCode) {
		ArrayList<Goods> list = null;
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			
			goodsDao = new GoodsDao();
			list = goodsDao.selectGoodsList(conn, categoryCode);			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
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
	
	// 상품 상세 정보
	public Goods getGoodsOne(int goodsCode) {
		Goods g = null;
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			
			goodsDao = new GoodsDao();
			g = goodsDao.selectGoodsOne(conn, goodsCode);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
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
		return g;
	}
	
	// 상품 수정
	public int modifyGoods(Goods goods, String dir) {
		int result = 0;
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			
			goodsDao = new GoodsDao();
			result = goodsDao.updateGoods(conn, goods);
	
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				
				File file = new File(dir + "/" + goods.getGoodsName()+".jpg");
				if(file.exists()) {
					file.delete();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 상품 삭제
	public int removeGoods(int goodsCode) {
		int result = 0;
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
		
			
			goodsDao = new GoodsDao();
			result = goodsDao.deleteGoods(conn, goodsCode);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 상품 추가
	public int addGoods(Goods goods, String dir, String empId) {
		int result = 0;
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			
			goodsDao = new GoodsDao();
			result = goodsDao.insertGoods(conn, goods, empId);
			
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				
				File file = new File(dir + "\\" + goods.getGoodsName());
				if(file.exists()) {
					file.delete();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<Category> selectCategory(){
		ArrayList<Category> list = new ArrayList<Category>();
		
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
		
			
			this.categoryDao= new CategoryDao();
			list = categoryDao.selectCategoryList(conn);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return list;
	}
	
	public ArrayList<Goods> selectGoodsbyHit(){
		ArrayList<Goods> list = new ArrayList<Goods>();
		
		Connection conn = null;
		
		
		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.goodsDao = new GoodsDao();
			list =	goodsDao.goodsListbyHits(conn);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return list;
		
	}
}
