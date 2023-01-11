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

                <a href="${pageContext.request.contextPath}/CustomerLogin" class="">login</a>
                <span class="mx-md-2 d-inline-block"></span>
                <a href="${pageContext.request.contextPath}/Logout" class="">logout</a>
                <span class="mx-md-2 d-inline-block"></span>
				<a href="${pageContext.request.contextPath}/CustomerPage">myPage</a>
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
                  <li><a href="${pageContext.request.contextPath}/QuestionListByEmp" class="nav-link">Question</a></li>
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