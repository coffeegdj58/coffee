package customerController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import service.ReviewService;
import vo.Customer;
import vo.Review;

@WebServlet("/AddReview")
public class AddReviewController extends HttpServlet {
	private ReviewService reviewService;
	//리뷰 추가 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}
		String customerId=loginMember.getCustomerId();
		
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		int goodsCode=Integer.parseInt(request.getParameter("goodsCode"));
		request.setAttribute("orderCode", orderCode);
		request.setAttribute("goodsCode", goodsCode);
		
		//service에서 불러오기
		this.reviewService=new ReviewService();
		ArrayList<Review> Rlist=reviewService.selectReviewById(customerId);
		request.setAttribute("Rlist", Rlist);
		//System.out.println(Rlist);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/addReview.jsp").forward(request, response);

	}
	//리뷰 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//폼에서 받아오기
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		int goodsCode=Integer.parseInt(request.getParameter("goodsCode"));
		String reviewMemo=request.getParameter("reviewMemo");
		String customerId=request.getParameter("customerId");
		int rating=Integer.parseInt(request.getParameter("rating"));
		
		Review review= new Review();
		review.setOrderCode(orderCode);
		review.setGoodsCode(goodsCode);
		review.setReviewMemo(reviewMemo);
		review.setCustomerId(customerId);
		review.setRating(rating);
		
		//service 불러오기
		this.reviewService= new ReviewService();
		int result=reviewService.insertReviewByCustomer(review);
		if(result==1) {
			System.out.println("리뷰 작성 성공");
			response.sendRedirect(request.getContextPath()+"/CustomerPage");
		}else {//실패
			System.out.println("리뷰 작성 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('리뷰 작성 실패!'); location.href='"+request.getContextPath()+"/AddReview"+"';</script>"); 
			writer.close();
		}
	}

}
