<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>증명서 추가</title>
</head>
<body>
    <h2>증명서 추가</h2>
    <form action="cerAdd.do" method="post" enctype="multipart/form-data">
        <label for="title">서류명:</label>
        <input type="text" name="title" required /><br />
        
        <label for="description">설명:</label>
        <textarea name="description"></textarea><br />

        <label for="file">파일:</label>
        <input type="file" name="file" required /><br />

        <input type="submit" value="추가하기" />
    </form>
    <a href="cerList.do">목록으로 돌아가기</a>
</body>
</html>
