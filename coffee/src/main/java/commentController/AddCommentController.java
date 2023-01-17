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
import vo.Comment;
import vo.Emp;
import vo.Question;

@WebServlet("/AddComment")
public class AddCommentController extends HttpServlet {
	private QuestionService questionService;
	private CommentService commentService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자만 접근 가능
		HttpSession session=request.getSession();
		Emp loginEmp=(Emp)session.getAttribute("loginEmp"); //현재 로그인 한 사람
		//방어코드 : 로그인 된 값이 없으면 로그인페이지로 보냄
		if (session.getAttribute("loginEmp") == null) { 
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		//문의사항 세부 내용 service에서 가져오기 문의 내용 보면서 답변 작성하기 위함
		this.questionService= new QuestionService();
		Question q=questionService.selectQuestionOne(questionCode);
		//jsp에서 <% %> 안쓰고 가져오게 하려고
		request.setAttribute("q", q);
		request.getRequestDispatcher("/WEB-INF/view/emp/addQuestionComment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//폼에서 받아오기
		String commentMemo=request.getParameter("commentMemo");
		//System.out.println(commentMemo+"<==commentMemo");
		int	questionCode=Integer.parseInt(request.getParameter("questionCode"));
		//System.out.println(questionCode+"<==questionCode");
		
		Comment comment=new Comment();
		comment.setCommentMemo(commentMemo);
		comment.setQuestionCode(questionCode);
		//service 불러오기
		this.commentService=new CommentService();
		int row=commentService.addComment(comment);
		if(row==1) { //성공: 답변 추가 성공하면 questionList로 보낼거
			response.sendRedirect(request.getContextPath()+"/QuestionListByEmp"); 
		}else { //답변: 실패하면 다시 addComment로 보낼거
			System.out.println("답변 추가 실패");
			//서블릿에서 알림창 띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('답변 추가 실패!'); location.href='"+request.getContextPath()+"/AddComment"+"';</script>"); 
			writer.close();
		}
	}

}
