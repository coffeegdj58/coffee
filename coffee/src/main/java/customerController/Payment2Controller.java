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


@WebServlet("/Payment2")
public class Payment2Controller extends HttpServlet {
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
		String customerId=loginMember.getCustomerId();
		//goodsOne에서 바로 구매 누를 시에 받을 값
		int goodsCode=Integer.parseInt(request.getParameter("goodsCode"));
		System.out.println(goodsCode);
		int cartQuantity=Integer.parseInt(request.getParameter("cartQuantity"));
		//service에서 불러오기
		this.orderService= new OrderService();
		//카트에 담긴거..
		int result=orderService.insertCartlevel2(customerId, goodsCode, cartQuantity);
		//카트에 담긴거 불러오기
		this.orderService= new OrderService();
		Cart c=orderService.selectCartlevel2(customerId);
		
		request.setAttribute("c", c);
		this.customerService = new CustomerService();
		ArrayList<Address> address = customerService.addressListById(customerId);
		request.setAttribute("addressList", address);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/payment2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 사용자
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		String customerId=loginMember.getCustomerId();
		//payment2 폼에서 받아올 것
		int goodsCode=Integer.parseInt(request.getParameter("goodsCode"));
		//System.out.println(goodsCode+"goodsCode");
		int cartQuantity=Integer.parseInt(request.getParameter("cartQuantity"));
		//System.out.println(cartQuantity+"cartQuantity");
		int addressCode= Integer.parseInt(request.getParameter("addressCode"));
		//System.out.println(addressCode+"addressCode");
		//포인트 사용
		int usePoint = 0; //포인트 사용이 null이 아니고 공백이 아닐시 사용 했다면 usePoint에 받아온 값을 넣음
		if(request.getParameter("usePoint")!=null && request.getParameter("usePoint").equals("")!=true) {
			usePoint= Integer.parseInt(request.getParameter("usePoint"));
		}
		//총 가격에서 사용한 포인트 뺴기= 결제할 금액
		int orderPrice= Integer.parseInt(request.getParameter("orderPrice"))-usePoint;
		//service 불러오기
		this.orderService = new OrderService();
		this.customerService= new CustomerService();
		
		Cart cart= new Cart();
		cart.setGoodsCode(goodsCode);
		cart.setCustomerId(customerId);
		cart.setCartQuantity(cartQuantity);
		cart.setCartPrice(orderPrice);
		
		int result=orderService.insertPayment2Order(cart, addressCode, goodsCode);
		if(result==1){
			//포인트 사용
			
			//포인트 적립
			customerService.insertPointInCustomer(loginMember, orderPrice);
			customerService.insertPointInHistory(loginMember.getCustomerId(), orderPrice);
			if(usePoint!=0) {
				customerService.usePointUpdateCustomer(loginMember, usePoint);
				customerService.usePointInsertInHistory(loginMember.getCustomerId(), usePoint);
				
				loginMember.setPoint(loginMember.getPoint()-usePoint);
				request.getSession().setAttribute("loginMember", loginMember);
				//loginMemberupdate
				ArrayList<Cart> list = new ArrayList<Cart>();
				list.add(cart);
				//판매량 증가
				orderService.updategoodsHit(list);
			}
	
		}
		response.sendRedirect(request.getContextPath()+"/CompleteOrder2?result="+result+"&addressCode="+addressCode); //orderState로 보낼거 수정하기
	}	

}
