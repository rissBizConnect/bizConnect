<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
    <title>계약서 목록</title>
</head>
<body>
    <h2>계약서 파일 목록</h2>
    <table border="1">
        <thead>
            <tr>
                <th>서류명</th>
                <th>contractId</th>
                <th>등록날짜</th>
                <th>파일명</th>
                <th>비고</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="file" items="${contractList}">
                <tr>
                    <td>${file.dmTitle}</td>
                    <td>${file.contractId}</td>
                    <td>${file.dmDate}</td>
                    <td><a href="${file.dmFile}" target="_blank">파일 열기</a></td>
                    <td>${file.dmDescription}</td>
                    <td><a href="editContract.jsp?contractId=${file.contractId}">수정</a></td>
                    <td><a href="deleteContract.do?contractId=${file.contractId}">삭제</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
