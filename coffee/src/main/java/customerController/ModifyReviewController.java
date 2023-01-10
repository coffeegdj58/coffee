package customerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReviewService;
import vo.Review;

@WebServlet("/ModifyReview")
public class ModifyReviewController extends HttpServlet {
	private ReviewService reviewService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		int result=reviewService.updateReview(review);
		if(result==1) {
			System.out.println("리뷰 수정 성공");
			response.sendRedirect(request.getContextPath()+"/CustomerPage");
		}else {//실패
			System.out.println("리뷰 수정 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('리뷰 수정 실패!'); location.href='"+request.getContextPath()+"/ModifyReview"+"';</script>"); 
			writer.close();
		}
	}

}
