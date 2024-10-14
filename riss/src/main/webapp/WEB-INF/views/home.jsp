<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect</title>
</head>
<body>


<c:forEach items="${ requestScope.one1}" var="n">
	${ n.test }
</c:forEach> home,, 만드는중,,-인경
</body>
</html>