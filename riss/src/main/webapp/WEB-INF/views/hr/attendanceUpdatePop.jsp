<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/attendanceUpdatePop.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hr/attendanceUpdatePop.js?after" charset="utf-8"></script>

</head>
<body>
<div>

<table class="table" id="table1" border="1" cellspacing="0"">
	<tr>
		<th class = "row">이 름</th>
		<th class = "row">날 짜</th>
		<th class = "row">출근 시간</th>
		<th class = "row">퇴근 시간</th>
	</tr>
	</tr>
		<tr>
			<td class = "row"><input id="gId" name="gId" type="text" style="width: 50px" value="${gId }" readonly="readonly"></td>
			<td class = "row"><input id="day" name="day" type="date" value="${day }" readonly="readonly"></td>
			<td class = "row">
				<input id="goDate" name="goDate" type="time" style="width: 105px" value="${goDate}">
			</td>
			<td class = "row">
				<input id="outDate" name="outDate" type="time" style="width: 105px" value="${outDate}">
			</td>
		</tr>
</table>
<button class="updateBTN" onclick="updateBTN(); return false;">수 정</button>
</div>

</body>
</html>