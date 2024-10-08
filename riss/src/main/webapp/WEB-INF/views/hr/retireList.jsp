<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>퇴직자 목록</title>
</head>
<body>
<h1>퇴직자 목록</h1>
<table border="1">
    <tr>
        <th>퇴직자 사번</th>
        <th>유저 GID</th>
        <th>퇴사일</th>
        <th>비고</th>
        <th>총 근무일</th>
        <th>입사일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach var="retire" items="${retireList}">
        <tr>
            <td>${retire.retNo}</td>
            <td>${retire.gid}</td>
            <td>${retire.retDate}</td>
            <td>${retire.exitreason}</td>
            <td>${retire.retTotalDate}</td>
            <td>${retire.userEntryDate}</td>
            <td><a href="edit/${retire.retNo}">수정</a></td>
            <td><a href="delete/${retire.retNo}">삭제</a></td>
        </tr>
    </c:forEach>
</table>
<a href="add">퇴직자 추가</a> <!-- 퇴직자 추가 페이지로 이동 -->
</body>
</html>
