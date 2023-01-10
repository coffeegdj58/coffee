package noticeController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.*;
import vo.*;

@WebServlet("/NoticeOne")
public class NoticeOneController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 사람이 접근 가능
		//수정 삭제는 관리자 로그인한 사람만 가능하게 할 것
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		request.setAttribute("loginEmp", loginEmp);
		//noticeCode받아오기
		int noticeCode=Integer.parseInt(request.getParameter("noticeCode"));
		//service 불러오기
		this.noticeService=new NoticeService();
		Notice n=noticeService.noticeOne(noticeCode);
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("n", n);
		
		
		request.getRequestDispatcher("/WEB-INF/view/emp/noticeOne.jsp").forward(request, response);
	}

}
