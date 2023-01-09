package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Address;
import vo.Customer;

/**
 * Servlet implementation class ModifyAddressController
 */
@WebServlet("/ModifyAddressController")
public class ModifyAddressController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		this.customerService = new CustomerService();
		
		int addressCode = Integer.parseInt(request.getParameter("addressCode"));
		
		Address a= customerService.addressOne(addressCode);
		
		request.setAttribute("address", a);
		request.getRequestDispatcher("/WEB-INF/view/customer/modifyAddress.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
