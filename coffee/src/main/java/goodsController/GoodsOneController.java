package goodsController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;


@WebServlet("/GoodsOneController")
public class GoodsOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private GoodsService goodsService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 피라미터 수집
    	if(request.getParameter("goodsCode") == null || ("").equals(request.getParameter("goodsCode"))) {
    		response.sendRedirect(request.getContextPath() + "/goodsList");
    		return;
    	}
    	int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
    	
    	// 서비스 호출
    	goodsService = new GoodsService();
    	HashMap<String, Object> m = goodsService.getGoodsOne(goodsCode);
    	
    	// 객체 바인딩 후 페이지 이동
    	request.setAttribute("m", m);
    	request.getRequestDispatcher("/WEB-INF/view/goods/goodsOne.jsp").forward(request, response);
    }

}
