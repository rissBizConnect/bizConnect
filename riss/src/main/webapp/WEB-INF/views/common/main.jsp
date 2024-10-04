<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/click.css?after">
	<script src="${pageContext.request.contextPath}/resources/js/click.js" charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
    <main id="content">
        <section class="dashboard">
            <h2>주요 관리 항목</h2>
            <div class="main-categories">
                <div class="category">
                    <h3><a href="#">인사관리</a></h3>
                    <ul class="sub-categories">
                        <li><a href="#" onclick="loadPage('근태관리')">근태관리</a></li>
                        <li><a href="#" onclick="loadPage('퇴직자관리')">퇴직자관리</a></li>
                        <li><a href="#" onclick="loadPage('서류관리')">서류관리</a></li>
                        <li><a href="#" onclick="loadPage('사원명부')">사원명부</a></li>
                        <li><a href="#" onclick="loadPage('급여관리')">급여관리</a></li>
                        <li><a href="#" onclick="loadPage('비용처리')">비용처리</a></li>
                    </ul>
                </div>
                <div class="category">
                    <h3><a href="#">재고관리</a></h3>
                    <ul class="sub-categories">
                        <li><a href="#" onclick="loadPage('발주관리')">발주관리</a></li>
                        <li><a href="#" onclick="loadPage('수주관리')">수주관리</a></li>
                        <li><a href="#" onclick="loadPage('거래처관리')">거래처관리</a></li>
                    </ul>
                </div>
                <div class="category">
                    <h3><a href="#">회계관리</a></h3>
                    <ul class="sub-categories">
                        <li><a href="#" onclick="loadPage('매출보고서')">매출보고서</a></li>
                        <li><a href="#" onclick="loadPage('매출관리')">매출관리</a></li>
                    </ul>
                </div>
            </div>
        </section>
    </main>
</div>
</body>
</html>