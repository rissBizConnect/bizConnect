<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect-거래처관리</title>
</head>
<body>
<form action="insertclient.do" method="post" onsubmit="return validate();" enctype="multipart/form-data"><br>
	<input type="text" name="ProductNo">제품번호 &nbsp;<br>
	<input type="text" name="ProductName">제품명 &nbsp;<br>
	<input type="text" name="ProductSize">규격 &nbsp;<br>
	<input type="number" name="ProductPrice">까먹었어 &nbsp;<br>
	<input type="number" name="ProductPurPrice">까먹었어2 &nbsp;<br>
	<input type="submit" value="전송"> &nbsp;<br>
<c:forEach items="${ requestScope.one1}" var="n">
	${ n.test }
</c:forEach> 거래처관리 만드는중,,-인경
</body>
</html>