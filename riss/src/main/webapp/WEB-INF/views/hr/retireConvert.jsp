<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="${path}/resources/css/hr/attendanceCheckS.css?after" rel="stylesheet"/>
	<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		<div class="contentPos">
	<h2>사원 <-> 퇴직자 변환</h2>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>입사일</th>
				<th>퇴사일</th>
				<th>상태</th>
				<th>변환</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="retire" items="${retireList}">
				<tr>
					<td>${retire.retNo}</td>
					<td>${retire.gid}</td>
					<td>${retire.userEntryDate}</td>
					<td>${retire.retDate}</td>
					<td><c:choose>
							<c:when test="${retire.retNo != null}">
                                퇴직자
                            </c:when>
							<c:otherwise>
                                사원
                            </c:otherwise>
						</c:choose></td>
					<td><c:if test="${retire.retNo != null}">
							<form action="convertToWorker.do" method="post">
								<input type="hidden" name="retNo" value="${retire.retNo}">
								<button type="submit">사원으로 변환</button>
							</form>
						</c:if> <c:if test="${retire.retNo == null}">
							<form action="convertToRetire.do" method="post">
								<input type="hidden" name="gid" value="${retire.gid}">
								<button type="submit">퇴직자로 변환</button>
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>