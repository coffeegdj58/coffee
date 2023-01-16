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
 * Servlet implementation class CompleteOrderController
 */
@WebServlet("/CompleteOrder")
public class CompleteOrderController extends HttpServlet {
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
		ArrayList<Cart> list = orderService.selectCartListlevel1(loginMember.getCustomerId());
		int sum = orderService.selectSumGoodsPrice(loginMember.getCustomerId());
		
		request.setAttribute("sum", sum);
		
		request.setAttribute("list", list);
		
		orderService.deleteCartById(loginMember.getCustomerId());
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/completeOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
