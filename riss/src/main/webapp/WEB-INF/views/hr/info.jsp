<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/info.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${path}/resources/js/hr/info.js" charset="utf-8"></script>
  
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		<div class = contentPos>
			<h4>사원명부</h4>
			<hr>
			<form action="moveInfo.do">
				<input type="hidden" id="fileter" name="fileter" value="keyword" >
				<input type="text" class="searchText" id="keyword" name="keyword" placeholder="사원이름 검색">
				<input type="submit" class="searchBTN" value="검 색">
			</form>
			<button class="insertBTN" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveInfoInsert.do'; return false;">추 가</button>

			<div id="tables">
		        <table class="table" id="table1" border="1" cellspacing="0"">
		        <tr>
		        	<th class = "row">아이디</th>
					<th class = "row">이 름</th>
					<th class = "row">주민등록번호</th>
					<th class = "row">전화번호</th>
					<th class = "row">이메일</th>
					<th class = "row" >주 소</th>
					<th class = "row" >계좌번호</th>
					<th class = "row" >권 한</th>
					<th class = "row" >수 정/삭 제</th>
					<th class = "row" >퇴사자 전환</th>
				</tr>
				<c:forEach items="${ requestScope.list }" var="infoData"><tr>
					<td class = "row">${infoData.gId }</td>
					<td class = "row">${infoData.userName }</td>
					<td class = "row">${infoData.userRegNo }</td>
					<td class = "row">${infoData.userPhone }</td>
					<td class = "row">${infoData.userEmail }</td>
					<td class = "row" >${infoData.userAddr }</td>
					<td class = "row" >${infoData.userCard }</td>
					<td class = "row" >${infoData.userRole }</td>
					<td class = "row">
					
						<button class="updateBTN" onclick="memberUpdate('${infoData.gId }'); return false;">수 정</button>
						<c:if test="${ infoData.gId ne sessionScope.loginUser.gId  }"><button class="deleteBTN" onclick="memberDelete('${infoData.gId }'); return false;">삭 제</button></c:if>
					</td>
					<td class = "row" ><button class="updateBTN" onclick="memberRetireUpdate('${infoData.gId }'); return false;">퇴사자 전환</button></td>
				</tr></c:forEach>
		        </table>
    		</div>
			
		
			<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" /></div>

		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>