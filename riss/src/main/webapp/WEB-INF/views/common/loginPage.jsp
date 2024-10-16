<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1>Bizconnect 로그인</h1>

<div id="loginForm">    
    <form action="/bizconnect/login.do" method="post">
        <label>아이디: <input type="text" name="gId"></label><br>
        <label>암호: <input type="password" name="userPW"></label><br>
        <label>회사 코드: <input type="text" name="comCode"></label><br> 
        <input type="submit" value="로그인">
    </form>
</div>

</body>
</html>
