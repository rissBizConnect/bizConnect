<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 상세보기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    .header {
        text-align: center;
        padding: 20px;
        background-color: #f4f4f4;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }

    .content {
        margin: 0 auto;
        width: 80%;
    }

    .detail-view {
        border: 1px solid #ddd;
        padding: 20px;
        margin-bottom: 20px;
    }

    .detail-view h2 {
        margin-top: 0;
    }

    .detail-view .info {
        margin-bottom: 20px;
    }

    .detail-view .info span {
        display: inline-block;
        margin-right: 20px;
    }

    .detail-view .content-text {
        white-space: pre-line;
    }

    .btn-container {
        text-align: center;
    }

    .btn-container button {
        padding: 10px 20px;
        background-color: #007bff;
        border: none;
        color: white;
        cursor: pointer;
    }

    .btn-container button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="header">
    <h1>${support.supportTitle}</h1>
</div>

<div class="content">
    <h2>${support.supportTitle}</h2>
    <div class="info">
        <p>작성자: ${support.supportWriter}</p>
        <p>작성일: <fmt:formatDate value="${support.supportDate}" pattern="yyyy-MM-dd" /></p>
        <p>조회수: ${support.readCount}</p>
    </div>
    <div class="content-text">
        ${support.supportContent}
    </div>

    <div class="btn-container">
        <button onclick="location.href='/bizconnect/supportList.do'">목록</button>
    </div>
</div>


    <a href="supportList.do">목록으로</a>

    <!-- 관리자에게만 수정/삭제 버튼 노출 -->
    <c:if test="${loginUser != null && loginUser.userRole == 'developer'}">
        <a href="supportUpdate.do?no=${support.supportNo}">수정</a>
        <a href="supportDelete.do?no=${support.supportNo}">삭제</a>
    </c:if>

</body>
</html>