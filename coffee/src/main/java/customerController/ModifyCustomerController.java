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
 * Servlet implementation class ModifyCustomerController
 */
@WebServlet("/ModifyCustomerController")
public class ModifyCustomerController extends HttpServlet {
	private CustomerService customerService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/view/customer/modifyCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		String beforePassword = request.getParameter("beforePassword");
		String afterPassword= request.getParameter("afterPassword");
		
		this.customerService= new CustomerService();
		int row= customerService.pwCheck(loginMember.getCustomerId(), afterPassword);
		//pwhistory에서 사용한건지확인하는 쿼리
		
		if(row==0) {
			int result = customerService.updateCustomer(loginMember.getCustomerId(), afterPassword, beforePassword);
			if(result==1) {
				result=customerService.insertPwHistory(loginMember.getCustomerId(), beforePassword);
			}	
			System.out.println(result+"변경?");
		}
		
		response.sendRedirect(request.getContextPath()+"/ModifyCustomerController");
		
	}

}
