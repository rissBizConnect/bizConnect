<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
</head>
<body>
<h1>고객센터</h1>

<p>여기에서 고객센터와 관련된 질문이나 이슈를 게시할 수 있습니다.</p>

<form action="/bizconnect/supportCenterAction.do" method="post">
    <label for="issue">문의 내용:</label>
    <textarea id="issue" name="issue" rows="5" cols="50"></textarea>
    <br>

    <button type="submit">문의 제출</button>
</form>

</body>
</html>
