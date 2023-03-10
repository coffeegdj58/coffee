package questionController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.*;
import vo.*;

/**
 * Servlet implementation class QuestionListByEmpController
 */
@WebServlet("/QuestionListByEmp")
public class QuestionListByEmpController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자만 볼 수 있음
		//세션에서 관리자만 들어올 수 있겠끔
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		
		int currentPage=1; //1페이지부터 시작
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage=10; //10개씩 보여줄거
		//폼에서 받아올 것
		String category="category";
		if(request.getParameter("category")!=null) {
			category= request.getParameter("category");
		}
		String searchWord=""; //검색 값이 없을때
		if(request.getParameter("searchWord")!=null) { //검색어 값이 null이 아닐떄는 그 값을 받아서 검색하고
			searchWord=request.getParameter("searchWord");
		}
		
		//service 불러오기
		this.questionService=new QuestionService();
		ArrayList<Question> list=questionService.selectQuestionByListPaging(category,searchWord ,currentPage , rowPerPage);
		int lastPage=questionService.countQuestion(rowPerPage);
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/questionListByEmp.jsp").forward(request, response);
	}

}
