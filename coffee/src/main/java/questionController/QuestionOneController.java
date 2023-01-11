package questionController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommentService;
import service.QuestionService;
import vo.Comment;
import vo.Customer;
import vo.Emp;
import vo.Question;

@WebServlet("/QuestionOne")
public class QuestionOneController extends HttpServlet {
	private QuestionService questionService;
	private CommentService commentService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원과 관리자 모두가 볼 수 있게 
		//답변 추가는 관리자 로그인한 사람만 가능하게 할 것
		HttpSession session=request.getSession();
		Customer loginMember= (Customer)session.getAttribute("loginMember");
		
		Emp loginEmp=(Emp)session.getAttribute("loginEmp");
		
		request.setAttribute("loginEmp", loginEmp);
		
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
