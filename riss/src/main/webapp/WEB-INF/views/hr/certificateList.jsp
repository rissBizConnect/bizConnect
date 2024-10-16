<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>증명서 목록</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
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
                <th>수정</th>
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
                    <td><a href="detail?id=${certificate.certificateId}">상세보기</a></td>
                    <td><a href="update?id=${certificate.certificateId}">수정</a></td>
                    <td><a href="delete?id=${certificate.certificateId}" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="cerAdd.do">증명서 추가</a> <!-- 증명서 추가 페이지 링크 -->
</body>
</html>