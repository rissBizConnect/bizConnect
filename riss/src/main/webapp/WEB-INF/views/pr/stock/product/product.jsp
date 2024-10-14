<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bizconnect-발주:제품관리</title>

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
    
    .dynamic-field {
      display: none;
    }
    
  </style>  
</head>
<body>

<div class="form-container">
  <h2>제품 등록</h2>
  <form action="insertproduct.do" method="post" onsubmit="return validate();" enctype="multipart/form-data">
    <div class="form-group">
      <label for="orderType">발주/수주 구분</label>
	    <select id="orderType" name="orderType">
	        <option value="P">발주</option>
	        <option value="O">수주</option>
	    </select>            
    </div>
    
    <div class="form-group">
      <label for="ProductName">제품명</label>
      <input type="text" id="ProductName" name="ProductName" required>
    </div>

    <div class="form-group">
      <label for="productfileter">규격</label>
      <input type="text" id="productfileter" name="productfileter" required>
    </div>
		<!-- 크기 입력 필드 -->
		<div class="form-group dynamic-field" id="sizeInput" style="display:none;">
		  <label for="size">크기 (cm)</label>
		  <input type="text" id="ProductSize" name="ProductSize">
		</div>
		
		<!-- 중량 입력 필드 -->
		<div class="form-group dynamic-field" id="weightInput" style="display:none;">
		  <label for="weight">중량 (kg)</label>
		  <input type="text" id="ProductWeight" name="ProductWeight">
		</div>
		
		<!-- 용량 입력 필드 -->
		<div class="form-group dynamic-field" id="volumeInput" style="display:none;">
		  <label for="volume">용량 (L)</label>
		  <input type="text" id="ProductVolume" name="ProductVolume">
		</div>
    

    <div class="form-group">
      <label for="ProductPrice">제품 가격(판매가)</label>
	  <input type="number" id="ProductPrice" name="ProductPrice" min="1" max="10000" step="1">
    </div>

    <div class="form-group">
      <label for="ProductPurPrice">제품 매입 가격(매입가)</label>
      <input type="number" id="ProductPurPrice" name="ProductPurPrice" min="1" step="1" required>
    </div>

    <div class="form-group">
	<form action="filterProductStockStatus.do" method="get">
	    <label for="stockStatus">재고 상태(현재 재고량)</label>
	    <select id="stockStatus" name="stockStatus">
	        <option value="all">전체</option>
	        <option value="safe">안전</option>
	        <option value="danger">위험</option>
	    </select>
	    <input type="submit" value="필터링">
</form>
    </div>
    
    <div class="form-group">
      <label for="productStockWarn">재고경고임계치</label>
      <input type="text" id="productStockWarn" name="productStockWarn" required>
    </div> 	
	
    <div class="form-group">
      <input type="submit" value="전송">
    </div>

발주:제품관리 만드는중,,-인경
</body>
</html>