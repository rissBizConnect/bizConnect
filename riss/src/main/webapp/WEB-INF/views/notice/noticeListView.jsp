<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 게시판</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    .header {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        background-color: #f4f4f4;
        padding: 10px 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        position: relative;
    }

    .header button {
        padding: 10px 20px;
        background-color: #ffffff;
        border: 1px solid #ccc;
        cursor: pointer;
        font-weight: bold;
    }

    .sidebar {
        width: 220px;
        background-color: #f4f4f4;
        padding: 20px;
        box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        height: 100vh;
        float: left;
    }

    .sidebar ul {
        list-style-type: none;
        padding: 0;
    }

    .sidebar ul li {
        padding: 10px 0;
    }

    .sidebar ul li a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
    }

    .content {
        margin-left: 240px;
        padding: 20px;
    }

    .right-sidebar {
        width: 200px;
        background-color: #f9f9f9;
        position: fixed;
        top: 60px;
        right: 0;
        height: calc(100% - 60px);
        border-left: 1px solid #ddd;
        padding: 15px;
    }

    .right-sidebar ul {
        list-style: none;
        padding: 0;
    }

    .right-sidebar ul li {
        margin: 10px 0;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }

</style>
</head>
<body>

<!-- 상단 헤더 -->
<div class="header">
    <div class="profile-info">BizConnect</div>
    <button onclick="location.href='/bizconnect/menu.do'">전체메뉴</button>
</div>

<!-- 왼쪽 사이드바 -->
<div class="sidebar">
    <ul>
        <li><a href="/bizconnect/main.do">프로필 정보</a></li>
        <li><a href="/bizconnect/profileUpdate.do">개인정보 변경</a></li>
        <li><a href="/bizconnect/companyInfo.do">기업 등록 및 정보</a></li>
        <li><a href="/bizconnect/noticeList.do">고객센터</a></li>
    </ul>
</div>

<!-- 콘텐츠 영역 -->
<div class="content">
    <h1>고객센터 게시판</h1>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
            <th>중요도</th>
        </tr>
        <c:forEach var="notice" items="${list}">
            <tr>
                <td>${notice.noticeNo}</td>
                <td><a href="noticeDetail.do?no=${notice.noticeNo}">${notice.noticeTitle}</a></td>
                <td>${notice.noticeWriter}</td>
                <td>${notice.noticeDate}</td>
                <td>${notice.readCount}</td>
                <td>${notice.importance}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- 게시글 추가 버튼 -->
    <button onclick="location.href='/bizconnect/moveNoticeWrite.do'">게시글 추가</button>
</div>



</body>
</html>
