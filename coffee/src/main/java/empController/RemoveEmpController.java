package empController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;

@WebServlet("/RemoveEmp")
public class RemoveEmpController extends HttpServlet {
	private EmpService empService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//empCode 받아오기
		int empCode= Integer.parseInt(request.getParameter("empCode"));
		this.empService=new EmpService();
		int row=empService.removeEmp(empCode);
		if(row==1) {//회원 삭제 성공
			response.sendRedirect(request.getContextPath()+"/EmpPage"); 
			return;
		}else {//회원 삭제 실패
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원 삭제 실패!'); location.href='"+request.getContextPath()+"/EmpPage"+"';</script>"); 
			writer.close();
		}
	}

}
