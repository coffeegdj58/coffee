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
import vo.Address;
import vo.Customer;

/**
 * Servlet implementation class AddressCustomerController
 */
@WebServlet("/AddressCustomer")
public class AddressCustomerController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		this.customerService= new CustomerService();
		ArrayList<Address> list= customerService.addressListById(loginMember.getCustomerId());
		request.setAttribute("list", list);
		int msg=0;
		if(request.getParameter("msg")!=null) {
			msg=Integer.parseInt(request.getParameter("msg"));
		}
		
		request.setAttribute("msg", msg);	
		request.getRequestDispatcher("/WEB-INF/view/customer/customerAddress.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		request.setCharacterEncoding("utf-8");
		String address= request.getParameter("address");
		int flag = 0;
		if(request.getParameter("flag")!=null) {
			flag= Integer.parseInt(request.getParameter("flag"));
		}
		this.customerService = new CustomerService();
		if(flag==1) {
			customerService.resetAddressFlag(loginMember.getCustomerId());
		}
		int result= customerService.adddAddress(loginMember.getCustomerId(), address, flag);
		System.out.println(result);
		
		response.sendRedirect(request.getContextPath()+"/AddressCustomer");
	}

}
