package questionController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import service.QuestionService;
import vo.Customer;
import vo.Question;

@WebServlet("/AddQuestion")
public class AddQuestionController extends HttpServlet {
	private QuestionService questionService;
	private OrderService orderService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}
		String customerId=loginMember.getCustomerId();
		this.orderService= new OrderService();
		request.setAttribute("customerId", customerId);
		ArrayList<HashMap<String, Object>> Qlist= orderService.selectOrderListByid(customerId);
		request.setAttribute("Qlist", Qlist);
		//System.out.println(Qlist);
		request.getRequestDispatcher("/WEB-INF/view/customer/addQuestion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//폼에서 받아오기
		request.setCharacterEncoding("utf-8");
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		//System.out.println(orderCode+"<==orderCode");
		String category=request.getParameter("category");
		//System.out.println(category+"<==category");
		String questionMemo=request.getParameter("questionMemo");
		//System.out.println(questionMemo+"<==questionMemo");
		String customerId=request.getParameter("customerId");
		//System.out.println(customerId+"<==customerId");
		
		Question q= new Question();
		q.setOrderCode(orderCode);
		q.setCategory(category);
		q.setQuestionMemo(questionMemo);
		q.setCustomerId(customerId);
		//service 불러오기
		this.questionService= new QuestionService();
		int result=questionService.insertQuestion(q);
		if(result==1) { //성공: 공지사항 추가 성공하면 questionList로 보낼거
			response.sendRedirect(request.getContextPath()+"/QuestionListByCustomer"); 
		}else { //실패: 실패하면 다시 addQuestion로 보낼거
			System.out.println("공지사항 추가 실패");
			response.sendRedirect(request.getContextPath()+"/AddQuestion"); 
		}
	}

}
