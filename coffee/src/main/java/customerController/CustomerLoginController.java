package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.OrderService;
import vo.Customer;

/**
 * Servlet implementation class CustomerLoginController
 */
@WebServlet("/CustomerLogin")
public class CustomerLoginController extends HttpServlet {
	private CustomerService customerservice;
	private OrderService orderService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		
		int msg=0;
		if(request.getParameter("msg")!=null) {
			msg=Integer.parseInt(request.getParameter("msg"));
		}
		request.setAttribute("msg", msg);	
		
		request.getRequestDispatcher("/WEB-INF/view/customer/loginCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		
		this.customerservice= new CustomerService();
		this.orderService = new OrderService();
		
		Customer c = customerservice.loginCustomer(customerId, customerPw);
		int count= orderService.selectCountCart(c.getCustomerId());
		
		c.setCustomerCart(count);
		
		if(c.getCustomerId() != null) {
			request.getSession().setAttribute("loginMember", c);
			response.sendRedirect(request.getContextPath()+"/Home");
		}else {
						
			response.sendRedirect(request.getContextPath()+"/CustomerLogin?msg=1");
		}
	}

}
