package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Notice;

public class NoticeDao {
	
	//수정 Form에서 메모 내용이랑 번호 가져오기 적고보니 쓸 필요가 없었음 one꺼 가져다 쓰면 됐었네,,,
	public Notice selectModifyNotice(Connection conn, int noticeCode)throws Exception {
		Notice notice=null;
		String sql="SELECT notice_code noticeCode,notice_title noticeTitle, notice_content noticeContent, emp_id empId FROM notice WHERE notice_code=? ;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, noticeCode);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()) {
			notice=new Notice();
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setEmpId(rs.getString("empId"));
			notice.setNoticeCode(rs.getInt("noticeCode"));
		}
		return notice;
	}
	
	//modifyNotice Action
	public int modifyNotice(Connection conn, Notice notice) throws Exception {
		int row=0;
		String sql = "UPDATE notice SET notice_title =?, notice_content =?  WHERE notice_code=? ;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeContent());
		stmt.setInt(3, notice.getNoticeCode());
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("수정성공");
		}
		return row;
	}
	
	//removeNotice
	public int removeNotice(Connection conn, int noticeCode) throws Exception {
		int row=0;
		String sql = "DELETE FROM notice WHERE notice_code=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, noticeCode);
		row=stmt.executeUpdate();
		if(row==1) {
			System.out.println("삭제성공");
		}
		return row;
	}
	
	//addNotice
	public int addNotice(Connection conn,Notice notice) throws Exception {
		int row=0;
		String sql = "INSERT notice(notice_title noticeTitle,notice_content noticeContent,emp_id empId,createdate) VALUES (?,?,?,NOW());";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeContent());
		stmt.setString(3, notice.getEmpId());
		row=stmt.executeUpdate();
		if (row == 1) {
			System.out.println("추가 성공");
		}
		return row;
	}
	//noticeOne
	public Notice noticeOne(Connection conn, int noticeCode) throws Exception {
		String sql = "SELECT notice_code noticeCode, notice_title noticeTitle, notice_content noticeContent, emp_id empId, createdate FROM board WHERE notice_code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeCode);
		ResultSet rs = stmt.executeQuery();
		Notice n = new Notice();
		if(rs.next()) {
			n.setNoticeTitle(rs.getString("noticeTitle"));
			n.setNoticeContent(rs.getString("noticeContent"));
			n.setEmpId(rs.getString("empId"));
			n.setCreatedate(rs.getString("createdate"));
			n.setNoticeCode(rs.getInt("noticeCode"));
		}
		return n;
	}

	// 마지막페이지 구하려면 전체 개수만 구하면 됨
	public int selectNoticeCount(Connection conn) throws Exception {
		int count = 1; //sql의 경우 1번째 인덱스부터 시작
		String countSql = "SELECT COUNT(*) FROM notice;";
		 PreparedStatement countStmt = conn.prepareStatement(countSql);
		ResultSet countRs = countStmt.executeQuery();
		if (countRs.next()) {
			count = countRs.getInt(count);
		}
		return count;
	}
	
	
	//noticeList
	public ArrayList<Notice> selectNoticeListByPage(Connection conn,int beginRow, int rowPerPage) throws Exception {
		ArrayList<Notice> list = new ArrayList<Notice>();
		String sql = "SELECT notice_code noticeCode, notice_title noticeTitle, notice_content noticeContent, createdate FROM notice ORDER BY createdate DESC LIMIT ?,?; ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notice n = new Notice();
			n.setNoticeCode(rs.getInt("noticeCode"));
			n.setNoticeTitle(rs.getString("noticeTitle"));
			n.setNoticeContent(rs.getString("noticeContent"));
			n.setCreatedate(rs.getString("createdate"));
			list.add(n);
		}
		return list;
	}
	
	
}
