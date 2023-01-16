<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "vo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <div>
      <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>


      
        <div class="container">
          <div class="row">
            <div class="col-12">
            <div class="float-right">
           	 <form action="${pageContext.request.contextPath}/SearchGoods" method="get" id="search">

					<c:if test="${empty loginMember||empty loginEmp}">
	                	<a href="${pageContext.request.contextPath}/CustomerLogin" style="color:black">login</a>
	                </c:if>
	                
	                <span class="mx-md-2 d-inline-block"></span>
	                <a href="${pageContext.request.contextPath}/Logout" style="color:black">logout</a>
	                <span class="mx-md-2 d-inline-block"></span>
					<a href="${pageContext.request.contextPath}/CustomerPage" style="color:black">myPage</a>
					<span>&nbsp;&nbsp;&nbsp;</span>
					<span>
						<input type="text" name="word" placeholder="검색어를 입력해주세요" style="height: 40px; font-size: 15px; border: 0; border-radius: 15px; outline: none; padding-left: 10px; background-color: rgb(233, 233, 233);">
						<button type="submit" class="btn btn-outline-dark" ><img src="${pageContext.request.contextPath}/image/search.png"></button>
					</span>
				</form>
              </div>

            </div>

          </div>

        </div>
      

      <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

        <div class="container">
          <div class="row align-items-center position-relative">


            <div class="site-logo">
              <a href="${pageContext.request.contextPath}/Home" class="text-black"><img width= "150px" height="100px"src="${pageContext.request.contextPath}/image/navbar.png"></a>
              
            </div>

            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="${pageContext.request.contextPath}/Home" class="nav-link">Home</a></li>
                  <li><a href="${pageContext.request.contextPath}/CoffeeList" class="nav-link">Coffee</a></li>
                  <li><a href="${pageContext.request.contextPath}/BakeryList" class="nav-link">Bakery</a></li>
                  <li><a href="${pageContext.request.contextPath}/ProductList" class="nav-link">Product</a></li>
                  <li><a href="${pageContext.request.contextPath}/NoticeList">Notice</a></li>
                  <li><a href="${pageContext.request.contextPath}/QuestionListByCustomer" class="nav-link">Question</a></li>
                  <li><a href="${pageContext.request.contextPath}/CartList" class="nav-link">Cart</a></li>
                </ul>
              </nav>

            </div>

            <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

          </div>
        </div>
		
      </header>
      </div>
        <script src="${pageContext.request.contextPath}/bootstrap/nav/js/jquery-3.3.1.min.js"></script>
    	<script src="${pageContext.request.contextPath}/bootstrap/nav/js/popper.min.js"></script>
  	    <script src="${pageContext.request.contextPath}/bootstrap/nav/js/bootstrap.min.js"></script>
	    <script src="${pageContext.request.contextPath}/bootstrap/nav/js/jquery.sticky.js"></script>
	    <script src="${pageContext.request.contextPath}/bootstrap/nav/js/main.js"></script>