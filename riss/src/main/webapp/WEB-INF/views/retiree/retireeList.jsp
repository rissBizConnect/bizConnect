<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/header.jsp'/>" />
<!-- retireeList.jsp -->
<h2>퇴직자 목록</h2>
<table>
    <thead>
        <tr>
            <th>이름</th>
            <th>퇴직일</th>
            <th>퇴직 사유</th>
            <th>상세 보기</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="retiree" items="${retireeList}">
            <tr>
                <td><c:out value="${retiree.userName}"/></td>
                <td><c:out value="${retiree.retireDate}"/></td>
                <td><c:out value="${retiree.exitReason}"/></td>
                <td><a href="<c:url value='/retiree/detail/${retiree.retNo}'/>">상세 보기</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="<c:url value='/retiree/form'/>">퇴직자 추가</a>
<jsp:include page="<c:url value='/WEB-INF/views/retiree/footer.jsp'/>" />