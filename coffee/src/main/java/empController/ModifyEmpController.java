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
import service.NoticeService;
import vo.Emp;
import vo.Notice;

@WebServlet("/ModifyEmp")
public class ModifyEmpController extends HttpServlet {
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
		
		request.setCharacterEncoding("utf-8");
		//폼에서 받아오기
		int empCode= Integer.parseInt(request.getParameter("empCode"));
		//System.out.println(empCode+"<===empCode");
		String empId= request.getParameter("empId");
		//System.out.println(empId+"<===empId");
		String empName= request.getParameter("empName");
		//System.out.println(empName+"<===empName");
		String active= request.getParameter("active");
		//System.out.println(active+"<===active");
		int authCode= Integer.parseInt(request.getParameter("authCode"));
		//System.out.println(authCode+"<===authCode");
		String createdate= request.getParameter("createdate");
		//System.out.println(createdate+"<===createdate");
	
		Emp emp= new Emp();
		emp.setEmpCode(empCode);
		emp.setActive(active);
		emp.setAuthCode(authCode);
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setCreatedate(createdate);
		//System.out.println(emp+"<==emp");
		//service 불러오기
		this.empService= new EmpService();
		int row=empService.modifyEmp(emp);
		if(row==1) {//수정 성공
			response.sendRedirect(request.getContextPath()+"/EmpPage");
		}else {//실패
			System.out.println("사원 수정 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('사원 수정 실패!'); location.href='"+request.getContextPath()+"/ModifyEmp"+empCode+"';</script>"); 
			writer.close();
		}
	}

}
