<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
</head>
<body>
    <h1>개인정보 수정</h1>
    <p>개인정보 수정을 위해서 비밀번호를 다시한번 입력해주세요</p>
    <form action="/bizconnect/profileUpdateCheck.do" method="post">
	    <label for="userPw">비밀번호 입력:</label>
	    <input type="password" id="userPw" name="userPw" required>
	    <button type="submit">확인</button>
	</form>

</body>
</html>
