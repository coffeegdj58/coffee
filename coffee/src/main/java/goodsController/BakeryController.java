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
 * Servlet implementation class BakeryController
 */
@WebServlet("/BakeryList")
public class BakeryController extends HttpServlet {
	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.goodsService = new GoodsService();
		
		ArrayList<Goods> list1= goodsService.getGoodsList(5);
		
		ArrayList<Goods> list2= goodsService.getGoodsList(6);

		ArrayList<Goods> list4= goodsService.getGoodsList(7);
		ArrayList<Goods> list3= goodsService.getGoodsList(11);
		
		request.setAttribute("bread", list1);
		request.setAttribute("cake", list2);
		request.setAttribute("sandwich", list4);
		request.setAttribute("pudding", list3);
		request.getRequestDispatcher("/WEB-INF/view/goods/bakeryList.jsp").forward(request, response);
		
	}
}
