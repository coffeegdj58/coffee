<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "vo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	


      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/Home">Home</a></li>
          <c:if test="${loginMember!=null}">
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerPage">myPage</a></li></c:if>
           <c:if test="${loginMember==null || loginEmp==null}">
           <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerLogin">로그인하기</a></li>	</c:if> 
           <c:if test="${loginMember!=null || loginEmp!=null}">
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/Logout">logOut</a></li></c:if>
        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CoffeeList">커피</a>
        </ul>
      </nav>  
