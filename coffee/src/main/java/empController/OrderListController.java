package empController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import vo.Customer;
import vo.Emp;
import vo.Order;

/**
 * Servlet implementation class OrderListController
 */
@WebServlet("/OrderList")
public class OrderListController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 가능
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp");
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}	
		//service 불러오기
		this.empService=new EmpService();
		ArrayList<Order> list=empService.selectOrder();
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("Olist", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/orderList.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//폼에서 받아오기
		String orderState=request.getParameter("orderState");
		String customerId=request.getParameter("customerId");
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		//service 불러오기
		this.empService=new EmpService();
		int row=empService.modifyOrderState(orderState, customerId, orderCode);
			System.out.println("수정성공");
			response.sendRedirect(request.getContextPath()+"/OrderList");
		}
		
		
	}

