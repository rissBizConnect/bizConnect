<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴직자 수정</title>
    <link href="${path}/resources/css/hr/attendanceCheckS.css?after" rel="stylesheet"/>
	<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		<div class="contentPos">
	<h1>퇴직자 수정</h1>
	<form action="retEdit.do" method="get">
		<input type="hidden" name="retNo" value="${retire.retNo}" /> GID: <input
			type="text" name="gid" value="${retire.gid}" required /><br /> 회사
		코드: <input type="text" name="comCode" value="${retire.comCode}"
			required /><br /> 입사일: <input type="date" name="userEntryDate"
			value="${retire.userEntryDate}" required /><br /> 퇴사일: <input
			type="date" name="retDate" value="${retire.retDate}" required /><br />
		총 근무일: <input type="text" name="retTotalDate"
			value="${retire.retTotalDate}" required /><br /> 고용형태: <input
			type="text" name="retType" value="${retire.retType}" required /><br />
		비고:
		<textarea name="exitReason">${retire.exitReason}</textarea>
		<br /> <input type="submit" value="수정" />
	</form>

	<a href="retList.do">목록으로 돌아가기</a>
	</div>
	</div>
</body>
</html>