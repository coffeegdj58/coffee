package noticeController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.NoticeService;
import vo.Emp;
import vo.Notice;


@WebServlet("/ModifyNotice")
public class ModifyNoticeController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//세션에서 관리자만 들어올 수 있겠끔
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
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
		int noticeCode=Integer.parseInt(request.getParameter("noticeCode"));
		String noticeTitle=request.getParameter("noticeTitle");
		String noticeContent=request.getParameter("noticeContent");
		String empId=request.getParameter("empId");
		
		Notice notice= new Notice();
		notice.setNoticeCode(noticeCode);
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
			writer.println("<script>alert('공지사항 수정 실패!'); location.href='"+request.getContextPath()+"/ModifyNotice"+noticeCode+"';</script>"); 
			writer.close();
		}
	}

}
