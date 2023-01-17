package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CounterDao {
	//오늘: 접속자가 처음 발생 insert: selectTodayCount() 호출의 결과가 0
	public void insertCounter(Connection conn) throws Exception{
		String sql="INSERT INTO site_counter(counter_date, counter_num) values(CURDATE(), 1)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.executeUpdate();
	}
	
	//오늘: 접속자가 처음이 아닐 경우 UPDATE: selectTodayCount() 호출의 결과가 0이 아님
	public void updateCounter(Connection conn) throws Exception{
		String sql = "UPDATE site_counter SET counter_num = counter_num+1 WHERE counter_date = CURDATE()";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.executeUpdate();
	}
	//오늘 접속자 수 확인: SELECT
	public int selectTodayCount(Connection conn) throws Exception{
		int todayCount=0;
		String sql="SELECT counter_num counterNum FROM site_counter WHERE counter_date = CURDATE();";
		PreparedStatement stmt=conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			todayCount=rs.getInt("counterNum");
		}
		return todayCount;
	}
	// 전체 접속 수 확인 select
	public int selectTotalCount(Connection conn) throws Exception{
		int totalCount = 0;
		String sql = "SELECT SUM(counter_num) totalCount FROM site_counter";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalCount = rs.getInt("totalCount");
		}
		return totalCount;
	}
}
