package commentController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommentService;
import service.QuestionService;
import vo.Emp;

@WebServlet("/RemoveComment")
public class RemoveCommentController extends HttpServlet {
	private CommentService commentService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 한 사람만 접근 가능+ 관리자
		//관리자만 접근 가능
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		//commentCode받아오기 : 답변을 삭제하기 위해
		int commentCode=Integer.parseInt(request.getParameter("commentCode"));
		//questionCode받아오기 : 답변이 삭제 되면 문의 사항에 flag 값을 N으로 변경하기 위해
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		//service 불러오기
		this.commentService= new CommentService();
		int result=commentService.removeComment(commentCode, questionCode);
		if(result==1) {//삭제 성공
			response.sendRedirect(request.getContextPath()+"/QuestionListByEmp");
		}else {//실패
			System.out.println("답변 삭제 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('답변 삭제 실패!'); location.href='"+request.getContextPath()+"/QuestionListByEmp"+"';</script>"); 
			writer.close();
		}	
	}

}
