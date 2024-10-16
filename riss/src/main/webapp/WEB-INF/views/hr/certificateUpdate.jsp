<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>증명서 수정</title>
    <link href="${path}/resources/css/hr/attendanceCheck.css?after" rel="stylesheet"/> 
    <script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
<div class="contentPos">
    <h2>증명서 수정</h2>
    
    <!-- 증명서 수정 폼 -->
    <form action="/cerUpdate.do" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="certificateIdS" value="${certificate.certificateId}"> <!-- 기존 증명서 ID -->
        
        <label for="certificateTitle">증명서 제목:</label>
        <input type="text" id="certificateTitle" name="certificateTitle" value="${certificate.certificateTitle}" required> <!-- 기존 제목을 기본값으로 설정 -->
        
        <label for="certificateDescription">설명:</label>
        <textarea id="certificateDescription" name="certificateDescription" required>${certificate.certificateDescription}</textarea> <!-- 기존 설명을 기본값으로 설정 -->
        
        <label for="file">파일 업로드:</label>
        <input type="file" id="file" name="file"> <!-- 기존 파일을 교체할 수 있는 파일 업로드 -->
        
        <button type="submit">수정</button>
    </form>

    <a href="cerList.do">목록으로 돌아가기</a> <!-- 목록으로 돌아가는 링크 -->
    <c:import url="/WEB-INF/views/common/footer.jsp" />
    </div>
    </div>
</body>
</html>
