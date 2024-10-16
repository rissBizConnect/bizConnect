<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div class="header">
        <c:choose>
            <!-- 전체메뉴 페이지에서는 "마이페이지" 버튼 표시 -->
            <c:when test="${pageContext.request.requestURI == '/menu.do'}">
                <button onclick="location.href='/main.do'">마이페이지</button>
            </c:when>
            
            <!-- 마이페이지에서는 "전체메뉴" 버튼 표시 -->
            <c:when test="${pageContext.request.requestURI == '/main.do'}">
                <button onclick="location.href='/menu.do'">전체메뉴</button>
            </c:when>
        </c:choose>
    </div>
</body>
</html>
