<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bizconnect - 퇴직자 관리</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>">
    <script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
</head>
<body>
    <header>
        <h1>Bizconnect 퇴직자 관리 시스템</h1>
        <nav>
            <ul>
                <li><a href="<c:url value='/retiree/list'/>">퇴직자 목록</a></li>
                <li><a href="<c:url value='/retiree/form'/>">퇴직자 추가</a></li>
                <li><a href="<c:url value='/index'/>">홈</a></li>
            </ul>
        </nav>
    </header>
>