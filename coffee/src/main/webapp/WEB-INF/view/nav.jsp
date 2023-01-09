<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "vo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	


      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/HomeController">Home</a></li>
          <c:if test="${loginMember!=null}">
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerPageController">myPage</a></li></c:if>
           <c:if test="${loginMember==null}">
           <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerLoginController">로그인하기</a></li>	</c:if> 
           <c:if test="${loginMember!=null}">
          <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/LogoutController">logOut</a></li></c:if>
        </ul>
      </nav>  