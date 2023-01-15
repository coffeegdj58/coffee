package customerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReviewService;

@WebServlet("/RemoveReview")
public class RemoveReviewController extends HttpServlet {
	private ReviewService reviewService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//orderCode받아오기	
	int orderCode=Integer.parseInt(request.getParameter("orderCode"));
	
	//service 불러오기
	this.reviewService=new ReviewService();
	int result=reviewService.deleteReview(orderCode);
	if(result==1) {
		System.out.println("리뷰 삭제 성공");

		response.sendRedirect(request.getContextPath()+"/AddReview?orderCode="+orderCode);
		return;
	}else {//실패
		System.out.println("리뷰 삭제 실패");
		//서블릿에서 알림창 띄우기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('리뷰 삭제 실패!'); location.href='"+request.getContextPath()+"/RemoveReview?orderCode="+orderCode+"'; return; </script>"); 
		writer.close();
	}

	}

}
