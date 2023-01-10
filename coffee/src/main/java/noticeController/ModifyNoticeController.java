package noticeController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;


@WebServlet("/ModifyNotice")
public class ModifyNoticeController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		
		//noticeCode받아오기
		int noticeCode=Integer.parseInt(request.getParameter("noticeCode"));
		//service 불러오기
		this.noticeService=new NoticeService();
		Notice n= noticeService.selectModifyNotice(noticeCode);
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/modifyNotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//폼에서 받아오기
		String noticeTitle=request.getParameter("noticeTitle");
		String noticeContent=request.getParameter("noticeContent");
		String empId=request.getParameter("empId");
		
		Notice notice= new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setEmpId(empId);
		//service 불러오기
		this.noticeService=new NoticeService();
		int row=noticeService.modifyNotice(notice);
		if(row==1) {//수정 성공
			response.sendRedirect(request.getContextPath()+"/NoticeList");
		}else {//실패
			System.out.println("공지사항 수정 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('공지사항 수정 실패!'); location.href='"+request.getContextPath()+"/ModifyNotice"+"';</script>"); 
			writer.close();
		}
	}

}
