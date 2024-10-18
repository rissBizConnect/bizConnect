<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>개발자 대시보드</title>
    
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
            justify-content: space-between;
            align-items: center;
        }

        .header button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
        }

        .header button:hover {
            background-color: #495057;
        }

        /* 테이블 스타일 */
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
            margin-bottom: 30px;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        td {
            text-align: left;
        }

        /* 버튼 스타일 */
        .btn-container {
            text-align: center;
            margin-top: 20px;
        }

        .btn-container button {
            padding: 10px 20px;
            background-color: #007bff;
            border: none;
            color: white;
            cursor: pointer;
            margin-right: 10px;
        }

        .btn-container button:hover {
            background-color: #0056b3;
        }

        .form-section {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>

<div class="wrapper">
    <!-- 사이드바 -->
    <div class="sidebar">
        <h3>개발자</h3>
        <h3>대시보드</h3>
        <ul>
            <li><a href="#">사용자 목록</a></li>
            <li><a href="/bizconnect/supportList.do">고객센터</a></li>
        </ul>
    </div>

    <div class="content-wrapper">
        <!-- 콘텐츠 영역 -->
        <div class="content">
            <!-- 상단 헤더 -->
            <div class="header">
                <div class="profile-info">개발자 대시보드</div>
                <button onclick="location.href='/bizconnect/logout.do'">로그아웃</button>
            </div>

            <!-- 사용자 목록 테이블 -->
            <h2>사용자 목록</h2>
            <table class="table table-striped">
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
                            <td colspan="9">No data found</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>

            <div class="btn-container">
                <button onclick="loadSelectedUser()">불러오기</button>
                <button onclick="location.href='/bizconnect/adminAddPage.do'">추가</button>
                <button>삭제</button>
            </div>

            <!-- 사용자 세부 정보 테이블 -->
            <h2>사용자 세부 정보</h2>
            <table class="table">
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

            <div class="btn-container">
                <button type="button" onclick="saveUserData()">저장</button>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function showUserDetails(userId) {
        $.get("/developer/viewUserDetails.do", { gId: userId }, function(data) {
            $("#gId").val(data.gId);
            $("#userName").val(data.userName);
            $("#userJob").val(data.userJob);
            $("#phone").val(data.userPhone);
            $("#email").val(data.userEmail);
            $("#address").val(data.userAddr);
            $("#userEntry").text(data.userEntry);
        });
    }

    function loadSelectedUser() {
        var selectedUser = $("input[name='selectedUser']:checked").val();
        if (selectedUser) {
            showUserDetails(selectedUser);
        } else {
            alert("사용자를 선택하세요.");
        }
    }

    function saveUserData() {
        // 사용자 데이터 저장 로직을 여기에 추가
        alert("사용자 데이터를 저장했습니다.");
    }
</script>
<div class="footerPos">
		<c:import url="/WEB-INF/views/common/footer.jsp" />
	</div>
</body>
</html>
