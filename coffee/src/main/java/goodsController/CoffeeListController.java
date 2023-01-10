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


@WebServlet("/CoffeeListController")
public class CoffeeListController extends HttpServlet {
	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.goodsService = new GoodsService();
		
		ArrayList<Goods> list1= goodsService.getGoodsList(1);
		
		ArrayList<Goods> list2= goodsService.getGoodsList(2);

		ArrayList<Goods> list3= goodsService.getGoodsList(3);

		ArrayList<Goods> list4= goodsService.getGoodsList(4);
		
		request.setAttribute("blended", list1);
		request.setAttribute("coldebrew", list2);
		request.setAttribute("espresso", list3);
		request.setAttribute("frappuccino", list4);

		request.getRequestDispatcher("/WEB-INF/view/goods/coffeeList.jsp").forward(request, response);
		
	}


}