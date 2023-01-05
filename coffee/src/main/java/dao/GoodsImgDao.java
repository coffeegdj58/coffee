package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.GoodsImg;

public class GoodsImgDao {
	// 상품 수정
	public int updateGoodsImg(Connection conn, GoodsImg goodsImg) throws Exception {
		
		String sql = "UPDATE goods_img gsi, goods gs SET filename = ?, origin_name = ?, content_type = ?, goods_content = ?, goods_info = ?"
				+ ", gsi.updatedate = gs.updatedate WHERE gsi.goods_code = gs.goods_code AND gsi.goods_code = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goodsImg.getFilename());
		stmt.setString(2, goodsImg.getOriginName());
		stmt.setString(3, goodsImg.getContentType());
		stmt.setString(4, goodsImg.getGoodsContent());
		stmt.setString(5, goodsImg.getGoodsInfo());
		stmt.setInt(6, goodsImg.getGoodsCode());
		
		int result = stmt.executeUpdate();
		
		if(stmt != null) {stmt.close();}
		
		return result;
	}
	
	// 상품 삭제
	public int deleteGoodsimg(Connection conn, int goodsCode) throws Exception {
		
		String sql = "DELETE FROM goods_img WHERE goods_code = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		
		int result = stmt.executeUpdate();
		
		if(stmt != null) {stmt.close();}
		
		return result;
	}
	
	// 상품 추가
	public int insertGoodsImg(Connection conn, GoodsImg goodsImg) throws Exception {
		
		String sql = "INSERT INTO goods_img(goods_code, filename, origin_name, content_type, goods_content, goods_info, createdate, updatedate)"
				+ " VALUES(?, ?, ?, ?, ?, ?, (SELECT createdate FROM goods WHERE goods_code = "+ goodsImg.getGoodsCode() +"),"
						+ "(SELECT updatedate FROM goods WHERE goods_code ="+ goodsImg.getGoodsCode() +"))";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsImg.getGoodsCode());
		stmt.setString(2, goodsImg.getFilename());
		stmt.setString(3, goodsImg.getOriginName());
		stmt.setString(4, goodsImg.getContentType());
		stmt.setString(5, goodsImg.getGoodsContent());
		stmt.setString(6, goodsImg.getGoodsInfo());
		
		int result = stmt.executeUpdate();
		
		if(stmt != null) {stmt.close();}
		
		return result;
		
	}
}
