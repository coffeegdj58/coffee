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


@WebServlet("/PaymentOne")
public class PaymentOneController extends HttpServlet {
	private OrderService orderService;
	private CustomerService customerService;
	//바로구매 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		//service에서 불러오기
		//바로가기에 담긴거 불러오기
		this.orderService= new OrderService();
		Cart c=orderService.selectCartlevel2(loginMember.getCustomerId());
		request.setAttribute("c", c);
		ArrayList<Address> address = customerService.addressListById(loginMember.getCustomerId());
		request.setAttribute("addressList", address);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/payment2.jsp").forward(request, response);
	}

	//바로구매 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
