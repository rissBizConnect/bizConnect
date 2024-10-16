<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체메뉴</title>
</head>
<body>
    <!-- 상단 마이페이지 버튼 -->
    <button id="myPageButton" onclick="window.location.href='/bizconnect/main.do'">마이페이지</button>

    <!-- 전체 메뉴 표시 -->
    <div id="menuContainer">
        <ul>
            <li><a href="moveAttendance.do">인사관리</a></li>
            <li><a href="/bizconnect/prManagement.do">재고관리</a></li>
        </ul>
    </div>
</body>
</html>
