<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/infoUpdate.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js?afte"></script>
<script src="${path}/resources/js/hr/infoUpdate.js"></script>
  
</head>
<body>

<div class="form-container">
  <h2>사원 수정</h2>
<form action="InfoUpdate.do" method="post" onsubmit="return validate();" enctype="multipart/form-data"><br>
<input type="hidden" id="gId" name="gId" value="${member.gId }">
<input type="hidden" id="oContract" name="oContract" value="${member.userContract }">
<input type="hidden" id="oFacePictPath" name="oFacePictPath" value="${member.userFacePictPath }">
<input type="hidden" id="oCertificate" name="oCertificate" value="${member.userCertificate }">
    <div class="form-group">
      <label for="userName">*이 름</label>
      <input type="text" id="userName" value="${member.userName }" name="userName" required>
    </div>
    
    <div class="form-group">
      <label for="userJob">직원분류</label>
      <input type="text" id="userJob" value="${member.userJob }" name="userJob" >
    </div>
    
    <div class="form-group">
      <label for="userRegNo">*주민번호</label>
      <input type="text" id="userRegNo" value="${member.userRegNo }" name="userRegNo" required>
    </div>
    
    <div class="form-group">
      <label for="userPhone">전화번호</label>
      <input type="text" id="userPhone" value="${member.userPhone }" name="userPhone" >
    </div>
    
   	<div class="form-group">
      <label for="userEmail">이메일</label>
      <input type="text" id="userEmail" value="${member.userEmail }" name="userEmail" >
    </div>
    
    <div class="form-group">
      <label for="userAddr">주 소</label>
      <input type="text" id="userAddr" value="${member.userAddr }" name="userAddr" >
    </div>
    
    <div class="form-group">
      <label for="userEntry">*입사일</label>
      <input type="date" id="userEntry" value="${member.userEntry }" name="userEntry" required>
    </div>
    
    <div class="form-group">
      <label for="userPay">기본급</label>
      <input type="number" id="userPay" value="${member.userPay }" name="userPay" min="0">
    </div>
    
    <div class="form-group">
      <label for="muserContract">계약서</label>
      <img id="Contract_Img" alt="수정된 파일이 없습니다" src="${path}/resources/contract_files/${member.comCode}_${member.gId}_Contract${member.userContract}"><br>
      <input type="file" id="muserContract" onchange="updateFile('#Contract_Img'); return false;" name="muserContract">
    </div>
    
    <div class="form-group">
      <label for="userAccount">계좌번호</label>
      <input type="text" id="userAccount" value="${member.userAccount }" name="userAccount" >
    </div>
    
    <div class="form-group">
      <label for="userCard">카드번호</label>
      <input type="text" id="userCard" value="${member.userCard }" name="userCard" >
    </div>
    
    <div class="form-group">
      <label for="userRole">*권 한</label>
      <input type="text" id="userRole" value="${member.userRole }" name="userRole" required>
    </div>
    
    <div class="form-group">
      <label for="muserFacePictPath">사 진</label>
      <img id="FacePict_Img" alt="수정된 파일이 없습니다" src="${path}/resources/face_files/${member.comCode}_${member.gId}_FacePict${member.userFacePictPath}"><br>
      <input type="file" id="muserFacePictPath" onchange="updateFile('#FacePict_Img'); return false;" value="${member.userFacePictPath }" name="muserFacePictPath" >
    </div>
    
    <div class="form-group">
      <label for="muserCertificate">증명서</label>
      <img id="Certificate_Img" alt="수정된 파일이 없습니다" src="${path}/resources/certificate_files/${member.comCode}_${member.gId}_Certificate${member.userCertificate}"><br>      
      <input type="file" id="muserCertificate" onchange="updateFile('#Certificate_Img'); return false;" value="${member.userCertificate }" name="muserCertificate" >
    </div>
    
    <div class="form-group">
      <input type="submit" value="수 정">
    </div>
</body>
</html>ㅌ`ㅌ`