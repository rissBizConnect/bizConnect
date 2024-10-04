<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>퇴직자 추가</title>
</head>
<body>
<h1>퇴직자 추가</h1>
<form action="/retiree/add" method="post">
    퇴직자 ID: <input type="text" name="retireId" required><br>
    이름: <input type="text" name="retireName" required><br>
    입사일: <input type="date" name="user_entry_date" required><br>
    퇴사일: <input type="date" name="ret_date" required><br>
    고용형태: <input type="text" name="ret_type" required><br>
    <input type="submit" value="추가">
</form>
<a href="/retiree/list">목록으로 돌아가기</a>
</body>
</html>
