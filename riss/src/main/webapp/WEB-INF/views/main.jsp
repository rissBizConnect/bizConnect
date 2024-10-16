<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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

    .profile-photo {
        text-align: center;
        margin-bottom: 20px;
    }

    .profile-photo img {
        width: 120px;
        height: auto;
        border-radius: 50%;
    }

    .form-section {
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .profile-info {
        position: absolute;
        left: 20px;
        top: 10px;
        font-size: 20px;
        font-weight: bold;
    }

</style>
</head>
<body>

<div class="header">
    <!-- 프로필 정보를 왼쪽 상단으로 이동 -->
    <div class="profile-info">BizConnect</div>
    <button onclick="location.href='/bizconnect/menu.do'">전체메뉴</button>
</div>

<div class="sidebar">
    <div class="profile-photo">
        <img src="https://via.placeholder.com/120" alt="Profile Photo">
    </div>
    <ul>
        <li><a href="/bizconnect/main.do">프로필 정보</a></li>
        <li><a href="/bizconnect/profileUpdate.do">개인정보 변경</a></li>
        <li><a href="/bizconnect/companyInfo.do">기업 등록 및 정보</a></li>
        <li><a href="/bizconnect/noticeList.do">고객센터</a></li>
    </ul>
</div>

<div class="content">
    <!-- 마이페이지 내용 -->
    <div class="form-section">
        <table>
            <tr>
                <td>이름:</td>
                <td>${loginUser.userName}</td>
            </tr>
            <tr>
                <td>GID:</td>
                <td>${loginUser.gID}</td>
            </tr>
            <tr>
                <td>소속:</td>
                <td>${loginUser.comCode}</td>
            </tr>
            <tr>
                <td>역할:</td>
                <td>${loginUser.userRole}</td>
            </tr>
            <tr>
                <td>직무:</td>
                <td>${loginUser.userJob}</td>
            </tr>
            <tr>
                <td>입사일:</td>
                <td>${loginUser.userEntryDate}</td>
            </tr>
            <tr>
                <td>전화번호:</td>
                <td>${loginUser.userPhone}</td>
            </tr>
            <tr>
                <td>이메일:</td>
                <td>${loginUser.userEmail}</td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
