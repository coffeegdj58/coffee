package util;
import java.sql.*;

public class Dbutil {
	public Connection getConnection() throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://13.124.165.197/shop","root", "java1234");
		conn.setAutoCommit(false);
		return conn;
		}
	public void close(ResultSet rs, PreparedStatement stmt, Connection conn) throws Exception{
		
		if(conn!=null) {
			conn.close();}
		
		if(rs!=null) {
			rs.close();}
		
		if(stmt!=null) {
			stmt.close();}
	}
}
