package goodsController;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GoodsService;


@WebServlet("/RemoveGoods")
public class RemoveGoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsService goodsService;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 직원이 아닐 경우 직원 로그인 페이지로 전환
    	HttpSession session = request.getSession();
    	if(session.getAttribute("loginEmp") == null) {
    		response.sendRedirect(request.getContextPath() + "/LoginEmp");
    		return;
    	}
    	
    	// 피라미터 수집
    	if(request.getParameter("goodsCode") == null || ("").equals(request.getParameter("goodsCode")) || request.getParameter("filename") == null || ("").equals(request.getParameter("filename"))) {
    		response.sendRedirect(request.getContextPath() + "/CoffeeList");
    		return;
    	}
    	int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
    	String dir = request.getServletContext().getRealPath("/upload");
    	String filename = request.getParameter("filename");
    	
    	// 서비스 호출
    	goodsService = new GoodsService();
    	int result = goodsService.removeGoods(goodsCode);
    	
    	if(result == 1) {
    		File f = new File(dir + "\\" + filename);
    		if(f.exists()) {
    			f.delete();
    		}
    	} else {
    		System.out.println("삭제 실패");
    	}
    	
    	// 페이지 이동
    	response.sendRedirect(request.getContextPath() + "/CoffeeList");
    }

}
