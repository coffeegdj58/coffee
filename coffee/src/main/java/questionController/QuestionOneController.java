package questionController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;

@WebServlet("/question/questionOne")
public class QuestionOneController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//questionCode받아오기
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		
		this.questionService= new QuestionService();
		Question q=questionService.selectQuestionOne(questionCode);
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("q", q);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/questionOne.jsp").forward(request, response);
	}

}
