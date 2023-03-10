package empController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CounterService;
import service.EmpService;
import vo.Emp;


@WebServlet("/EmpPage")
public class EmpPageController extends HttpServlet {
	private EmpService empService;
	private CounterService counterService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 관리자만 들어올 수 있겠끔
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		//System.out.println(loginEmp+"현재 로그인 한 사람");
		//service 불러오기
		this.empService= new EmpService();
		ArrayList<Emp> list= empService.selectEmpList();
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		
		//접속자 수
		counterService = new CounterService();
		int todayCount = counterService.selectTodayCount();
		//System.out.println("todayCount : "+ todayCount);
		request.setAttribute("todayCount", todayCount);

		int totalCount = counterService.selectTotalCount();
		//System.out.println("totalCount : "+ totalCount);
		request.setAttribute("totalCount", totalCount);
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empPage.jsp").forward(request, response);
	}

}
