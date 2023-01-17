package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;

/**
 * Servlet implementation class DeleteAddressController
 */
@WebServlet("/DeleteAddress")
public class DeleteAddressController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressCode= Integer.parseInt(request.getParameter("addressCode"));
		this.customerService = new CustomerService();
		customerService.deleteAddress(addressCode);
		
		response.sendRedirect(request.getContextPath()+"/AddressCustomer");
		
	}

	
}
