<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Support Update</title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>

<h2 align="center">${ support.supportNo } 번 지원글 수정 페이지 (관리자용)</h2>
<br>

<form action="updateSupport.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="supportNo" value="${ support.supportNo }">
	<input type="hidden" name="originalFilePath" value="${ support.originalFilePath }">
	<input type="hidden" name="renameFilePath" value="${ support.renameFilePath }">
	
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr><th>제 목</th>
		<td><input type="text" name="supportTitle" size="50" value="${ support.supportTitle }"></td></tr>
	<tr><th>작성자</th>
		<td><input type="text" name="supportWriter" readonly value="${ sessionScope.loginUser.userName }"></td></tr>	
	<tr><th>중요도</th>
		<td>
			<c:if test="${ !empty support.importance and support.importance eq 'Y' }">
				<input type="checkbox" name="importance" value="Y" checked> 중요
			</c:if> 
			<c:if test="${ !empty support.importance and support.importance eq 'N' }">
				<input type="checkbox" name="importance" value="Y"> 중요
			</c:if> 
		</td></tr>
	<tr><th>중요도 설정 종료 날짜</th>
		<td><input type="date" value="${ support.impEndDate }" name="impEndDate"></td></tr>
	<tr><th>첨부파일</th>
		<td>			
			<c:if test="${ !empty support.originalFilePath }">
				${ support.originalFilePath } &nbsp;
				<input type="checkbox" name="deleteFlag" value="yes"> 파일삭제 <br>
				변경 : <input type="file" name="upfile">
			</c:if>
			<c:if test="${ empty support.originalFilePath }">
				첨부 파일 없음 <br>
				추가 : <input type="file" name="upfile">
			</c:if>
		</td>
	</tr>
	<tr><th>내 용</th>
		<td><textarea rows="5" cols="50" name="supportContent">${ support.supportContent }</textarea></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="수정하기"> &nbsp;
		<input type="reset" value="수정취소"> &nbsp;
		<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/supportList.do'; return false;">목록</button> &nbsp;  
		<button onclick="javascript:history.go(-1); return false;">이전 페이지로 이동</button>
	</th></tr>
</table>
</form>

<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
