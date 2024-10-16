<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계약서 업로드</title>
</head>
<body>
    <h2>계약서 업로드</h2>
    <form action="uploadContract.do" method="post" enctype="multipart/form-data">
        <label>서류명: </label>
        <input type="text" name="dm_title" required /><br />
        <label>파일: </label>
        <input type="file" name="dm_file" required /><br />
        <label>기타 설명: </label>
        <textarea name="dm_description"></textarea><br />
        <button type="submit">업로드</button>
    </form>
</body>
</html>
