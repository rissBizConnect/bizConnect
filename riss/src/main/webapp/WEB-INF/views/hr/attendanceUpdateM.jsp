<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendance</title>
<link href="${path}/resources/css/hr/attendanceCheckM.css?after" rel="stylesheet"/> 
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/hr/attendanceUpdateM.js" charset="utf-8"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		
		<div class = contentPos>
			<div class = "categoryPos">
			회 사
			    <select id="companyCg" name="companyCg"> 
			        <option value="category1" >카테고리 1</option>
			        <option value="category2">카테고리 2</option>
			        <option value="category3">카테고리 3</option>
			    </select>
			&nbsp;&nbsp;&nbsp; 사 원
			    <select id="memberCg" name="memberCg" >
			        <option value="category1">카테고리 1</option>
			        <option value="category2">카테고리 2</option>
			        <option value="category3">카테고리 3</option>
			    </select>
		    </div>
			<h4>근태 수정/확인</h4>
			<hr>
			<div id="tables">
		        <table class="table" id="table1" border="1" cellspacing="0"">
		            <tr>
		                <th>카테고리 1 데이터</th>
		                <th>카테고리 1 데이터</th>
		                <th>카테고리 1 데이터</th>
		                <th>카테고리 1 데이터</th>
		                <th>카테고리 1 데이터</th>
		            </tr>
		            <tr>
		                <td>데이터 1</td>
		                <td>데이터 1</td>
		                <td>데이터 1</td>
		                <td>데이터 1</td>
		                <td>데이터 1</td>
		            </tr>
		        </table>
		
		        <table class="table" id="table2" style="display:none;" border="1" cellspacing="0"">
		            <tr>
		                <th>카테고리 2 데이터</th>
		                <th>카테고리 2 데이터</th>
		                <th>카테고리 2 데이터</th>
		                <th>카테고리 2 데이터</th>
		                <th>카테고리 2 데이터</th>
		            </tr>
		            <tr>
		                <td>데이터 2</td>
		                <td>데이터 2</td>
		                <td>데이터 2</td>
		                <td>데이터 2</td>
		                <td>데이터 2</td>
		            </tr>
		        </table>
		        <table class="table" id="table3" style="display:none;" border="1" cellspacing="0"">
		            <tr>
		                <th>카테고리 3 데이터</th>
		                <th>카테고리 3 데이터</th>
		                <th>카테고리 3 데이터</th>
		                <th>카테고리 3 데이터</th>
		                <th>카테고리 3 데이터</th>
		            </tr>
		            <tr>
		                <td>데이터 3</td>
		                <td>데이터 3</td>
		                <td>데이터 3</td>
		                <td>데이터 3</td>
		                <td>데이터 3</td>
		            </tr>
		        </table>
    		</div>
			<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" /></div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

</body>
</html>