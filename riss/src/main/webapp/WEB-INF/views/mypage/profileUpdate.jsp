<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 변경</title>
</head>
<body>
<h1>개인정보 변경</h1>

	<form action="/bizconnect/profileUpdateCheck.do" method="post">
	    <label>비밀번호를 입력하세요:</label>
	    <input type="password" name="userPW">
	    <button type="submit">확인</button>
	</form>



</body>
</html>
