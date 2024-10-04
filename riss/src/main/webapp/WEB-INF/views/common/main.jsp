<%@ page language="java"  contentType="text/html ; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
div.lineA {
	height: 100px;
	border: 1px solid gray;
	float: left;
	position: relative;
	left: 120px;
	margin: 5px;
	padding: 5px;
}
div#banner {
	width: 500px;
	padding: 0;
}
div#banner img {
	width: 450px;
	height: 80px;
	padding: 0;
	margin-top: 10px;
	margin-left: 25px;
}
div#loginBox {
	width: 280px;
	font-size: 10pt;
	text-align: left;
	padding-left: 20px;
}
div#loginBox button {
	width: 250px;
	height: 35px;
	background-color: navy;
	color: white;
	margin-top: 10px;
	margin-bottom: 15px;
	font-size: 14pt;
	font-weight: bold;
	cursor: pointer;  /* 손가락모양 : 클릭 가능한 버튼으로 표시함 */
}
div#loginBox a {
	text-decoration: none;
	color: navy;
}
</style>
</head>
<body>
<h1>bizconnect</h1>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<header>
	<div id="banner" class="lineA">
		<img src="/first/resources/images/photo2.jpg">
	</div>
	<%-- <% if(loginUser == null){  //로그인 하지 않은 상태일 때 %> --%>
	<c:if test="${ empty sessionScope.loginUser }">
		<div id="loginBox" class="lineA">
			first 사이트 방문을 환영합니다.<br>
			<button onclick="movePage();">first 로그인</button> <br>
			<%-- 로그인 버튼을 클릭하면 자바스크립트 movePage() 함수가 실행되게 해서, 로그인 페이지가 나타나게 처리함 --%>
			<a href="enrollPage.do">회원가입</a>
			<%-- 회원가입 클릭하면 회원가입페이지가 연결되어 출력되게 링크 설정했음 --%>
		</div>
	</c:if>
	<%-- <% }else{  //로그인 했을 때 %> --%>
	<c:if test="${ !empty sessionScope.loginUser }">
		<div id="loginBox" class="lineA">
			${ sessionScope.loginUser.userName } 님 &nbsp; 
			<a href="logout.do">로그아웃</a> <br>
			메일 0, 쪽지 0 <br>
			<%-- a 태그로 서비스를 위한 url 요청시, 값도 같이 보내려면 쿼리스트링을 사용해야 함
				url?전송이름=보낼값&전송이름=보낼값
				?전송이름=보낼값&전송이름=보낼값 : 쿼리스트링(queryString) 이라고 함
				주의 : 쿼리스트링에는 공백 있으면 안됨
			 --%>
			<a href="myinfo.do?userId=${ sessionScope.loginUser.userId }">내 정보 보기</a>
		</div>
	</c:if>
	<%-- <% } %> --%>
	
</header>
</body>
</html>