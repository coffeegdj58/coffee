package goodsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import vo.Category;
import vo.Goods;


@WebServlet("/CoffeeList")
public class CoffeeListController extends HttpServlet {
	private GoodsService goodsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.goodsService = new GoodsService();
		
		ArrayList<Goods> list1= goodsService.getGoodsList(1);
		
		ArrayList<Goods> list2= goodsService.getGoodsList(2);

		ArrayList<Goods> list3= goodsService.getGoodsList(3);

		ArrayList<Goods> list4= goodsService.getGoodsList(4);
		ArrayList<Goods> list5= goodsService.getGoodsList(13);
		ArrayList<Goods> list6= goodsService.getGoodsList(14);
		ArrayList<Goods> list7= goodsService.getGoodsList(12);
		
		ArrayList<Category> list= goodsService.selectCategory();
		
		request.setAttribute("categoryList", list);
		
		request.setAttribute("blended", list1);
		request.setAttribute("coldbrew", list2);
		request.setAttribute("espresso", list3);
		request.setAttribute("frappuccino", list4);
		request.setAttribute("fizzio", list5);
		request.setAttribute("tea", list6);
		request.setAttribute("drink", list7);

		request.getRequestDispatcher("/WEB-INF/view/goods/coffeeList.jsp").forward(request, response);
		
	}


}
