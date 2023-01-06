package empController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import vo.*;


@WebServlet("/emp/empPage")
public class EmpPageController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service 불러오기
		this.empService= new EmpService();
		ArrayList<Emp> list= empService.selectEmpList();
		
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empPage.jsp").forward(request, response);
	}

}
