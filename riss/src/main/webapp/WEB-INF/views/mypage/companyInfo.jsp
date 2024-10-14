<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 등록 및 정보</title>
</head>
<body>
<h1>기업 등록 및 정보</h1>

<p>기업 관련 정보를 등록하거나 수정할 수 있는 페이지입니다.</p>

<form action="/bizconnect/companyInfoAction.do" method="post">
    <label for="companyName">회사 이름:</label>
    <input type="text" id="companyName" name="companyName">
    <br>

    <label for="companyAddress">회사 주소:</label>
    <input type="text" id="companyAddress" name="companyAddress">
    <br>

    <label for="companyPhone">회사 전화번호:</label>
    <input type="text" id="companyPhone" name="companyPhone">
    <br>

    <button type="submit">등록</button>
</form>

</body>
</html>
