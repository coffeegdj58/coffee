package goodsController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import vo.GoodsImg;

                                  
@WebServlet("/ModifyGoods")
public class ModifyGoodsController extends HttpServlet {
    private GoodsService goodsService;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 직원이 아닐 경우 직원 로그인 페이지로 전환
    	HttpSession session = request.getSession();
    	if(session.getAttribute("loginEmp") == null) {
    		response.sendRedirect(request.getContextPath() + "/LoginEmp");
    		return;
    	}
    	
    	// 피라미터 수집
    	if(request.getParameter("goodsCode") == null || ("").equals(request.getParameter("goodsCode"))) {
    		response.sendRedirect(request.getContextPath() + "/goodsList");
    		return;
    	}
    	int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
    	
    	// 서비스 호출
    	goodsService = new GoodsService();
    	ArrayList<Category> list = goodsService.selectCategory();
		request.setAttribute("categorylist", list);
    	
    	Goods m = goodsService.getGoodsOne(goodsCode);
    	
    	request.setAttribute("m", m);
    	
    	
    	request.getRequestDispatcher("/WEB-INF/view/goods/modifyGoods.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 직원이 아닐 경우 직원 로그인 페이지로 전환
    	HttpSession session = request.getSession();
    	if(session.getAttribute("loginEmp") == null) {
    		response.sendRedirect(request.getContextPath() + "/LoginEmp");
    		return;
    	}
    	int result=0;
    	// 피라미터 수집
    	request.setCharacterEncoding("utf-8");
    	String dir = request.getServletContext().getRealPath("/image");
    	int maxFileSize = 1024 * 1024 * 100; // 100Mbyte
    	DefaultFileRenamePolicy fp = new DefaultFileRenamePolicy();
    	MultipartRequest mreq = new MultipartRequest(request, dir, maxFileSize, "utf-8", fp);
    	
    	int goodsCode = Integer.parseInt(mreq.getParameter("goodsCode"));
    	String goodsName = mreq.getParameter("goodsName");
    	int goodsPrice = Integer.parseInt(mreq.getParameter("goodsPrice"));
    	String soldout = mreq.getParameter("soldout");
    	Emp loginEmp = (Emp)session.getAttribute("loginEmp");
    	String empId = loginEmp.getEmpId();
    	String goodsContent= mreq.getParameter("goodsContent");
    	String goodsInfo= mreq.getParameter("goodsInfo");
    	int categoryCode= Integer.parseInt(mreq.getParameter("categoryCode"));
    	String filename = mreq.getFilesystemName("filename"); // 저장된 이미지 파일 이름
    	
    	String contentType = mreq.getContentType("filename"); // 이미지 파일 검사
    	
    	if(contentType.equals("image/jpeg")) {
    		// goods vo
    		Goods goods = new Goods();
    		goods.setGoodsCode(goodsCode);
    		goods.setGoodsName(goodsName);
    		goods.setGoodsPrice(goodsPrice);
    		goods.setSoldout(soldout);
    		goods.setEmpId(empId);
    		goods.setGoodsContent(goodsContent);
    		goods.setGoodsInfo(goodsInfo);
    		goods.setCategoryCode(categoryCode);
    		
    		// service 호출
    		GoodsService goodsService = new GoodsService();
    		
    		File f= new File(dir+"/"+filename);
    		File oldf= new File(dir+"/"+goodsName+".jpg");
    		System.out.println(f);
    		System.out.println(oldf);
    		
    		// 수정 완료시 이전 이미지 파일 삭제		
    		if(oldf.exists()) {
    			oldf.delete();
    			System.out.println(oldf);
    		}
    		
    		f.renameTo(new File(dir+"/"+goodsName+".jpg"));
    		
    		result = goodsService.modifyGoods(goods, dir);
    	} else {
    		System.out.print("*.jpg, *.png 파일만 업로드 가능");
    		File f = new File(dir + "\\" + mreq.getFilesystemName("filename"));
    		if(f.exists()) {
    			f.delete();
    		}
    	}
    	response.sendRedirect(request.getContextPath() + "/GoodsOne?goodsCode="+goodsCode+"&result="+result);
    }
}
