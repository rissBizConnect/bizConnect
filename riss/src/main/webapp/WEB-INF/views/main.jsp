<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        justify-content: flex-end; /* Aligns the content to the right */
        align-items: center;
        background-color: #f4f4f4;
        padding: 10px 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
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
        height: 100vh; /* Full height */
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
        margin-left: 240px; /* Leaves space for the sidebar */
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

</style>
</head>
<body>

<div class="header">
    <!-- 전체메뉴 버튼 (상단 오른쪽에 배치됨) -->
    <button onclick="location.href='/bizconnect/menu.do'">전체메뉴</button>
</div>

<div class="sidebar">
    <div class="profile-photo">
        <!-- Placeholder for profile photo -->
        <img src="https://via.placeholder.com/120" alt="Profile Photo">
    </div>
    <ul>
        <li><a href="#">프로필 정보</a></li>
        <li><a href="#">개인정보 변경</a></li>
        <li><a href="#">기업 등록 및 정보</a></li>
        <li><a href="#">고객센터</a></li>
    </ul>
</div>

<div class="content">
    <!-- Main content area -->
    <h1>마이페이지</h1>
    <div class="form-section">
        <!-- Form content goes here -->
        <table>
            <tr>
                <td>이름:</td>
                <td>홍길동</td>
            </tr>
            <tr>
                <td>소속:</td>
                <td>기획팀</td>
            </tr>
            <tr>
                <td>직위:</td>
                <td>부장</td>
            </tr>
            <!-- Add other fields as necessary -->
        </table>
    </div>
</div>

</body>
</html>
