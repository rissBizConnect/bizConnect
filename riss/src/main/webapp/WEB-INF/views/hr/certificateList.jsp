<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">

<head>
    <title>증명서 목록</title>
<link href="${path}/resources/css/hr/attendance.css?after" rel="stylesheet"/> 
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
<div class="contentPos">
    <h2>증명서 목록</h2>
    <table border="1">
        <thead>
            <tr>
                <th>증명서 번호</th>
                <th>서류명</th>
                <th>등록 날짜</th>
                <th>설명</th>
                <th>파일</th>
                <th>상세 보기</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="certificate" items="${certificateList}">
                <tr>
                    <td>${certificate.certificateId}</td>
                    <td>${certificate.certificateTitle}</td>
                    <td>${certificate.certificateDate}</td>
                    <td>${certificate.certificateDescription}</td>
                    <td><a href="${certificate.certificateFile}" download="download">다운로드</a></td>
                    <td><form action="cerView.do" method="POST">
    					<input type="hidden" name="certificateId" value="${certificate.certificateId}">
   						<button type="submit">상세보기</button>
					</form></td>
                    <td><form action="cerDelete.do" method="POST">
    					<input type="hidden" name="certificateId" value="${certificate.certificateId}">
    					<button type="submit">삭제</button>
						</form>
					</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="cerAddView.do">증명서 추가</a> <!-- 증명서 추가 페이지 링크 -->
    <c:import url="/WEB-INF/views/common/footer.jsp" />
    </div>
    </div>
</body>
</html>