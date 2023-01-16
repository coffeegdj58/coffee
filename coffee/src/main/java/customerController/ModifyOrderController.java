package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.GoodsService;
import service.OrderService;
import vo.Address;
import vo.Customer;
import vo.Goods;
import vo.Order;

/**
 * Servlet implementation class ModifyOrderController
 */
@WebServlet("/ModifyOrder")
public class ModifyOrderController extends HttpServlet {
	private OrderService orderService;
	private CustomerService customerService;
	
	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}	
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		this.orderService= new OrderService();
		this.customerService = new CustomerService();
		this.goodsService = new GoodsService();
		Order o = orderService.selectOrderOne(orderCode);
		Address a = customerService.addressOne(o.getAddressCode());
		Goods g = goodsService.getGoodsOne(o.getGoodsCode());
		
		request.setAttribute("address", a);
		request.setAttribute("goods", g);
		request.setAttribute("order", o);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/orderState.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
