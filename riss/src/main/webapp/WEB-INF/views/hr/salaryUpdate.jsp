<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/salaryUpdate.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js?afte"></script>
<script src="${path}/resources/js/hr/salaryUpdate.js"></script>
  
</head>
<body>

<div class="form-container">
  <h2>급여 수정</h2>
<form action="salaryUpdate.do" method="post" enctype="multipart/form-data"><br>
<input type="hidden" id="gId" name="gId" value="${salary.gId }">
<input type="hidden" id="salaryNo" name="salaryNo" value="${salary.salaryNo }">
    <div class="form-group">
      <label for="userName">*사원 아이디</label>
      <input type="text" id="name" value="${salary.name }" name="name" required="required" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="userJob">소득세</label>
      <input type="number" id="salaryIncomT" value="${salary.salaryIncomT }" name="salaryIncomT" >
    </div>
    
    <div class="form-group">
      <label for="userRegNo">지방세</label>
      <input type="number" id="salaryLocalT" value="${salary.salaryLocalT }" name="salaryLocalT" >
    </div>
    
    <div class="form-group">
      <label for="userPhone">국민연금</label>
      <input type="number" id="salaryNPS" value="${salary.salaryNPS }" name="salaryNPS" >
    </div>
    
   	<div class="form-group">
      <label for="userEmail">건강보험</label>
      <input type="number" id="salaryHI" value="${salary.salaryHI }" name="salaryHI" >
    </div>
    
    <div class="form-group">
      <label for="userAddr">고용보험</label>
      <input type="number" id="salaryEL" value="${salary.salaryEL }" name="salaryEL" >
    </div>
    
    <div class="form-group">
      <label for="userEntry">산재보험</label>
      <input type="number" id="salaryWCI" value="${salary.salaryWCI }" name="salaryWCI" >
    </div>
    
    <div class="form-group">
      <label for="userPay">장기요양</label>
      <input type="number" id="salaryLTCI" value="${salary.salaryLTCI }" name="salaryLTCI" min="0">
    </div>
    
    <div class="form-group">
      <label for="userAccount">공제총합</label>
      <input type="number" id="salaryTotalD" value="${salary.salaryTotalD }" name="salaryTotalD" >
    </div>
    
    <div class="form-group">
      <label for="userCard">추가수당</label>
      <input type="number" id="salaryIncentive" value="${salary.salaryIncentive }" name="salaryIncentive" >
    </div>
    
    <div class="form-group">
      <label for="userRole">*지금일</label>
      <input type="date" id="salaryPayDate" value="${salary.salaryPayDate }" name="salaryPayDate" required>
    </div>
    
    <div class="form-group">
      <label for="userRole">*지급액</label>
      <input type="number" id="salaryPay" value="${salary.salaryPay }" name="salaryPay" required>
    </div>
    
    <div class="form-group">
      <label for="userRole">*송금계좌</label>
      <input type="text" id="accountNumber" value="${salary.accountNumber }" name="accountNumber" required>
    </div>

    <div class="form-group">
      <input type="submit" value="수 정">
    </div>
</form>
</body>
</html>