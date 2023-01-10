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
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductList")
public class ProductController extends HttpServlet {

	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.goodsService = new GoodsService();
		
		
		
		ArrayList<Goods> list2= goodsService.getGoodsList(8);

		ArrayList<Goods> list3= goodsService.getGoodsList(9);

		ArrayList<Goods> list4= goodsService.getGoodsList(10);
		
		
		request.setAttribute("mug", list2);
		request.setAttribute("glass", list3);
		request.setAttribute("tumbler", list4);

		request.getRequestDispatcher("/WEB-INF/view/goods/CoffeeList.jsp").forward(request, response);
		
	}

}
