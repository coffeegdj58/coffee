package empController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.EmpService;
import vo.Emp;

@WebServlet("/emp/loginEmp")
public class loginEmpController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/emp/loginEmp.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		//로그인 폼에서 받아오기
		String empId=request.getParameter("empId");
		String empPw=request.getParameter("empPw");
		
		Emp emp= new Emp();
		emp.setEmpId(empId);
		emp.setEmpPw(empPw);
		
		this.empService=new EmpService();
		Emp resultEmp=empService.loginEmp(emp);
		
		if(resultEmp==null) {//로그인 실패 시 
			response.sendRedirect(request.getContextPath()+"/emp/loginEmp");
		}else {
			session.setAttribute("loginMember", resultEmp);
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		
	}

}
