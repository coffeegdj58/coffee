package questionController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.QuestionService;
import vo.Customer;
import vo.Question;


@WebServlet("/ModifyQuestion")
public class ModifyQuestionController extends HttpServlet {
	private QuestionService questionService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능
		HttpSession session=request.getSession();
		Customer loginMember=(Customer)session.getAttribute("loginMember");
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath() + "/CustomerLogin");
			return;
		}
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
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
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
			response.sendRedirect(request.getContextPath()+"/QuestionListByCustomer"); 
		}else { //실패: 실패하면 다시 modifyQuestion로 보낼거
			System.out.println("문의사항 수정 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('문의사항 수정 실패!'); location.href='"+request.getContextPath()+"/ModifyQuestion"+questionCode+"';</script>"); 
			writer.close();
		}
	}

}
