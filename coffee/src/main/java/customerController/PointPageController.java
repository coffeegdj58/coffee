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
import vo.Customer;
import vo.Point;

/**
 * Servlet implementation class PointPageController
 */
@WebServlet("/PointPageController")
public class PointPageController extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		
		this.customerService = new CustomerService();
		ArrayList<Point> list = customerService.pointListById(loginMember.getCustomerId());
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/pointPage.jsp").forward(request, response);
	}


}
