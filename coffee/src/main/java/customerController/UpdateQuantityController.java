package customerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import vo.Customer;

/**
 * Servlet implementation class UpdateQuantityController
 */
@WebServlet("/UpdateQuantity")
public class UpdateQuantityController extends HttpServlet {
	private OrderService orderService;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		int cartQuantity = Integer.parseInt(request.getParameter("cartQuantity"));
		int goodsCode= Integer.parseInt(request.getParameter("goodsCode"));
		
		this.orderService= new OrderService();
		int result = orderService.updateCartQuantity(loginMember.getCustomerId(), cartQuantity, goodsCode);
		
		response.sendRedirect(request.getContextPath()+"/CartList?reult="+result);
		
	}

}
