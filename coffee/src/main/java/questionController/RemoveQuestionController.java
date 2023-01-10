package questionController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;

@WebServlet("/RemoveQuestion")
public class RemoveQuestionController extends HttpServlet {
	private QuestionService questionService;

	//공지사항 삭제 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//noticeCode받아오기
		int questionCode=Integer.parseInt(request.getParameter("questionCode"));
		//service 불러오기
		this.questionService= new QuestionService();
		int result=questionService.deleteQuestion(questionCode);
		if(result==1) {//삭제 성공
			response.sendRedirect(request.getContextPath()+"/QuestionListByCustomer");
		}else {//실패
			System.out.println("문의사항 삭제 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('문의사항 삭제 실패!'); location.href='"+request.getContextPath()+"/QuestionListByCustomer"+"';</script>"); 
			writer.close();
		}
	}

}
