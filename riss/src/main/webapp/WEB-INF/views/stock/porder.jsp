<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect-발주관리</title>
</head>
<body>
<form action="insertporder.do" method="post" onsubmit="return validate();"><br>
	<input type="number" name="PorderNo">발주번호 &nbsp;<br>
	<input type="text" name="PorderName">제품명 &nbsp;<br>
	<input type="text" name="PorderCnt">발주수량 &nbsp;<br>
	<input type="number" name="PorderPrice">발주제품금액 &nbsp;<br>
	<input type="date" name="PorderDate">발주일 &nbsp;<br>
	<input type="date" name="DueDate">입고일 &nbsp;<br>
	<input type="number" name="FieldNum">창고번호 &nbsp;<br>
	<input type="submit" value="전송"> &nbsp;<br>

<c:forEach items="${ requestScope.one1}" var="n">
	${ n.test }
</c:forEach> 발주관리 만드는중,,-인경
</body>
</html>