package noticeController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import vo.*;

@WebServlet("/NoticeOne")
public class NoticeOneController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
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
