<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>증명서 상세 보기</title>
</head>
<body>
    <h2>증명서 상세 보기</h2>
    <p><strong>증명서 번호:</strong> ${certificate.certificateId}</p>
    <p><strong>서류명:</strong> ${certificate.certificateTitle}</p>
    <p><strong>등록 날짜:</strong> ${certificate.certificateDate}</p>
    <p><strong>설명:</strong> ${certificate.certificateDescription}</p>
    <p><strong>파일:</strong> <a href="${certificate.certificateFile}" download>다운로드</a></p>
    <a href="cerUpdate.do?id=${certificate.certificateId}">수정</a>
    <form action="cerDelete.do" method="post" style="display:inline;">
        <input type="hidden" name="id" value="${certificate.certificateId}" />
        <input type="submit" value="삭제" onclick="return confirm('정말 삭제하시겠습니까?');" />
    </form>
    <br/>
    <a href="cerList.do">목록으로 돌아가기</a>
</body>
</html>
