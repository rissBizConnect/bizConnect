<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>증명서 상세 보기</title>
    <link href="${path}/resources/css/hr/attendanceCheck.css?after" rel="stylesheet"/> 
    <script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
<div class="contentPos">
    <h2>증명서 상세 보기</h2>
    <p><strong>증명서 번호:</strong> ${certificate.certificateId}</p><br>
    <p><strong>서류명:</strong> ${certificate.certificateTitle}</p><br>
    <p><strong>등록 날짜:</strong> ${certificate.certificateDate}</p><br>
    <p><strong>설명:</strong> ${certificate.certificateDescription}</p><br>
    <p><strong>파일:</strong> <a href="${certificate.certificateFile}" download>다운로드</a></p><br>
    <form action="cerDetailUpdate.do" method="post" style="display: inline;">
    <input type="hidden" name="certificateId" value="${certificate.certificateId}">
    <button type="submit">수정</button>
	</form>
    <form action="cerDelete.do" method="post" style="display:inline;">
        <input type="hidden" name="certificateId" value="${certificate.certificateId != null ? certificate.certificateId : 0}">
        <input type="submit" value="삭제" onclick="return confirm('정말 삭제하시겠습니까?');" />
    </form><br>
    <br/>
    <a href="cerList.do">목록으로 돌아가기</a>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
    </div>
    </div>
</body>
</html>
