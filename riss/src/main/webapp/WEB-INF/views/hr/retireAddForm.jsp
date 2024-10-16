<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴직자 추가</title>

    <link href="${path}/resources/css/hr/attendance.css?after" rel="stylesheet"/>
	<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
<div class="contentPos">
	<h1>퇴직자 추가</h1>

	<form action="retAdd.do" method="get">
		GID: <input type="text" name="gid" required /><br /> 회사 코드: <input
			type="text" name="comCode" required /><br /> 입사일: <input
			type="date" name="userEntryDate" required /><br /> 퇴사일: <input
			type="date" name="retDate" required /><br /> 총 근무일: <input
			type="text" name="retTotalDate" required /><br /> 고용형태: <input
			type="text" name="retType" required /><br /> 비고: <input
			name="exitReason"></input><br /> <input type="submit" value="추가" />
	</form>

	<a href="retList.do">목록으로 돌아가기</a>
	</div>
	</div>
</body>
</html>