<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/menubar.css">
  	<script src="${pageContext.request.contextPath}/resources/js/hr.js" charset="utf-8"></script>
    <title>Bizconnect - 퇴직자 관리</title>
</head>
<body>
	<aside>
	    <nav>
	        <ul class="side-menu">
	            <li><a href="#">인사 관리</a></li>
	            <li class="has-submenu" id="attendance">
	                <a href="#" onclick="toggleSubmenu('attendance')">근태관리</a>
	                <ul class="submenu" id="attendance-submenu">
	                    <li><a href="#" onclick="loadPage('출퇴근 근태')">출퇴근 근태</a></li>
	                    <li><a href="#" onclick="loadPage('연차')">연차</a></li>
	                </ul>
	            </li>
	            <li><a href="#" onclick="loadPage('사원명')">사원명부</a></li>
	            <li class="has-submenu" id="salary">
	                <a href="#" onclick="toggleSubmenu('salary')">급여관리</a>
	                <ul class="submenu" id="salary-submenu">
	                    <li><a href="#" onclick="loadPage('급여')">급여</a></li>
	                </ul>
	            </li>
	            <li class="has-submenu" id="retiree">
	                <a href="#" onclick="toggleSubmenu('retiree')">퇴직자관리</a>
	                <ul class="submenu" id="retiree-submenu">
	                    <li><a href="#" onclick="loadPage('퇴직자')">퇴직자</a></li>
	                    <li><a href="#" onclick="loadPage('퇴직자->사원')">퇴직자 -> 사원</a></li>
	                </ul>
	            </li>
	            <li class="has-submenu" id="document">
	                <a href="#" onclick="toggleSubmenu('document')">서류관리</a>
	                <ul class="submenu" id="document-submenu">
	                    <li><a href="#" onclick="loadPage('계약서')">계약서</a></li>
	                    <li><a href="#" onclick="loadPage('증명서')">증명서</a></li>
	                </ul>
	            </li>
	        </ul>
	    </nav>
	</aside>
</body>
</html>