<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<link href="${path}/resources/css/hr/attendance.css" rel="stylesheet"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendance</title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>

</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<c:import url="/WEB-INF/views/common/menubar.jsp" />
	<button onclick="return false;">출 첵</button>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>