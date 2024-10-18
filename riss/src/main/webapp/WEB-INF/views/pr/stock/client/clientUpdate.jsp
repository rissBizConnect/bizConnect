<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/bizconnect/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/bizconnect/resources/js/pr/orderInsert.js?after"></script>
<meta charset="UTF-8">
<title>bizconnect-발주:제품관리</title>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">  
  
  <style>
    .form-container {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      background-color: #f9f9f9;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group input[type="number"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    .form-group input[type="submit"], 
    .addDelete {
      background-color: #28a745;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .form-group input[type="submit"]:hover {
      background-color: #218838;
    }
    
  </style>  
</head>
<body>

<div class="form-container">

  <h2>사업자 등록</h2>
	<hr>
	<form action="clientInsert.do" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${ client.getClientCode() } }">
		<!-- 크기 입력 필드 -->
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="BusinessNum">사업자번호</label>
		  <input type="text" id="BusinessNum" name="BusinessNum" value="${ client.getBusinessNum() }" required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ClientName">거래처명</label>
		  <input type="text" id="ClientName" name="ClientName" value="${ client.getClientName() }"  required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="PersonCharge">담당자명</label>
		  <input type="text" id="PersonCharge" name="PersonCharge" value="${ client.getPersonCharge() }" required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="BusinessType">거래처업종</label>
		  <input type="text" id="BusinessType" name="BusinessType" value="${ client.getBusinessType() }" required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ClientTel">거래처전화번호</label>
		  <input type="text" id="ClientTel" name="ClientTel" value="${ client.getClientTel() }"  required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ClientAddr">거래처주소</label>
		  <input type="text" id="ClientAddr" name="ClientAddr" value="${ client.getClientAddr() }"  required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ClientEmail">거래처이메일</label>
		  <input type="text" id="ClientEmail" name="ClientEmail" value="${ client.getClientEmail() }"  required>
		</div>
		
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ClientFax">거래처팩스번호</label>
		  <input type="text" id="ClientFax" name="ClientFax" value="${ client.getClientFax() }"  required>
		</div>

		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="ModifiDate">수정일</label>
		  <input type="date" id="ModifiDate" name="ModifiDate" value="${ client.getModifiDate() }" required>
		</div>
	<div class="form-group">
      <input type="submit" value="전송"> 
	</div>
</form>	
</div>
</body>
</html>