<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>계약서 추가</title>
    <link href="${path}/resources/css/hr/attendanceCheckS.css?after" rel="stylesheet"/> 
    <script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
	<div class = contentPos>
    <h2>계약서 추가</h2>
    <form action="/cerAdd.do" method="Post" enctype="multipart/form-data">
    <label for="contractsTitle">계약서 제목:</label>
    <input type="text" id="contractsTitle" name="contractsTitle"><br>

    <label for="contractsDescription">설명:</label>
    <textarea id="contractsDescription" name="contractsDescription"></textarea><br>

    <label for="file">파일 업로드:</label>
    <input type="file" id="file" name="file"><br>

    <button type="submit">추가</button><br>
</form>
    <a href="cerList.do">목록으로 돌아가기</a>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</div>
</div>
</body>

</html>