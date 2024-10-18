<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />


<!DOCTYPE html>
<html lang="ko">
<head>
    <title>증명서 추가</title>
    <link href="${path}/resources/css/hr/attendanceCheckS.css?after" rel="stylesheet"/> 
    <script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
	<div class = contentPos>
    <h2>증명서 추가</h2>
    <script>
    function validateForm() {
        const fileInput = document.getElementById('file');
        const allowedExtensions = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
        if (!allowedExtensions.exec(fileInput.value)) {
            alert('업로드 가능한 파일 형식은 JPG, PNG, PDF 파일만 가능합니다.');
            fileInput.value = '';
            return false;
        }
        return true;
    }
</script>

<form action="cerAdd.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
    <label for="certificateTitle">증명서 제목:</label>
    <input type="text" id="certificateTitle" name="certificateTitle" required><br>

    <label for="certificateDescription">설명:</label>
    <textarea id="certificateDescription" name="certificateDescription" required></textarea><br>

    <label for="file">파일 업로드:</label>
    <input type="file" id="file" name="file" required><br>

    <button type="submit">추가</button><br>
	</form>
    <a href="certificateDetail.do">목록으로 돌아가기</a>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</div>
</div>
</body>

</html>