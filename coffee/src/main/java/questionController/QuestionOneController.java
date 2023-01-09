package questionController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import service.QuestionService;
import vo.Comment;
import vo.Question;

@WebServlet("/question/questionOne")
public class QuestionOneController extends HttpServlet {
	private QuestionService questionService;
	private CommentService commentService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//questionCode받아오기
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		//문의사항 세부 내용 service에서 가져오기
		this.questionService= new QuestionService();
		Question q=questionService.selectQuestionOne(questionCode);
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("q", q);
		
		//답변내용 service에서 가져오기
		this.commentService=new CommentService();
		Comment c=commentService.commentOne(questionCode); 
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/questionOne.jsp").forward(request, response);
	}

}
