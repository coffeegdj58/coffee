package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Question;

public class QuestionDao {
	//selectlistby id 아이디별로 마이페이지에서 볼 List not paging
	public ArrayList<Question> selectQuestionById(String customerId, Connection conn) throws Exception { 
		ArrayList<Question> list = new ArrayList<Question>();
		
		String sql = "SELECT * FROM question WHERE customer_id =? ORDER BY createdate";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Question q = new Question();
			
			q.setCategory(rs.getString("category"));
			q.setCustomerId(rs.getString("customer_id"));
			q.setQuestionCode(rs.getInt("question_code"));
			q.setOrderCode(rs.getInt("order_code"));
			q.setFlag(rs.getString("flag"));
		
			list.add(q);
		}
		rs.close();
		stmt.close();
		
		
		
		return list;
	}
	
	//selectlistby all 관리자가 답변하는 페이지 list paging 타입검색기능
	public ArrayList<Question> selectQuestionBylistPaging(String category, String searchWord, int beginRow, int rowPerPage, Connection conn) throws Exception {
		ArrayList<Question> list = new ArrayList<Question>();
		
		String sql= "SELECT * FROM question WHERE "+category+" LIKE ? ORDER BY createdate LIMIT ?, ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+searchWord+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Question q = new Question();
			
			q.setCategory(rs.getString("category"));
			q.setCustomerId(rs.getString("customer_id"));
			q.setQuestionCode(rs.getInt("question_code"));
			q.setOrderCode(rs.getInt("order_code"));
			q.setFlag(rs.getString("flag"));
		
			list.add(q);
		}
		rs.close();
		stmt.close();
		
		return list;
	}
	
	//lastPage 찾는 쿼리
	public int countQuestion(int rowPerPage, Connection conn) throws Exception {
		int lastPage= 0;
		
		int count = 0;
		
		String sql = "SELECT COUNT(*) FROM question";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs= stmt.executeQuery();
		if(rs.next()) {
			count=rs.getInt("count(*)");
		}
		lastPage= count/rowPerPage;
		if(count%rowPerPage!=0) {
			lastPage+=1;
		}
		rs.close();
		stmt.close();
		
		
		return lastPage;
	}
	
	//question one 하나의 정보 보여주는 쿼리
	public Question selectQuestionOne(int questionCode, Connection conn) throws Exception {
		Question q = new Question();
		
		String sql = "SELECT * FROM question WHERE question_code= ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			q.setCategory(rs.getString("category"));
			q.setCustomerId(rs.getString("customer_id"));
			q.setQuestionCode(rs.getInt("question_code"));
			q.setOrderCode(rs.getInt("order_code"));
			q.setFlag(rs.getString("flag"));
			q.setQuestionMemo(rs.getString("question_memo"));
		}
		rs.close();
		stmt.close();
		
		return q;
	}
	//회원이 작성하는 문의사항 insert문 
	public int insertQuestion (Question q, Connection conn )throws Exception{
		int result= 0;
		
		String sql = "INSERT INTO question(order_code, category, question_memo, customer_id) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, q.getOrderCode());
		stmt.setString(2, q.getCategory());
		stmt.setString(3, q.getQuestionMemo());
		stmt.setString(4, q.getCustomerId());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		
		
		return result;
		
	}
	
	//only able flag n update
	public int updateQuestion (Question q, Connection conn) throws Exception {
		int result = 0;
		
		String sql= "UPDATE question SET category= ?, question_memo= ? WHERE question_code= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, q.getCategory());
		stmt.setString(2, q.getQuestionMemo());
		stmt.setInt(3, q.getQuestionCode());
		
		result= stmt.executeUpdate();
		stmt.close();
		
		return result;
		
	}
	//only able flag n delete
	public int deleteQuestion (int questionCode, Connection conn) throws Exception{
		int result = 0;
		
		String sql ="DELETE FROM question WHERE question_code= ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setInt(1, questionCode);
		
		result= stmt.executeUpdate();
		stmt.close();
		
		
		return result;
	}
	
}
