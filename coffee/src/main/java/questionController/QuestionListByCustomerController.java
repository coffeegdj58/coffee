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

import service.CustomerService;
import service.OrderService;
import service.QuestionService;
import vo.Customer;
import vo.Question;

@WebServlet("/QuestionListByCustomer")
public class QuestionListByCustomerController extends HttpServlet {
	private QuestionService questionService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}
		String customerId=loginMember.getCustomerId();
		//service 불러오기
		this.questionService=new QuestionService();
		ArrayList<Question> list=questionService.selectQuestionById(customerId);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/questionListByCustomer.jsp").forward(request, response);
	}

}
