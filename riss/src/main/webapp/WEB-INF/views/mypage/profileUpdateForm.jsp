<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>개인정보 수정</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        /* 전체 레이아웃 스타일 */
        .wrapper {
            display: flex;
            justify-content: flex-start;
            align-items: flex-start;
            width: 100%;
            min-height: 100vh;
        }

        /* 사이드바 스타일 */
        .sidebar {
            width: 250px;
            background-color: #343a40; /* 다크 그레이 */
            padding: 20px;
            height: 100vh;
            color: white;
        }

        .sidebar h3 {
            color: #ffc107; /* 노란색 로고 텍스트 */
            margin-bottom: 30px;
        }

        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 15px;
        }

        .sidebar ul li a {
            color: white;
            font-weight: bold;
            padding: 10px;
            display: block;
            text-decoration: none;
            border-radius: 5px;
        }

        .sidebar ul li a:hover {
            background-color: #495057;  /* 약간 밝은 회색 */
        }

        /* 콘텐츠 영역 스타일 */
        .content-wrapper {
            display: flex;
            justify-content: center;
            width: 100%;
        }

        .content {
            width: 100%;
            max-width: 1200px;
            padding: 20px;
            box-sizing: border-box;
        }

        /* 헤더 스타일 */
        .header {
            background-color: #ffffff;
            padding: 15px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
            display: flex;
            justify-content: flex-end;
            align-items: center;
        }

        /* 버튼 스타일 */
        .header button {
            background-color: #343a40; /* 사이드바와 동일한 다크 그레이 */
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
            margin-left: 10px;
        }

        .header button:hover {
            background-color: #495057; /* 약간 밝은 회색 */
        }

        /* 개인정보 수정 섹션 */
        .form-section {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            max-width: 800px;
            margin: 0 auto;
        }

        .form-section h2 {
            margin-bottom: 20px;
            color: #343a40;
        }

        .form-section label {
            font-weight: bold;
            display: block;
            margin-bottom: 10px;
        }

        .form-section input[type="text"],
        .form-section input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
        }

        .form-section button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-section button:hover {
            background-color: #495057;
        }
    </style>
</head>
<body>

<div class="wrapper">
    <!-- 사이드바 -->
    <div class="sidebar">
        <h3>ERP Connect</h3>
        <ul>
            <li><a href="/bizconnect/main.do">마이페이지</a></li>
            <li><a href="/bizconnect/profileUpdate.do">개인정보 변경</a></li>
            <li><a href="/bizconnect/companyInfo.do">기업 정보</a></li>
            <li><a href="/bizconnect/supportList.do">고객센터</a></li>
        </ul>
    </div>

    <!-- 콘텐츠와 헤더를 포함한 메인 콘텐츠 -->
    <div class="content-wrapper">
        <div class="content">
            <!-- 헤더 -->
            <div class="header">
                <button onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
                <button onclick="location.href='/bizconnect/logout.do'" class="btn">로그아웃</button>
            </div>

            <!-- 개인정보 수정 섹션 -->
            <div class="form-section">
                <h2>개인정보 수정</h2>
                <form action="/bizconnect/updateProfile.do" method="POST">
                    <label for="userName">이름:</label>
                    <input type="text" id="userName" name="userName" value="${loginUser.userName}" readonly>

                    <label for="comCode">회사명:</label>
                    <input type="text" id="comCode" name="comCode" value="${loginUser.comCode}" readonly>

                    <label for="userPhone">전화번호:</label>
                    <input type="text" id="userPhone" name="userPhone" value="${loginUser.userPhone}" readonly>

                    <label for="userEmail">이메일:</label>
                    <input type="text" id="userEmail" name="userEmail" value="${loginUser.userEmail}">

                    <label for="userCard">계좌번호:</label>
                    <input type="text" id="userCard" name="userCard" value="${loginUser.userCard}">

                    <label for="userAddr">주소:</label>
                    <input type="text" id="userAddr" name="userAddr" value="${loginUser.userAddr}">

                    <label for="oldPW">이전 비밀번호:</label>
                    <input type="password" id="oldPW" name="oldPW" required>

                    <label for="newPW">신규 비밀번호:</label>
                    <input type="password" id="newPW" name="newPW">

                    <label for="confirmPW">신규 비밀번호 확인:</label>
                    <input type="password" id="confirmPW" name="confirmPW">

                    <button type="submit">저장</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
