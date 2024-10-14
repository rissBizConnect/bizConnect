<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<h2>새 공지사항 작성</h2>
	<!-- 새 공지사항 작성 폼 -->
	<form action="insertNotice.do" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTitle" required></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="noticeWriter" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="noticeContent" rows="5" cols="40" required></textarea></td>
			</tr>
			<tr>
				<th>중요도</th>
				<td>
					<!-- 체크박스를 선택하지 않으면 기본값 'N'이 전달되도록 수정 --> <input type="hidden"
					name="importance" value="N"> <input type="checkbox"
					name="importance" value="Y"> 중요
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록하기"> <input
					type="reset" value="취소하기"></td>
			</tr>
		</table>
	</form>

</body>
</html>
