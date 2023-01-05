package empController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import vo.Emp;


@WebServlet("/emp/addEmp")
public class addEmpController extends HttpServlet {
	private EmpService empService;
	//회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/emp/addEmp.jsp").forward(request, response);
	}
	//회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId=request.getParameter("empId");
		String empPw=request.getParameter("empPw");
		String empName=request.getParameter("empName");
		
		this.empService=new EmpService();
		empService.idCkEmp(empId);
		if(empService.idCkEmp(empId)==true) {//중복된 아이디
			System.out.println("중복된 아이디 입니다(컨트롤러)");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('중복 아이디입니다.'); location.href='"+request.getContextPath()+"/emp/addEmp"+"';</script>"); 
			writer.close();
		}
		Emp emp= new Emp();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpPw(empPw);
		
		int row=empService.signUpEmp(emp);
		if(row==1) {//회원가입 성공
			response.sendRedirect(request.getContextPath()+"/emp/loginEmp"); 
			return;
		}else {//회원가입 실패
			response.sendRedirect(request.getContextPath()+"/emp/addEmp"); 
			return;
		}
		
	}

}