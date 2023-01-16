package customerController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.OrderService;
import service.ReviewService;
import vo.Customer;
import vo.Review;

/**
 * Servlet implementation class CustomerPageController
 */
@WebServlet("/CustomerPage")
public class CustomerPageController extends HttpServlet {
	private OrderService orderService;
	private CustomerService customerService;
	private ReviewService reviewService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/CustomerLogin");
			return;
		}
		this.orderService = new OrderService();
		ArrayList<HashMap<String, Object>> list = orderService.selectOrderListByid(loginMember.getCustomerId());
		
		request.setAttribute("orderList", list);
		
		//
		String customerId=loginMember.getCustomerId();
		this.reviewService= new ReviewService();
		ArrayList<Review> Rlist=reviewService.selectReviewById(customerId);
		
		request.setAttribute("Rlist", Rlist);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/myPage.jsp").forward(request, response);
	}

	

}
