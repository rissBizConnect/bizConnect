<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/bizconnect/resources/css/hr/salaryInsert.css?after" rel="stylesheet"/>
<script type="text/javascript" src="${path}/resources/js/jquery-3.7.1.min.js"></script>
  
</head>
<body>

<div class="form-container">
  <h2>급여 등록</h2>
<form action="salaryInsert.do" method="post"><br>
    <div class="form-group">
      <label for="gId">*사원 아이디</label>
      <input type="text" id="gId" name="gId" required>
    </div>
    	
    <div class="form-group">
      <label for="salaryIncomT">소득세</label>
      <input type="number" id="salaryIncomT" name="salaryIncomT" >
    </div>
    
    <div class="form-group">
      <label for="salaryLocalT">지방세</label>
      <input type="number" id="salaryLocalT" name="salaryLocalT" >
    </div>
    
    <div class="form-group">
      <label for="salaryNPS">국민연금</label>
      <input type="number" id="salaryNPS" name="salaryNPS" >
    </div>
    
    <div class="form-group">
      <label for="salaryHI">건강보험</label>
      <input type="number" id="salaryHI" name="salaryHI" >
    </div>
    
    <div class="form-group">
      <label for="salaryEL">고용보험</label>
      <input type="number" id="salaryEL" name="salaryEL" >
    </div>
    
   	<div class="form-group">
      <label for="salaryWCI">산재보험</label>
      <input type="number" id="salaryWCI" name="salaryWCI" >
    </div>
    
    <div class="form-group">
      <label for="salaryLTCI">장기요양</label>
      <input type="number" id="salaryLTCI" name="salaryLTCI" >
    </div>
    
    <div class="form-group">
      <label for="salaryTotalD">공제총합</label>
      <input type="number" id="salaryTotalD" name="salaryTotalD" >
    </div>
    
    <div class="form-group">
      <label for="salaryIncentive">추가수당</label>
      <input type="number" id="salaryIncentive" name="salaryIncentive" min="0">
    </div>
    
    <div class="form-group">
      <label for="salaryPayDate">*지금일</label>
      <input type="date" id="salaryPayDate" name="salaryPayDate" required>
    </div>
    
    <div class="form-group">
      <label for="salaryPay">*지급액</label>
      <input type="number" id="salaryPay" name="salaryPay" required>
    </div>
    
    <div class="form-group">
      <label for="accountNumber">*송금계좌</label>
      <input type="text" id="accountNumber" name="accountNumber" required>
    </div>
 
    <div class="form-group">
      <input type="submit" value="전송">
    </div>
</form>
</body>
</html>