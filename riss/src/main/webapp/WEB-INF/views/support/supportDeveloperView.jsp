<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="org.myweb.first.support.model.dto.support" %>
<%
	support support = (support)request.getAttribute("support");
%> --%>  <%-- el 로 대체함 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 developer화면</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    .header {
        text-align: center;
        padding: 20px;
        background-color: #f4f4f4;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }

    .content {
        margin: 0 auto;
        width: 80%;
    }

    .detail-view {
        border: 1px solid #ddd;
        padding: 20px;
        margin-bottom: 20px;
    }

    .detail-view h2 {
        margin-top: 0;
    }

    .detail-view .info {
        margin-bottom: 20px;
    }

    .detail-view .info span {
        display: inline-block;
        margin-right: 20px;
    }

    .detail-view .content-text {
        white-space: pre-line;
    }

    .btn-container {
        text-align: center;
    }

    .btn-container button {
        padding: 10px 20px;
        background-color: #007bff;
        border: none;
        color: white;
        cursor: pointer;
    }

    .btn-container button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<%-- 요청 url 을 따로 지정 --%>
<c:url var="nup" value="supportUpdateForm.do">
	<c:param name="no" value="${ support.supportNo }" />
</c:url>

<c:url var="ndel" value="deleteSupport.do">
	<c:param name="no" value="${ support.supportNo }" />
	<c:param name="rfile" value="${ support.renameFilePath }" />
</c:url>

<script type="text/javascript">
//수정 페이지로 이동 버튼 클릭시 작동하는 함수
function moveUpdatePage(){
	location.href = "${ nup }";
}

//삭제하기 버튼 클릭시 작동하는 함수
function requestDelete(){
	location.href = "${ ndel }";
}
</script>
</head>
<body>
<%-- <%@ include file="../common/menubar.jsp" %> --%>

<hr>

<h2 align="center">${ support.supportNo } 번 공지글 상세보기 (관리자용)</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
	<tr><th>제 목</th><td>${ support.supportTitle }</td></tr>
	<tr><th>작성자</th><td>${ support.supportWriter }</td></tr>
	<tr><th>등록날짜</th>
		<td><fmt:formatDate value="${ support.supportDate }" pattern="yyyy-MM-dd" /></td></tr>
	<tr><th>중요도</th><td>${ support.importance }</td></tr>
	<tr><th>중요도 설정 종료 날짜</th>
		<td><fmt:formatDate value="${ support.impEndDate }" pattern="yyyy-MM-dd" /></td></tr>
	<tr><th>첨부파일</th>
		<td>
			<c:url var="nfdown" value="nfdown.do">
				<c:param name="ofile" value="${ support.originalFilePath }" />
				<c:param name="rfile" value="${ support.renameFilePath }" />
			</c:url>
			<c:if test="${ !empty support.originalFilePath }">
				<a href="${ nfdown }">${ support.originalFilePath }</a>
				<%-- <a href="nfdown.do?ofile=${ support.originalFilePath }&rfile=${ support.renameFilePath }">${ support.originalFilePath }</a> --%>
			</c:if>
			<c:if test="${ empty support.originalFilePath }">
				첨부 파일 없음
			</c:if>
		</td>
	</tr>
	<tr><th>내 용</th><td>${ support.supportContent }</td></tr>
	<tr><th colspan="2">
    <button onclick="moveUpdatePage(); return false;">수정페이지로 이동</button>  &nbsp; 
    <button onclick="requestDelete(); return false;">삭제하기</button>  &nbsp; 
    <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/supportList.do';">목록</button> &nbsp;  
    <button onclick="javascript:history.go(-1); return false;">이전 페이지로 이동</button>
</th></tr>

</table>


<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>