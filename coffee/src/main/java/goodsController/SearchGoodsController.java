package goodsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import vo.Goods;

/**
 * Servlet implementation class SearchGoodsController
 */
@WebServlet("/SearchGoods")
public class SearchGoodsController extends HttpServlet {
	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String word= request.getParameter("word");
		
		this.goodsService =new GoodsService();
		ArrayList<Goods> list = goodsService.searchGoodsList(word);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/goods/searchGoods.jsp").forward(request, response);
		
	}

	
}
