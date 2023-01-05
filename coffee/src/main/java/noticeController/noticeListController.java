package noticeController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import vo.Notice;


@WebServlet("/notice/noticeList")
public class noticeListController extends HttpServlet {
	private NoticeService noticeService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage=1; //1페이지부터 시작
		int rowPerPage=10; //10개씩 보여줄거
		int beginRow=(currentPage-1)*rowPerPage; //0번부터 보여줄거
		
		this.noticeService=new NoticeService();
		ArrayList<Notice> list=noticeService.getBoardListByPage(beginRow, rowPerPage);
		int selectNoticeCount=noticeService.selectNoticeCount();//전체 행의 개수 가져올거
		
		int lastPage=selectNoticeCount/rowPerPage; //마지막 페이지: 전체 행의 개수 / 10(10개씩 보여줄거니까)
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("beginRow", beginRow);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/notice.jsp").forward(request, response);
		
	}

}
