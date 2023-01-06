package questionController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;

@WebServlet("/question/addQuestion")
public class AddQuestionController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		request.getRequestDispatcher("/WEB-INF/view/customer/addQuestion.jsp").forward(request, response);
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
		int result=questionService.insertQuestion(q);
		if(result==1) { //성공: 공지사항 추가 성공하면 questionList로 보낼거
			response.sendRedirect(request.getContextPath()+"/customer/questionList"); 
		}else { //실패: 실패하면 다시 addQuestion로 보낼거
			System.out.println("공지사항 추가 실패");
			response.sendRedirect(request.getContextPath()+"/question/addQuestion"); 
		}
	}

}
