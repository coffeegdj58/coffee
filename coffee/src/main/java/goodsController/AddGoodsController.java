package goodsController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.GoodsService;
import vo.Category;
import vo.Emp;
import vo.Goods;



@WebServlet("/AddGoods")
public class AddGoodsController extends HttpServlet {
	private GoodsService goodsService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 직원이 아닐 경우 직원 로그인 페이지로 전환
		HttpSession session = request.getSession();
		if(session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		this.goodsService= new GoodsService();
		ArrayList<Category> list = goodsService.selectCategory();
		request.setAttribute("categorylist", list);
		
		request.getRequestDispatcher("/WEB-INF/view/goods/addGoods.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 직원이 아닐 경우 직원 로그인 페이지로 전환
		HttpSession session = request.getSession();
		if(session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath() + "/LoginEmp");
			return;
		}
		request.setCharacterEncoding("utf-8");
		this.goodsService= new GoodsService();
		
		Emp loginEmp = (Emp)session.getAttribute("loginEmp");
		String empId = loginEmp.getEmpId();
		// 피라미터 수집
		request.setCharacterEncoding("utf-8");
		String dir = request.getServletContext().getRealPath("/image");
		int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
		DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "utf-8", fp);
		
		String goodsName = mreq.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(mreq.getParameter("goodsPrice"));
		String soldout = mreq.getParameter("soldout");
		int categoryCode= Integer.parseInt(mreq.getParameter("categoryCode"));
		String goodsContent = mreq.getParameter("goodsContent");
		String goodsInfo = mreq.getParameter("goodsInfo");
		
	
		
		String filename = mreq.getFilesystemName("filename");
		// 저장된 이미지 파일 이름
		File f= new File(dir+"/"+filename);
		System.out.println(f);
		f.renameTo(new File(dir+"/"+goodsName+".jpg"));
		System.out.println(f);
		String contentType = mreq.getContentType("filename"); // 이미지 파일 검사
		
		if(contentType.equals("image/jpeg") || contentType.equals("image/png")) {
			// goods vo
			Goods goods = new Goods();
			goods.setGoodsName(goodsName);
			goods.setGoodsPrice(goodsPrice);
			goods.setSoldout(soldout);
			goods.setEmpId(empId);
			goods.setCategoryCode(categoryCode);
			goods.setGoodsContent(goodsContent);
			goods.setGoodsInfo(goodsInfo);
			goodsService.addGoods(goods, dir, empId);
		}
		response.sendRedirect(request.getContextPath() + "/CoffeeList");
	}
}
