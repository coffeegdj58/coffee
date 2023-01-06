package goodsController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;


@WebServlet("/GoodsListController")
public class GoodsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService goodsService;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 서비스 호출
			goodsService = new GoodsService();
			ArrayList<HashMap<String, Object>> list = goodsService.getGoodsList();
			
			// 객체 바인딩 후 페이지 이동
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/view/goods/goodsList.jsp").forward(request, response);
		}
	}
