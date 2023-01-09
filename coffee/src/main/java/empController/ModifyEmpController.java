package empController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import service.NoticeService;
import vo.Emp;
import vo.Notice;

/**
 * Servlet implementation class ModifyEmpController
 */
@WebServlet("/emp/modifyEmp")
public class ModifyEmpController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//empCode받아오기
		int empCode= Integer.parseInt(request.getParameter("empCode"));
		//service 불러오기
		this.empService=new EmpService();
		Emp e= empService.selectModifyEmp(empCode);
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("e", e);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/modifyEmp.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//폼에서 받아오기
		int empCode= Integer.parseInt(request.getParameter("empCode"));
		String empId= request.getParameter("empId");
		String empName= request.getParameter("empName");
		String active= request.getParameter("active");
		int authCode= Integer.parseInt(request.getParameter("authCode"));
		String createdate= request.getParameter("createdate");
	
		Emp emp= new Emp();
		emp.setAuthCode(authCode);
		emp.setActive(active);
		emp.setAuthCode(authCode);
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setCreatedate(createdate);
		//service 불러오기
		this.empService= new EmpService();
		int row=empService.modifyEmp(emp);
		if(row==1) {//수정 성공
			response.sendRedirect(request.getContextPath()+"/emp/empPage");
		}else {//실패
			System.out.println("공지사항 수정 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('공지사항 수정 실패!'); location.href='"+request.getContextPath()+"/emp/modifyEmp"+"';</script>"); 
			writer.close();
		}
	}

}
