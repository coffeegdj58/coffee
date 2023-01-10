<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "vo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<nav id="navbar" class="navbar">
		<c:if test="${loginMember==null || loginEmp==null}">
			<li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/Home">Home</a></li>
			<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerLogin">로그인하기</a></li>
			<!-- 나중에 위치 수정예정 -->
			<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/LoginEmp">관리자 로그인</a></li>
			<li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/NoticeList">공지사항</a></li>
		</c:if>
		<c:if test="${loginMember!=null}">
			<ul>
				<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CustomerPage">myPage</a></li>
      	 		<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/Logout">logOut</a></li>
			</ul>
		</c:if>
		<c:if test="${loginEmp!=null}">
			<ul>
				<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/EmpPage">사원관리</a>
				<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/CoffeeList">커피</a>
				<li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/Logout">logOut</a></li>
				
			</ul>
		</c:if>
      </nav>  
