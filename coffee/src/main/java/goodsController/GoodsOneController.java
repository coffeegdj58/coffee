package goodsController;

import java.io.IOException;

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


@WebServlet("/GoodsOne")
public class GoodsOneController extends HttpServlet {
	private OrderService orderService;
    private GoodsService goodsService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 피라미터 수집
    	if(request.getParameter("goodsCode") == null || ("").equals(request.getParameter("goodsCode"))) {
    		response.sendRedirect(request.getContextPath() + "/CoffeeList");
    		return;
    	}
    	int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
    	String result = null;
    	
    	if(request.getParameter("result")!=null) {
    		result = request.getParameter("result");
    	}
    	request.setAttribute("result", result);
    	
    	// 서비스 호출
    	goodsService = new GoodsService();
    	Goods g = goodsService.getGoodsOne(goodsCode);
    	
    	// 객체 바인딩 후 페이지 이동
    	request.setAttribute("g", g);
    	request.getRequestDispatcher("/WEB-INF/view/goods/goodsOne.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
		int goodsCode= Integer.parseInt(request.getParameter("goodsCode"));
		int cartQuantity= Integer.parseInt(request.getParameter("cartQuantity"));
		
		if(loginMember ==null) {
			response.sendRedirect(request.getContextPath()+"/GoodsOne?goodsCode="+goodsCode);
			return;
		}
    	this.orderService = new OrderService();
    	Cart c = new Cart();
    	c.setCartQuantity(cartQuantity);
    	c.setCustomerId(loginMember.getCustomerId());
    	c.setGoodsCode(goodsCode);
    	
    	int result= orderService.insertCart(c);
    	response.sendRedirect(request.getContextPath()+"/GoodsOne?result="+result+"&goodsCode="+goodsCode);
    	
    }

}
