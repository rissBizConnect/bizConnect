<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴직자 목록</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
    }
    h1 {
        text-align: center;
    }
    form {
        text-align: center;
        margin-bottom: 20px;
    }
    input[type="text"], input[type="date"], select {
        padding: 10px;
        margin: 5px;
        width: 200px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        padding: 10px 20px;
        margin: 5px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    .action-link {
        text-decoration: none;
        color: #007BFF;
        font-weight: bold;
    }
    .action-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<h1>퇴직자 목록</h1>

<form action="allRetirees.do" method="get">
    <input type="text" name="retNo" placeholder="퇴직자 사번 필터">
    <input type="date" name="entryDate" placeholder="입사일 필터">
    <input type="date" name="retDate" placeholder="퇴사일 필터">
    <select name="retType">
        <option value="">고용형태 선택</option>
        <option value="정규직">정규직</option>
        <option value="계약직">계약직</option>
        <!-- 다른 고용형태 추가 -->
    </select>
    <button type="submit">필터링</button>
</form>

<table>
    <thead>
        <tr>
            <th>퇴직자 사번</th>
            <th>고용형태</th>
            <th>퇴사일</th>
            <th>기타</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${retireList}" var="retire">
            <tr>
                <td>${retire.retNo}</td>
                <td>${retire.retType}</td>
                <td><fmt:formatDate value="${retire.retDate}" pattern="yyyy-MM-dd" /></td>
                <td><!-- 기타 정보 --></td>
                <td><a class="action-link" href="#" onclick="updateRetire('${retire.retNo}')">수정</a></td>
                <td><a class="action-link" href="/retire/delete/${retire.retNo}">삭제</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- 페이징 처리 -->
<div>
    <c:if test="${paging.startPage > 1}">
        <a class="action-link" href="${paging.allRetirees.do}?currentPage=1">첫 페이지</a>
    </c:if>
    
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="pageNum">
        <c:choose>
            <c:when test="${pageNum == paging.currentPage}">
                <span>${pageNum}</span>
            </c:when>
            <c:otherwise>
                <a class="action-link" href="${paging.urlMapping}?currentPage=${pageNum}">${pageNum}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
    <c:if test="${paging.endPage < paging.maxPage}">
        <a class="action-link" href="${paging.urlMapping}?currentPage=${paging.maxPage}">마지막 페이지</a>
    </c:if>
</div>

</body>
</html>
