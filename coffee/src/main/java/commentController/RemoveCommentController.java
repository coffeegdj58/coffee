package commentController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import service.QuestionService;

@WebServlet("/RemoveComment")
public class RemoveCommentController extends HttpServlet {
	private CommentService commentService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//commentCode받아오기
		int commentCode=Integer.parseInt(request.getParameter("commentCode"));
		//service 불러오기
		this.commentService= new CommentService();
		int result=commentService.removeComment(commentCode);
		if(result==1) {//삭제 성공
			response.sendRedirect(request.getContextPath()+"/QuestionListByEmp");
		}else {//실패
			System.out.println("답벼ㅑㄴ 삭제 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('답변 삭제 실패!'); location.href='"+request.getContextPath()+"/QuestionListByEmp"+"';</script>"); 
			writer.close();
		}	
	}

}
