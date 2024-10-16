<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    .content-section {
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f4f4f4;
    }

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    input[type="submit"] {
        padding: 10px 20px;
        background-color: #007BFF;
        border: none;
        color: white;
        font-size: 14px;
        cursor: pointer;
    }

    .error-message {
        color: red;
        font-size: 12px;
    }
</style>
</head>
<body>

<div class="content-section">
    <h1>개인정보 수정</h1>
    <form action="/bizconnect/updateProfile.do" method="POST">
    <table>
        <tr>
            <td>이름:</td>
            <td><input type="text" name="userName" value="${loginUser.userName}" readonly></td>
        </tr>
        <tr>
            <td>회사명:</td>
            <td><input type="text" name="comCode" value="${loginUser.comCode}" readonly></td>
        </tr>
        <tr>
            <td>전화번호:</td>
            <td><input type="text" name="userPhone" value="${loginUser.userPhone}" readonly></td>
        </tr>
        <tr>
            <td>이메일:</td>
            <td><input type="text" name="userEmail" value="${loginUser.userEmail}"></td>
        </tr>
        <tr>
            <td>계좌번호:</td>
            <td><input type="text" name="userCard" value="${loginUser.userCard}"></td>
        </tr>
        <tr>
    		<td>주소:</td>
    		<td><input type="text" name="userAddr" value="${loginUser.userAddr}"></td>
		</tr>

        <tr>
            <td>이전 비밀번호:</td>
            <td><input type="password" name="oldPW"></td>
        </tr>
        <tr>
            <td>신규 비밀번호:</td>
            <td><input type="password" name="newPW"></td>
        </tr>
        <tr>
            <td>신규 비밀번호 확인:</td>
            <td><input type="password" name="confirmPW"></td>
        </tr>
	    </table>
	    <button type="submit">저장</button>
		</form>	


</div>

</body>
</html>
