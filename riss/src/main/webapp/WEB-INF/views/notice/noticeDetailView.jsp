<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세보기</title>
</head>
<body>
    <h1>공지사항 상세보기</h1>

    <table border="1">
        <tr>
            <th>제목</th>
            <td>${notice.noticeTitle}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${notice.noticeWriter}</td>
        </tr>
        <tr>
            <th>등록일</th>
            <td>${notice.noticeDate}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${notice.readCount}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${notice.noticeContent}</td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
                <c:if test="${notice.originalFilePath != null}">
                    <a href="nfdown.do?ofile=${notice.originalFilePath}&rfile=${notice.renameFilePath}">${notice.originalFilePath}</a>
                </c:if>
                <c:if test="${notice.originalFilePath == null}">
                    첨부파일 없음
                </c:if>
            </td>
        </tr>
    </table>

    <a href="noticeList.do">목록으로</a>

    <!-- 관리자에게만 수정/삭제 버튼 노출 -->
    <c:if test="${loginUser != null && loginUser.userRole == 'ADMIN'}">
        <a href="noticeUpdate.do?no=${notice.noticeNo}">수정</a>
        <a href="noticeDelete.do?no=${notice.noticeNo}">삭제</a>
    </c:if>

</body>
</html>
