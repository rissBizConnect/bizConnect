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
	                <a href="#" onclick="toggleSubmenu('attendance'); return false;" >근태관리</a>
	                <ul class="submenu" id="attendance-submenu">
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendance.do'; return false;">출퇴근</a></li>
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendanceCheck.do'; return false;">나의 근태현황</a></li>
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendanceCheckM.do'; return false;">근태 수정/현황</a></li>
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendanceCheck.do'; return false;">연차</a></li>
	                </ul>
	            </li>
	            <li><a href="#" onclick="loadPage('사원명'); return false;">사원명부</a></li>
	            <li class="has-submenu" id="salary">
	                <a href="#" onclick="toggleSubmenu('salary'); return false;">급여관리</a>
	                <ul class="submenu" id="salary-submenu">
	                    <li><a href="#" onclick="loadPage('급여'); return false;">급여</a></li>
	                </ul>
	            </li>
	            
	            <li class="has-submenu" id="retiree">
	                <a href="#" onclick="toggleSubmenu('retiree'); return false;">퇴직자관리</a>
	                <ul class="submenu" id="retiree-submenu">
	                   	<li><a href="${pageContext.request.contextPath}/retire.do">퇴직자</a></li>
	                    <li><a href="${pageContext.request.contextPath}/convertPage.do" onclick="loadPage('퇴직자->사원'); return=false;">퇴직자 -> 사원</a></li>
	                </ul>
	            </li>
	            <li class="has-submenu" id="document">
	                <a href="#" onclick="toggleSubmenu('document'); return false;">서류관리</a>
	                <ul class="submenu" id="document-submenu">
	                    <li><a href="#" onclick="loadPage('계약서'); return false;">계약서</a></li>
	                    <li><a href="#" onclick="loadPage('증명서'); return false;">증명서</a></li>
	                </ul>
	            </li>
	        </ul>
	    </nav>
	</aside>
</body>
</html>