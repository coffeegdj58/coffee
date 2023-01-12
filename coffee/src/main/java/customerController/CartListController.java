package customerController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GoodsService;
import service.OrderService;
import vo.Cart;
import vo.Customer;
import vo.Goods;

/**
 * Servlet implementation class CartListController
 */
@WebServlet("/CartList")
public class CartListController extends HttpServlet {
	
	private OrderService orderservice;
	private GoodsService goodsService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/Home");
			return;
		}
		
		this.orderservice = new OrderService();
		ArrayList<Cart> list = orderservice.selectCartListbyId(loginMember.getCustomerId());
		//cartlist
		request.setAttribute("cartList", list);
		
		this.goodsService= new GoodsService();
		ArrayList<Goods> goodsList = goodsService.selectGoodsbyHit();
		
		request.setAttribute("goodsList", goodsList);
		
		//총가격
		int sum = orderservice.selectSumGoodsPrice(loginMember.getCustomerId());
		
		request.setAttribute("sum", sum);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/cartList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		int selected= 0;
		int goodsCode= Integer.parseInt(request.getParameter("goodsCode"));
		if(request.getParameter(goodsCode+"")!=null) {
			selected = 1;
		}
		this.orderservice = new OrderService();
		System.out.println(selected);
		System.out.println(goodsCode);
		int result =orderservice.updateSelectOne(loginMember.getCustomerId(), selected, goodsCode);
		
		
		response.sendRedirect(request.getContextPath()+"/CartList?reult="+result);
	}

}
