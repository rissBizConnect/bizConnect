<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendance</title>
<link href="${path}/resources/css/hr/attendanceCheck.css?after" rel="stylesheet"/> 
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>

</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		
		<div class = contentPos>
			<h4>근태 현황</h4>
			<hr>
			<table class = "table" border="1" cellspacing="0">
				<tr>
					<th class = "row">날 짜</th>
					<th class = "row">출근 시간</th>
					<th class = "row">퇴근 시간</th>
					<th class = "row" >근무 시간</th>
					
				</tr>
				<c:forEach items="${ requestScope.list }" var="att"><tr>
					<td class = "row">${ att.day }</td>
					<td class = "row"><c:if test="${!empty att.goDate }">${ att.goDate.toLocalDateTime().getHour() } 시 ${ att.goDate.toLocalDateTime().getMinute() } 분</c:if></td>
					<td class = "row"><c:if test="${!empty att.outDate }">${ att.outDate.toLocalDateTime().getHour() } 시 ${ att.outDate.toLocalDateTime().getMinute() } 분</c:if></td>
					<td class = "row"><c:if test="${!empty att.time }">${ att.calHTimestamp() } 시 ${ att.calMTimestamp() } 분 ${ att.calSTimestamp() } 초</c:if></td>
				</tr></c:forEach>
			</table>
			<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" /></div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

</body>
</html>