package noticeController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.NoticeService;
import vo.Emp;
import vo.Notice;


@WebServlet("/NoticeList")
public class NoticeListController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원 비회원 모두가 볼 수 있게 
		//공지사항 추가는 관리자 로그인한 사람만 가능하게 할 것
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		request.setAttribute("loginEmp", loginEmp);
		
		int currentPage=1; //1페이지부터 시작
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage=10; //10개씩 보여줄거
		int beginRow=(currentPage-1)*rowPerPage; //0번부터 보여줄거
		//service 불러오기
		this.noticeService=new NoticeService();
		ArrayList<Notice> list=noticeService.getBoardListByPage(beginRow, rowPerPage);
		
		int selectNoticeCount=noticeService.selectNoticeCount();//전체 행의 개수 가져올거
		int lastPage=selectNoticeCount/rowPerPage; //마지막 페이지: 전체 행의 개수 / 10(10개씩 보여줄거니까)
		if(selectNoticeCount%rowPerPage!=0) {
			lastPage=lastPage+1;
		}
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/notice.jsp").forward(request, response);
		
	}

}
