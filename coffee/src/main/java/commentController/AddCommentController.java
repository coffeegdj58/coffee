package commentController;

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

@WebServlet("/comment/addComment")
public class AddCommentController extends HttpServlet {
	private QuestionService questionService;
	private CommentService commentService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자만 접근 가능
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
		String commentMemo=request.getParameter("commentMemo");
		
		Comment comment=new Comment();
		comment.setCommentMemo(commentMemo);
		
		this.commentService=new CommentService();
		int row=commentService.addComment(comment);
		if(row==1) { //성공: 답변 추가 성공하면 questionList로 보낼거
			response.sendRedirect(request.getContextPath()+"/emp/questionList"); 
		}else { //답변: 실패하면 다시 addComment로 보낼거
			System.out.println("답변 추가 실패");
			response.sendRedirect(request.getContextPath()+"/comment/addComment"); 
		}
	}

}
