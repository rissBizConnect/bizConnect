<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="maupdateM" value="moveAttendanceUpdateM.do">
	<c:param name="fileter" value="member" />
</c:url>

<c:set var="path" value="${pageContext.servletContext.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendance</title>
<link href="${path}/resources/css/hr/attendanceUpdateM.css?after" rel="stylesheet"/> 
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hr/attendanceUpdateM.js" charset="utf-8"></script>



</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		
		<div class = contentPos>
			<div class = "categoryPos">
			필 터
			    <select id="fileterCg" name="fileterCg" onchange="fileterChange(); return false;"> 
			    	<option value="all" <c:if test="${ fileter eq 'all' }">selected="selected"</c:if> >전 체</option>
			        <option value="member" <c:if test="${ fileter eq 'member' }">selected="selected"</c:if> >사 원</option>
			        <option value="date" <c:if test="${ fileter eq 'date' }">selected="selected"</c:if> >날 짜</option>
			        <option value="work" <c:if test="${ fileter eq 'work' }">selected="selected"</c:if> >근무 시간</option>
			    </select>
			
			<span id="memberFileter" name="memberCg" <c:if test="${!(fileter eq 'member') }">style="display: none;"</c:if>>
			사 원
			    <select id="memberCg" name="memberCg" onchange="memberChange(); return false;">
			    	<option value="" hidden="">선택하세요</option>
				    <c:forEach items="${ requestScope.memberlist }" var="mnames">
				    	<option value="${ mnames }" >${ mnames }</option>
				    </c:forEach>
				</select>
			</span>
			
			<span id="dateFileter" name="dateFileter" <c:if test="${!(fileter eq 'date') }">style="display: none;"</c:if>>
			날 짜 <input type="date" id="startD" name="startD" > ~ <input type="date" id="endD" name="endD" >
	
			</span>
		    </div>
		    
			<h4>근태 수정/확인</h4>
			<hr>
			<div id="tables">
		        <table class="table" id="table1" border="1" cellspacing="0"">
		        <tr>
					<th class = "row">이 름</th>
					<th class = "row">날 짜</th>
					<th class = "row">출근 시간</th>
					<th class = "row">퇴근 시간</th>
					<th class = "row" >근무 시간</th>
					<th class = "row" >수 정</th>
				</tr>
				<c:forEach items="${ requestScope.list }" var="att"><tr>
					<td class = "row">${ att.gId }</td>
					<td class = "row">${ att.day }</td>
					<td class = "row"><c:if test="${!empty att.goDate }">${ att.goDate.toLocalDateTime().getHour() } 시 ${ att.goDate.toLocalDateTime().getMinute() } 분</c:if></td>
					<td class = "row"><c:if test="${!empty att.outDate }">${ att.outDate.toLocalDateTime().getHour() } 시 ${ att.outDate.toLocalDateTime().getMinute() } 분</c:if></td>
					<td class = "row"><c:if test="${!empty att.time }">${ att.calHTimestamp() } 시 ${ att.calMTimestamp() } 분 ${ att.calSTimestamp() } 초</c:if></td>
					<td class = "row"><button class="updateBTN">수 정</button></td>
				</tr></c:forEach>
		        </table>
    		</div>
			<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" /></div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

</body>
</html>