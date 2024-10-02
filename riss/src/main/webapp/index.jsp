<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- index.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
<h2>환영합니다!</h2>
<p>Bizconnect 퇴직자 관리 시스템에 오신 것을 환영합니다.</p>
<p><a href="<c:url value='/retiree/list'/>">퇴직자 관리로 이동</a></p>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />