package customerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Customer;

/**
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/AddCustomer")
public class AddCustomerController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}//login 되어있을 시 들어 오지 못한다
		int msg=0;
		if(request.getParameter("msg")!=null) {
			msg=Integer.parseInt(request.getParameter("msg"));
		}
		request.setAttribute("msg", msg);		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/customer/addCustomer.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String customerId  = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String customerName = request.getParameter("customerName");
		String customerPhone = request.getParameter("customerPhone");
		String customerGender = request.getParameter("customerGender");
		String customerBirth = request.getParameter("customerBirth");
		
		Customer cust = new Customer();
		this.customerService = new CustomerService();
		
		cust.setCustomerBirth(customerBirth);
		cust.setCustomerGender(customerGender);
		cust.setCustomerId(customerId);
		cust.setCustomerName(customerName);
		cust.setCustomerPhone(customerPhone);
		cust.setCustomerPw(customerPw);
		
		int result = customerService.checkCustomerId(customerId);
		
		if(result ==0) {
			int row = customerService.insertCutomer(cust);
			row = customerService.signUpCustomerByOutid(customerId);
			
			System.out.println("회원가입성공"+row);
			
			response.sendRedirect(request.getContextPath()+"/CustomerLogin");
		}else {
			response.sendRedirect(request.getContextPath()+"/AddCustomer?msg=1");
		}
		
		
	}

}
