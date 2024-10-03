<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common/header.css?after">
<title>Bizconnect - 퇴직자 관리</title>
</head>
<body> 
	<ul class="menu">
		<h1>Bizconnect</h1>
		<nav class="login-mypage">
			<button onclick="goToMypage()">마이페이지</button>
			<button onclick="logout()">로그아웃</button>
		</nav>
		<hr>
		<div class="menu-sub">
			<a href="#" onclick="loadPage('인사관리')">인사관리</a> 
			<a href="#" onclick="loadPage('재고관리')">재고관리</a> 
			<a href="#" onclick="loadPage('회계관리')">회계관리</a>
		</div>
	</ul>
</body>
</html>
