package empController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.EmpService;
import vo.Emp;

@WebServlet("/LoginEmp")
public class LoginEmpController extends HttpServlet {
	private EmpService empService;
	//관리자 로그임 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/emp/loginEmp.jsp").forward(request, response);
	}
	//관리자 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		//로그인 폼에서 받아오기 
		String empId=request.getParameter("empId");
		String empPw=request.getParameter("empPw");
		
		Emp emp= new Emp();
		emp.setEmpId(empId);
		emp.setEmpPw(empPw);
		//service 불러오기
		empService=new EmpService();
		Emp resultEmp=empService.loginEmp(emp);
		if(resultEmp==null) {//로그인 실패 시 
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 실패!'); location.href='"+request.getContextPath()+"/LoginEmp"+"';</script>"); 
			writer.close();
		}else if(resultEmp!=null){
			//System.out.println(resultEmp+"<==resultEmp");
			session.setAttribute("loginEmp", resultEmp); //세션에 저장
			response.sendRedirect(request.getContextPath()+"/Home");
		}
		
	}

}
