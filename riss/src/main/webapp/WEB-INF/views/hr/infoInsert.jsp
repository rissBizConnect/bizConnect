<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/infoInsert.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
  
</head>
<body>

<div class="form-container">
  <h2>사원 등록</h2>
<form action="InfoInsert.do" method="post" onsubmit="return validate();" enctype="multipart/form-data"><br>
    <div class="form-group">
      <label for="gId">*아이디</label>
      <input type="text" id="gId" name="gId" required>
    </div>
    	
    <div class="form-group">
      <label for="userName">*이 름</label>
      <input type="text" id="userName" name="userName" required>
    </div>
    
    <div class="form-group">
      <label for="userJob">직원분류</label>
      <input type="text" id="userJob" name="userJob" >
    </div>
    
    <div class="form-group">
      <label for="userRegNo">*주민번호</label>
      <input type="text" id="userRegNo" name="userRegNo" required>
    </div>
    
    <div class="form-group">
      <label for="userPhone">전화번호</label>
      <input type="text" id="userPhone" name="userPhone" >
    </div>
    
   	<div class="form-group">
      <label for="userEmail">이메일</label>
      <input type="text" id="userEmail" name="userEmail" >
    </div>
    
    <div class="form-group">
      <label for="userAddr">주 소</label>
      <input type="text" id="userAddr" name="userAddr" >
    </div>
    
    <div class="form-group">
      <label for="userEntry">*입사일</label>
      <input type="date" id="userEntry" name="userEntry" required>
    </div>
    
    <div class="form-group">
      <label for="userPay">기본급</label>
      <input type="number" id="userPay" name="userPay" min="0">
    </div>
    
    
    <div class="form-group">
      <label for="userAccount">계좌번호</label>
      <input type="text" id="userAccount" name="userAccount" >
    </div>
    
    <div class="form-group">
      <label for="userCard">카드번호</label>
      <input type="text" id="userCard" name="userCard">
    </div>
    
    <div class="form-group">
      <label for="userRole">*권 한</label>
      <input type="text" id="userRole" name="userRole" required>
    </div>
    
    <div class="form-group">
      <label for="muserFacePictPath">사 진</label>
      <input type="file" id="muserFacePictPath" name="muserFacePictPath">
    </div>
    
    <div class="form-group">
      <input type="submit" value="전송">
    </div>
</body>
</html>