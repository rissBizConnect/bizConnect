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
<form action="productInsert.do">
  <h2>제품 등록</h2>
	<hr>
		<div class="form-group">
	      	<label for="productNo">제품명</label>
	      	<input type="text" id="productName" name="productName">
	    </div>
		<div class="form-group">
	      <label for="clientCode">거래처명</label>
	      	<select id="clientCode" name="clientCode">
		    	<option value="" hidden="">선택하세요</option>
			    <c:forEach items="${ list }" var="client">
			    	<option value="${ client.getClientCode() }">${ client.getClientName() } (${ client.getClientCode() })</option>
			    </c:forEach>
			</select>
	    </div>
	    

		<!-- 크기 입력 필드 -->
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="productCnt">제품개수</label>
		  <input type="number" id="productCnt" name="productCnt" required>
		</div>
			
		<!-- 중량 입력 필드 -->
		<div class="form-group dynamic-field" id="weightInput" >
		  <label for="productCri">제품-규격기준</label>
		  <input type="number" id="productCri" name="productCri" required>
		</div>
		
		<!-- 용량 입력 필드 -->
		<div class="form-group dynamic-field" id="volumeInput" >
		  <label for="productSize">제품-크기</label>
		  <input type="number" id="productSize" name="productSize" required>
		</div>
	
	    <div class="form-group">
	      <label for="productLength">가로</label>
		  <input type="number" id="productLength" name="productLength" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productWidth">세로</label>
		  <input type="number" id="productWidth" name="productWidth" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productHeight">높이</label>
		  <input type="number" id="productHeight" name="productHeight" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productWeight">제품-중량(g)</label>
		  <input type="number" id="productWeight" name="productWeight" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productVolume">제품-용량(ml)</label>
		  <input type="number" id="productVolume" name="productVolume" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productPrice">판매가</label>
		  <input type="number" id="productPrice" name="productPrice" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productPurPrice">매입가</label>
		  <input type="number" id="productPurPrice" name="productPurPrice" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productcStock">현재재고량</label>
		  <input type="number" id="productcStock" name="productcStock" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productStockWarn">재고경고임계치</label>
		  <input type="number" id="productStockWarn" name="productStockWarn" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productStatus">제품상태</label>
		  <input type="text" id="productStatus" name="productStatus" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="fieldNum">창고번호</label>
		  <input type="text" id="fieldNum" name="fieldNum" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="empName">담당자명</label>
		  <input type="text" id="empName" name="empName" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="productImage">제품사진</label>
		  <input type="text" id="productImage" name="productImage" required>
	    </div>
	    

	
	<div class="form-group">
      <input type="submit" value="전송"> 
	</div>
</form>	
</div>
</body>
</html>