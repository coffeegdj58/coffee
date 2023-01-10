package empController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.*;
import vo.*;


@WebServlet("/EmpPage")
public class EmpPageController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 관리자만 들어올 수 있겠끔
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		int authCode=loginEmp.getAuthCode();
		request.setAttribute("authCode", authCode);
		System.out.println(loginEmp+"현재 로그인 한 사람");
		//service 불러오기
		this.empService= new EmpService();
		ArrayList<Emp> list= empService.selectEmpList();
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empPage.jsp").forward(request, response);
	}

}
