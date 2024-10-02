<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- retireeDetail.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/header.jsp'/>" />
<%@ page import="org.riss.bizconnect.hr.retiree.model.dto.RetireDTO" %>

<%
    RetireDTO retiree = (RetireDTO) request.getAttribute("retiree");
    if (retiree == null) {
        out.println("퇴직자 정보가 없습니다.");
    } else {
%>
    <h1>퇴직자 상세 정보</h1>
    <p>이름: <%= retiree.getUserName() %></p>
    <p>퇴직 날짜: <%= retiree.getRetDate() %></p>
    <p>퇴직 사유: <%= retiree.getRetExitReason() %></p>
    <%-- 기타 필드 출력 --%>
<%
    }
%>
<h2>퇴직자 상세 정보</h2>
<table>
    <tr>
        <th>이름</th>
        <td><c:out value="${retiree.userName}"/></td>
    </tr>
    <tr>
        <th>퇴직일</th>
        <td><c:out value="${retiree.retireDate}"/></td>
    </tr>
    <tr>
        <th>퇴직 사유</th>
        <td><c:out value="${retiree.exitReason}"/></td>
    </tr>
</table>
<a href="<c:url value='/retiree/list'/>">목록으로 돌아가기</a>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/footer.jsp'/>" />
