package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.QuestionDao;
import util.Dbutil;
import vo.Question;

public class QuestionService {
	private QuestionDao questiondao;
	private Dbutil db;
	
	public ArrayList<Question> selectQuestionById(String customerId){
		ArrayList<Question> list = new ArrayList<Question>();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			list = questiondao.selectQuestionById(customerId, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
	
	public ArrayList<Question> selectQuestionByListPaging(String category, String searchWord, int currentPage, int rowPerPage){
		ArrayList<Question> list = new ArrayList<Question>();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			int beginRow = (currentPage-1)*rowPerPage+1;
			
			list = questiondao.selectQuestionBylistPaging(category, searchWord, beginRow, rowPerPage, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
	
	public int countQuestion(int rowPerPage) {
		int lastPage=0;
		
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			
			lastPage= questiondao.countQuestion(rowPerPage, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
		
		
		return lastPage;
	}
	
	public Question selectQuestionOne(int questionCode) {
		Question q = new Question();
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			q = questiondao.selectQuestionOne(questionCode, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
		
		
		return q;
	}
	
	public int insertQuestion (Question q ) {
		int result=0;
		
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			
			result = questiondao.insertQuestion(q, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
		
		
		return result;
			
	}
	
	public int updateQuestion(Question q) {
		int result=0;
		
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			
			result = questiondao.updateQuestion(q, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
		
		
		return result;
		
	}
	
	public int deleteQuestion(int questionCode) {
		int result=0;
		
		Connection conn = null;

		try {
			db= new Dbutil();
			conn = db.getConnection();
			this.questiondao = new QuestionDao();
			
			
			result =questiondao.deleteQuestion(questionCode, conn);
			
			conn.commit(); // DBUtil.class에서 conn.setAutoCommit(false);
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil.class에서 conn.setAutoCommit(false);
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
		
		
		return result;
		
	}
}
