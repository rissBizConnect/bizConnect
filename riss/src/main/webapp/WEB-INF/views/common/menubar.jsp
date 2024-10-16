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
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendanceUpdateM.do'; return false;">근태 수정/현황</a></li>
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveAttendanceCheck.do'; return false;">연차</a></li>
	                </ul>
	            </li>
	            <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveInfo.do'; return false;">사원명부</a></li>
	            <li class="has-submenu" id="salary">
	                <a href="#" onclick="toggleSubmenu('salary'); return false;">급여관리</a>
	                <ul class="submenu" id="salary-submenu">
	                    <li><a href="#" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveSalary.do'; return false;">급여</a></li>
	                </ul>
	            </li>
	            
	            <li class="has-submenu" id="retire">
	                <a href="#" onclick="toggleSubmenu('retire'); return false;">퇴직자관리</a>
	                <ul class="submenu" id="retire-submenu">
	                   	<li><a href="retList.do?page=1">퇴직자</a></li>
	                </ul>
	            </li>
	            <li class="has-submenu" id="document">
	                <a href="#" onclick="toggleSubmenu('document'); return false;">서류관리</a>
	                <ul class="submenu" id="document-submenu">
	                    <li><a href="conList.do?page=1">계약서</a></li>
	                    <li><a href="cerList.do?page=1">증명서</a></li>
	                </ul>
	            </li>
	        </ul>
	    </nav>
	</aside>
</body>
</html>