<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- retireeForm.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/header.jsp'/>" />
<h2>퇴직자 추가</h2>
<form action="<c:url value='/retiree/add'/>" method="post">
    <label for="userName">이름:</label>
    <input type="text" id="userName" name="userName" required>
    <br>
    <label for="retireDate">퇴직일:</label>
    <input type="date" id="retireDate" name="retireDate" required>
    <br>
    <label for="exitReason">퇴직 사유:</label>
    <textarea id="exitReason" name="exitReason" required></textarea>
    <br>
    <input type="submit" value="추가">
</form>
<a href="<c:url value='/retiree/list'/>">목록으로 돌아가기</a>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/footer.jsp'/>" />
