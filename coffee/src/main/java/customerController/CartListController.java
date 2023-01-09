package customerController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import vo.Cart;
import vo.Customer;

/**
 * Servlet implementation class CartListController
 */
@WebServlet("/CartListController")
public class CartListController extends HttpServlet {
	
	private OrderService orderservice;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		
		this.orderservice = new OrderService();
		ArrayList<Cart> list = orderservice.selectCartListbyId(loginMember.getCustomerId());
		//cartlist
		request.setAttribute("cartList", list);
		
		//총가격
		int sum = orderservice.selectSumGoodsPrice(loginMember.getCustomerId());
		
		request.setAttribute("sum", sum);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/cartList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
