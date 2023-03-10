package goodsController;

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
import service.ReviewService;
import vo.Cart;
import vo.Customer;
import vo.Goods;
import vo.Review;


@WebServlet("/GoodsOne")
public class GoodsOneController extends HttpServlet {
	private OrderService orderService;
    private GoodsService goodsService;
    private ReviewService reviewService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 피라미터 수집
    	HttpSession session = request.getSession();
		Customer loginMember = (Customer)session.getAttribute("loginMember");
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
    	this.orderService = new OrderService();
    	
    	// 서비스 호출
    	goodsService = new GoodsService();
    	Goods g = goodsService.getGoodsOne(goodsCode);
    	
    	
    	//top3제품 recommend
    	ArrayList<Goods> goodsList = goodsService.selectGoodsbyHit();
    	
    	request.setAttribute("goodsList", goodsList);
    	
    	
    	//리뷰
    	int currentPage=1;//1페이지부터 시작
    	if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
    	int rowPerPage=10;//10개씩 보여줄거
    	int beginRow=(currentPage-1)*rowPerPage; //0번부터 보여줄거
    	
    	this.reviewService= new ReviewService();
    	ArrayList<Review> Rlist=reviewService.selectReviewByGoodsPaging(goodsCode, beginRow, rowPerPage);
    	//jsp에서 <% %> 안쓰고 가져오게 하려고
    	request.setAttribute("Rlist", Rlist);
    	request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
    	
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
			response.sendRedirect(request.getContextPath()+"/CustomerLogin");
			return;
		}
    	this.orderService = new OrderService();

    	Cart c = new Cart();
    	c.setCartQuantity(cartQuantity);
    	c.setCustomerId(loginMember.getCustomerId());
    	c.setGoodsCode(goodsCode);
    	int result= orderService.insertCart(c);
    	int count = orderService.selectCountCart(loginMember.getCustomerId());
    	loginMember.setCustomerCart(count);
    	
    	request.getSession().setAttribute("loginMember", loginMember);
    	
    	
    	response.sendRedirect(request.getContextPath()+"/GoodsOne?result="+result+"&goodsCode="+goodsCode);
    	
    }

}
