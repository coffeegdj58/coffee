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
 * Servlet implementation class PaymentController
 */
@WebServlet("/Payment")
public class PaymentController extends HttpServlet {
	private OrderService orderService;
	private CustomerService customerService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}

		this.orderService = new OrderService();
		this.customerService = new CustomerService();
		
		ArrayList<Cart> list = orderService.selectCartListlevel1(loginMember.getCustomerId());
		if(list.isEmpty()) {
			response.sendRedirect(request.getContextPath()+"/CartList");
			return;
		}
		
		ArrayList<Address> address = customerService.addressListById(loginMember.getCustomerId());
		int sum = orderService.selectSumGoodsPrice(loginMember.getCustomerId());
		
		request.setAttribute("sum", sum);
		request.setAttribute("cartList", list);
		request.setAttribute("addressList", address);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/payment.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		int addressCode= Integer.parseInt(request.getParameter("addressCode"));
		int usePoint = 0;
		if(request.getParameter("usePoint")!=null && request.getParameter("usePoint").equals("")!=true) {
			usePoint= Integer.parseInt(request.getParameter("usePoint"));
		}
		int orderPrice= Integer.parseInt(request.getParameter("orderPrice"))-usePoint;
		
		this.orderService = new OrderService();
		this.customerService= new CustomerService();
		ArrayList<Cart> list = orderService.selectCartListlevel1(loginMember.getCustomerId());
		int result= orderService.insertOrdersByCart(list, addressCode, loginMember.getCustomerId());
		if(result==1) {
			//포인트 사용
			
			//포인트 적립
			customerService.insertPointInCustomer(loginMember, orderPrice);
			customerService.insertPointInHistory(loginMember.getCustomerId(), orderPrice);
			
			
			if(usePoint!=0) {
				customerService.usePointUpdateCustomer(loginMember, usePoint);
				customerService.usePointInsertInHistory(loginMember.getCustomerId(), usePoint);
				
				
			}
			
			request.getSession().setAttribute("loginMember", loginMember);
			//loginMemberupdate
			
			//판매량 증가
			orderService.updategoodsHit(list);
			
			//사용된 카트 삭제
			orderService.deleteCartById(loginMember.getCustomerId());
			
		}
		response.sendRedirect(request.getContextPath()+"/CartList");
	}

}
