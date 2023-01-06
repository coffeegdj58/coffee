package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Customer;

/**
 * Servlet implementation class CustomerLoginController
 */
@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet {
	private CustomerService customerservice;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		
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
		
		Customer c = customerservice.loginCustomer(customerId, customerPw);
		
		if(c.getCustomerId() != null) {
			request.getSession().setAttribute("loginMember", c);
			response.sendRedirect(request.getContextPath()+"/HomeController");
		}else {
						
			response.sendRedirect(request.getContextPath()+"/CustomerLoginController");
		}
	}

}
