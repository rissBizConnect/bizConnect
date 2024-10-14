<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 수정</title>
</head>
<body>
    <h1>공지사항 수정</h1>

    <form action="noticeUpdate.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" name="noticeTitle" value="${notice.noticeTitle}" required></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="noticeWriter" value="${notice.noticeWriter}" readonly></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="noticeContent" rows="5" cols="50" required>${notice.noticeContent}</textarea></td>
            </tr>
            <tr>
                <th>중요도</th>
                <td><input type="checkbox" name="importance" value="Y" <c:if test="${notice.importance == 'Y'}">checked</c:if>> 중요</td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td>
                    <c:if test="${notice.originalFilePath != null}">
                        <a href="nfdown.do?ofile=${notice.originalFilePath}&rfile=${notice.renameFilePath}">${notice.originalFilePath}</a>
                        <br>
                        <input type="file" name="ofile">
                    </c:if>
                    <c:if test="${notice.originalFilePath == null}">
                        <input type="file" name="ofile">
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>

    <a href="noticeList.do">목록으로</a>
</body>
</html>
