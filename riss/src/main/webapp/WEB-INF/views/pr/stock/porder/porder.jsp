<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect-발주관리</title>
</head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">  
  <!-- 외부 CSS 파일 링크 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  
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

    .form-group input[type="submit"] {
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

<body>

<div class="form-container">
  <h2>발주 등록</h2>
<form action="insertporder.do" method="post" onsubmit="return validate();" enctype="multipart/form-data"><br>
    <div class="form-group">
      <label for="ProductNo">발주번호</label>
      <input type="number" id="PorderNo" name="PorderNo" required>
    </div>
    	
    <div class="form-group">
      <label for="ProductName">제품명</label>
      <input type="text" id="ProductName" name="ProductName" required>
    </div>
    
    <div class="form-group">
      <label for="PorderCnt">발주수량</label>
      <input type="number" id="PorderCnt" name="PorderCnt" required>
    </div>

    <div class="form-group">
      <label for="PorderPrice">발주제품금액</label>
      <input type="number" id="PorderPrice" name="PorderPrice" required>
    </div>
    
    
    <div class="form-group">
      <label for="PorderDate">발주일</label>
      <input type="date" id="PorderDate" name="PorderDate" required>
    </div>    

    <div class="form-group">
      <label for="DueDate">입고일</label>
      <input type="date" id="DueDate" name="DueDate" required>
    </div>

    <div class="form-group">
      <label for="FieldNum">창고번호</label>
      <input type="number" id="FieldNum" name="FieldNum" required>
    </div>

    <div class="form-group">
      <input type="submit" value="전송">
    </div>

<c:forEach items="${ requestScope.one1}" var="n">
	${ n.test }
</c:forEach> 발주관리 - 등록 페이지,,-인경
</body>
</html>