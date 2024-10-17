<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>개발자 대시보드</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #f4f4f4;
            padding: 10px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            position: relative;
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

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        .form-section {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function showUserDetails(userId) {
            $.get("/developer/viewUserDetails.do", { gId: selectedUser }, function(data) {
                $("#gId").text(data.gId);
                $("#comCode").text(data.comCode);
                $("#userName").text(data.userName);
                $("#userJob").text(data.userJob);
                $("#userPhone").text(data.userPhone);
                $("#userEmail").text(data.userEmail);
                $("#userAddr").text(data.userAddr);
                $("#userEntry").text(data.userEntry);
            });
        }
    </script>
</head>
<body>

<div class="header">
    <div class="profile-info">개발자 대시보드</div>
    <button onclick="location.href='/bizconnect/logout.do'" style="background-color: #f44336; color: white; border: none; padding: 10px; cursor: pointer;">로그아웃</button>
</div>

<div class="sidebar">
    <ul>
        <li><a href="#">사용자 목록</a></li>
        <li><a href="/bizconnect/supportList.do">고객센터</a></li>
    </ul>
</div>

<div class="content">
    <h2>사용자 목록</h2>
    <table>
        <thead>
            <tr>
                <th>선택</th>
                <th>No</th>
                <th>아이디</th>
                <th>이름</th>
                <th>회사명</th>
                <th>전화번호</th>
                <th>이메일</th>
                <th>주소</th>
                <th>가입일</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty userList}">
                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr onclick="showUserDetails('${user.gId}')">
                        <td><input type="radio" name="selectedUser" value="${user.gId}"></td>
                        <td>${status.index + 1}</td>
                        <td>${user.gId}</td>
                        <td>${user.userName}</td>
                        <td>${user.userJob}</td>
                        <td>${user.userPhone}</td>
                        <td>${user.userEmail}</td>
                        <td>${user.userAddr}</td>
                        <td>${user.userEntry}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty userList}">
                <tr>
                    <td colspan="5">No data found</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    <button onclick="loadSelectedUser()">불러오기</button>
    <button onclick="location.href='/bizconnect/adminAddPage.do'">추가</button>
    <button>삭제</button>

    <h2>사용자 세부 정보</h2>
    <table>
        <tr>
            <th>아이디</th>
            <td><input type="text" id="gId"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" id="userName"></td>
        </tr>
        <tr>
            <th>회사명</th>
            <td><input type="text" id="userJob"></td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td><input type="text" id="phone"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="text" id="email"></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" id="address"></td>
        </tr>
        <tr>
            <th>가입일</th>
            <td id="userEntry"></td>
        </tr>
    </table>
    <button type="button" onclick="saveUserData()">저장</button>
</div>

</body>
</html>
