package questionController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;


@WebServlet("/question/modifyQuestion")
public class ModifyQuestionController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//questionCode받아오기
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		
		this.questionService= new QuestionService();
		Question q=questionService.selectQuestionOne(questionCode);
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("q", q);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/modifyQuestion.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼에서 받아오기
		request.setCharacterEncoding("utf-8");
		int orderCode=Integer.parseInt(request.getParameter("orderCode"));
		String category=request.getParameter("category");
		String questionMemo=request.getParameter("questionMemo");
		String customerId=request.getParameter("customerId");
		
		Question q= new Question();
		q.setOrderCode(orderCode);
		q.setCategory(category);
		q.setQuestionMemo(questionMemo);
		q.setCustomerId(customerId);
		//service 불러오기
		this.questionService= new QuestionService();
		int result=questionService.updateQuestion(q);
		if(result==1) { //성공: 문의사항 수정 성공하면 questionList로 보낼거
			response.sendRedirect(request.getContextPath()+"/customer/questionList"); 
		}else { //실패: 실패하면 다시 modifyQuestion로 보낼거
			System.out.println("문의사항 수정 실패");
			response.sendRedirect(request.getContextPath()+"/question/modifyQuestion"); 
		}
	}

}
