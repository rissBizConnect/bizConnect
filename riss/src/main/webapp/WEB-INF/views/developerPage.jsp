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
            justify-content: flex-end;
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
</head>
<body>

<div class="header">
    <div class="profile-info">개발자 대시보드</div>
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
                <th>주소</th>
                <th>가입일</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty userList}">
                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr>
                        <td><input type="checkbox" name="selectedUser" value="${user.gId}"></td>
                        <td>${status.index + 1}</td>
                        <td>${user.gId}</td>
                        <td>${user.userName}</td>
                        <td>${user.userAddr}</td>
                        <td>${user.userEntry}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty userList}">
                <tr>
                    <td colspan="6">No data found</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    
    <button id="loadUserButton">불러오기</button>

    <h2>사용자 세부 정보</h2>
    <table>
        <tr>
            <th>아이디</th>
            <td id="gid"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td id="userName"></td>
        </tr>
        <tr>
            <th>회사명</th>
            <td id="userJob"></td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td id="userPhone"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td id="userEmail"></td>
        </tr>
        <tr>
            <th>주소</th>
            <td id="userAddr"></td>
        </tr>
        <tr>
            <th>가입일</th>
            <td id="userEntry"></td>
        </tr>
    </table>

    <h3>사용자 권한</h3>
    <form id="userForm" action="/developer/saveUserDetails.do" method="post">
        <label><input type="checkbox" name="prManagement" id="prManagement"> PR 관리 권한</label><br>
        <label><input type="checkbox" name="hrManagement" id="hrManagement"> HR 관리 권한</label><br>
        <button type="submit">저장</button>
    </form>
</div>

<script>
    window.onload = function() {
        // Ensure the button is found after the page is loaded
        document.getElementById('loadUserButton').addEventListener('click', function() {
            var selectedUser = document.querySelector('input[name="selectedUser"]:checked');
            
            if (selectedUser) {
                var userId = selectedUser.value;
                
                // Make an AJAX request to fetch the user details by ID
                fetch('/bizconnect/developer/viewUserDetails.do?userId=' + userId)
                .then(response => response.json())
                .then(data => {
                    // Populate the user details section with the fetched data
                    document.getElementById('gid').textContent = data.gId;
                    document.getElementById('userName').textContent = data.userName;
                    document.getElementById('userJob').textContent = data.userJob;
                    document.getElementById('userPhone').textContent = data.userPhone;
                    document.getElementById('userEmail').textContent = data.userEmail;
                    document.getElementById('userAddr').textContent = data.userAddr;
                    document.getElementById('userEntry').textContent = data.userEntryDate;

                    document.getElementById('prManagement').checked = data.prManagement;
                    document.getElementById('hrManagement').checked = data.hrManagement;
                })
                .catch(error => {
                    console.error('Error fetching user details:', error);
                });
            } else {
                alert('사용자를 선택해주세요.');
            }
        });
    };
</script>

</body>
</html>
