package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import vo.Customer;

/**
 * Servlet implementation class UpdateOrderController
 */
@WebServlet("/UpdateOrder")
public class UpdateOrderController extends HttpServlet {
	private OrderService orderService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/CustomerLogin");
			return;
		}
		int orderCode= Integer.parseInt(request.getParameter("orderCode"));
		
		orderService = new OrderService();
		orderService.updateOrderState("취소", orderCode);
		
		response.sendRedirect(request.getContextPath()+"/CustomerPage");
	}

	

}
