<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect-발주:제품관리</title>
</head>
<body>
<form action="insertproduct.do" method="post" onsubmit="return validate();" enctype="multipart/form-data"><br>
	<input type="text" name="ProductrNo">발주번호 &nbsp;<br>
	<input type="text" name="ProductName">제품명 &nbsp;<br>
	<input type="text" name="ProductSize">규격 &nbsp;<br>
	<input type="number" name="ProductPrice">까먹었어 &nbsp;<br>
	<input type="number" name="ProductPurPrice">까먹었어2 &nbsp;<br>
	<input type="submit" value="전송"> &nbsp;<br>
<%-- <table id="outer" align="center" width="700" cellspacing="5" cellpadding="0">
	<tr><th colspan="2">회원 정보를 입력해 주세요. (* 표시는 필수입력 항목입니다.)</th></tr>
	<tr><th width="120">*아이디</th>
		<td>
			<input type="text" name="userId" id="userId" required> &nbsp;
			<input type="button" value="중복체크" onclick="return dupIdCheck();">
		</td></tr>
	<tr><th>사진첨부</th>
		파일로 전송한다면, input type="file" 로 지정하면 됨, 첨부된 사진 미리보기 안됨
		<!-- <td><input type="file" name="photoFileName"></td> -->
		첨부된 사진 미리보기가 되도록 하고자 한다면
		<td>
			선택한 사진파일 미리보기용 영역 지정 : 서버로는 전송되지 않음
			<div id="myphoto" style="margin:0;width:150px;height:160px;padding:0;border:1px solid navy;">
				사진 첨부가 없을 경우를 위한 미리보기용 이미지 출력되게 설정함
				<img src="/first/resources/images/photo1.jpg" id="photo" 
				style="width:150px;height:160px;border:1px solid navy;display:block;margin:0;padding:0;" 
				alt="사진을 드래그 드롭하세요.">
			</div> <br>
			<input type="file" id="photofile" name="photofile"> 
			name 속성의 이름은 필드명과 별개로 지정함
				파일업로드 실패시 파일명만 문자열로 command 객체에 저장되지 않게 하기 위함
			
		</td>
	</tr>
	<tr><th>*암 호</th><td><input type="password" name="userPwd" id="userPwd" required></td></tr>
	<tr><th>*암호확인</th><td><input type="password" id="userPwd2" required></td></tr>
	<tr><th>*이 름</th><td><input type="text" name="userName" id="userName" required></td></tr>
	<tr><th>*성 별</th>
		<td>
			<input type="radio" name="gender" value="M"> 남자 &nbsp;
			<input type="radio" name="gender" value="F"> 여자
		</td>
	</tr>
	<tr><th>*나 이</th><td><input type="number" name="age" min="19" value="20" required></td></tr>
	<tr><th>*전화번호</th><td><input type="tel" name="phone" required></td></tr>
	<tr><th>*이메일</th><td><input type="email" name="email" required></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="가입하기"> &nbsp; 
		<input type="reset" value="작성취소"> &nbsp; 
		<a href="main.do">Home</a>
	</th></tr> --%>
</form>

발주:제품관리 만드는중,,-인경
</body>
</html>