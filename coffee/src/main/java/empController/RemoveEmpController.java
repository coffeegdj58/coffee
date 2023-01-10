package empController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import vo.Emp;

@WebServlet("/RemoveEmp")
public class RemoveEmpController extends HttpServlet {
	private EmpService empService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//세션에서 관리자만 들어올 수 있겠끔
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
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
			writer.println("<script>alert('사원 삭제 실패!'); location.href='"+request.getContextPath()+"/EmpPage"+"';</script>"); 
			writer.close();
		}
	}

}
