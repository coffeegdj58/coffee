package questionController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;

@WebServlet("/QuestionListByCustomer")
public class QuestionListByCustomerController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 가능== 나중에 작성해야함
		String customerId="";
		
		//service 불러오기
		this.questionService=new QuestionService();
		ArrayList<Question> list=questionService.selectQuestionById(customerId);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/questionListByCustomer.jsp").forward(request, response);
	}

}
