package customerController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.OrderService;
import vo.Address;
import vo.Cart;
import vo.Customer;

/**
 * Servlet implementation class CompleteOrderController2
 */
@WebServlet("/CompleteOrder2")
public class CompleteOrderController2 extends HttpServlet {
	
	private OrderService orderService;
	private CustomerService customerService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		int result= Integer.parseInt(request.getParameter("result"));
		
		if(result==0) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		int addressCode = Integer.parseInt(request.getParameter("addressCode"));
		this.customerService = new CustomerService();
		Address a= customerService.addressOne(addressCode);
		
		request.setAttribute("address", a);
		
		
		orderService= new OrderService();
		Cart c = orderService.selectCartlevel2(loginMember.getCustomerId());
		
	
		
		int sum = c.getCartPrice();
		
		request.setAttribute("sum", sum);
		
		ArrayList<Cart> list = new ArrayList<Cart>();
		
		list.add(c);
		request.setAttribute("list", list);
		
	
		
		int row = orderService.deletecartlevel2(loginMember.getCustomerId());
		
		if(row==0) {
			response.sendRedirect(request.getContextPath()+"/CustomerPage");
			return;
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/completeOrder.jsp").forward(request, response);
	}


}
