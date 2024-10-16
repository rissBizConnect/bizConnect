<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/salary.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${path}/resources/js/hr/salary.js" charset="utf-8"></script>
  
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		<div class = contentPos>
			<h4>사원명부</h4>
			<hr>
			<form action="moveSalary.do">
				<input type="hidden" id="fileter" name="fileter" value="keyword" >
				<input type="text" class="searchText" id="keyword" name="keyword" placeholder="사원이름 검색">
				<input type="submit" class="searchBTN" value="검 색">
			</form>
			<button class="insertBTN" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveSalary.do'; return false;">추 가</button>

			<div id="tables">
		        <table class="table" id="table1" border="1" cellspacing="0"">
		        <tr>
		        	<th class = "row">아이디</th>
					<th class = "row">이 름</th>
					<th class = "row">지급일</th>
					<th class = "row">송금계좌</th>
					<th class = "row">지금액</th>
					<th class = "row">수 정/삭 제 </th>
				</tr>
				<c:forEach items="${ requestScope.list }" var="salaryData"><tr>
					<td class = "row">${salaryData.gId }</td>
					<td class = "row">${salaryData.name }</td>
					<td class = "row">${salaryData.getSalaryPayDate().toLocaleString().subSequence(0, 10) }</td>
					<td class = "row">${salaryData.accountNumber }</td>
					<td class = "row">${salaryData.salaryPay }</td>
					<td class = "row">
						<button class="updateBTN" onclick="memberUpdate('${salaryData.gId }'); return false;">수 정</button>
						<button class="deleteBTN" onclick="memberDelete('${salaryData.gId }', '${salaryData.salaryNo }'); return false;">삭 제</button>
					</td>
				</tr></c:forEach>
		        </table>
    		</div>
			
		
			<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" /></div>

		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>