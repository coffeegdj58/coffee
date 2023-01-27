package customerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ReviewService;
import vo.Customer;

@WebServlet("/RemoveReview")
public class RemoveReviewController extends HttpServlet {
	private ReviewService reviewService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}
		String customerId=loginMember.getCustomerId();
	//orderCode받아오기	
	int goodsCode=Integer.parseInt(request.getParameter("goodsCode"));
	//System.out.println(goodsCode+"<==goodsCode");
	int orderCode=Integer.parseInt(request.getParameter("orderCode"));
	//service에서 불러오기
	this.reviewService=new ReviewService();
	int result=reviewService.deleteReview(goodsCode);
	if(result==1) {
		System.out.println("리뷰 삭제 성공");
		//서블릿에서 알림창 띄우기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('리뷰 삭제 성공'); location.href='"+request.getContextPath()+"/CustomerPage"+"';</script>"); 
		writer.close();
		return;
	}else {//실패
		System.out.println("리뷰 삭제 실패");
		//서블릿에서 알림창 띄우기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('리뷰 삭제 실패!'); location.href='"+request.getContextPath()+"/AddReview?goodsCode="+goodsCode+"'; return; </script>"); 
		writer.close();
	}

	}

}
