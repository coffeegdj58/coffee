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
 * Servlet implementation class Payment3Controller
 */
@WebServlet("/Payment3")
public class Payment3Controller extends HttpServlet {
	private OrderService orderService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartQuantity = request.getParameter("cartQuantity");
		String goodsCode= request.getParameter("goodsCode");
		
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember==null) {
			response.sendRedirect(request.getContextPath()+"/CustomerLogin");
			return;
		}
		this.orderService= new OrderService();
		
		orderService.deletecartlevel2(loginMember.getCustomerId());
		
		response.sendRedirect(request.getContextPath()+"/Payment2?cartQuantity="+cartQuantity+"&goodsCode="+goodsCode);
		

	}

}
