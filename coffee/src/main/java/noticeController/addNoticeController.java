package noticeController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;

/**
 * Servlet implementation class addNoticeController
 */
@WebServlet("/notice/addNotice")
public class addNoticeController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		request.getRequestDispatcher("/WEB-INF/view/emp/addNotice.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼에서 받아오기
		request.setCharacterEncoding("utf-8");
		String noticeTitle=request.getParameter("noticeTitle");
		String noticeContent=request.getParameter("noticeContent");
		String empId=request.getParameter("empId");
		
		Notice notice= new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setEmpId(empId);
		//service 불러오기
		this.noticeService=new NoticeService();
		int row=noticeService.addNotice(notice);
		if(row==1) { //성공: 공지사항 추가 성공하면 noticeList로 보낼거
			response.sendRedirect(request.getContextPath()+"/notice/noticeList"); 
		}else { //실패: 실패하면 다시 addlist로 보낼거
			System.out.println("공지사항 추가 실패");
			response.sendRedirect(request.getContextPath()+"/notice/addNotice"); 
		}
	}

}
