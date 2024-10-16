<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>attendance</title>
<link href="${path}/resources/css/hr/attendance.css?after" rel="stylesheet"/> 
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>

</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		
		<div class = contentPos>
			<c:import url="/WEB-INF/views/common/click.jsp" />
			<c:if test="${ !empty requestScope.gooutBTN }">
				<button class="goworkBTN" onclick="javascript:location.href='${pageContext.servletContext.contextPath }/${requestScope.URL }'"'>${ requestScope.gooutBTN }</button>
			</c:if>
		</div>
	</div>

		<c:import url="/WEB-INF/views/common/footer.jsp" />

</body>
</html>