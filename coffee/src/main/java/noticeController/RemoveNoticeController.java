package noticeController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;

/**
 * Servlet implementation class removeNoticeController
 */
@WebServlet("/RemoveNotice")
public class RemoveNoticeController extends HttpServlet {
	private NoticeService noticeService;
	
	//공지사항 삭제 액션
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//noticeCode받아오기
		int noticeCode=Integer.parseInt(request.getParameter("noticeCode"));
		//service 불러오기
		this.noticeService=new NoticeService();
		int row=noticeService.removeNotice(noticeCode);
		if(row==1) {//삭제 성공
			response.sendRedirect(request.getContextPath()+"/NoticeList");
		}else {//실패
			System.out.println("공지사항 삭제 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('공지사항 삭제 실패!'); location.href='"+request.getContextPath()+"/NoticeList"+"';</script>"); 
			writer.close();
		}
	}

}
