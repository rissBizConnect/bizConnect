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
  <h2>제품 등록</h2>
  <form action="OrderInsert.do" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="OrderType">발주/수주 구분</label>
	    <select id="OrderType" name="OrderType">
	        <option name="orderType" value="P">발주</option>
	        <option name="orderType" value="O">수주</option>
	    </select>            
    </div>
    
    
	<c:forEach var="cnt" begin="1" end="${count }" step="1">
	<hr>
	    <div class="form-group">
	      <label for="productNo">제품명</label>
	      	<select id="productNo" name="productNo">
		    	<option value="" hidden="">선택하세요</option>
			    <c:forEach items="${ list }" var="product">
			    	<option value="${ product.productNo }">${ product.productName } (${ product.productNo })</option>
			    </c:forEach>
			</select>
	    </div>

		<!-- 크기 입력 필드 -->
		<div class="form-group dynamic-field" id="sizeInput" >
		  <label for="orderDetailDate">납기일</label>
		  <input type="date" id="orderDetailDate" name="orderDetailDate" required>
		</div>
			
		<!-- 중량 입력 필드 -->
		<div class="form-group dynamic-field" id="weightInput" >
		  <label for="orderDetailPayment">결제유무</label>
		  <input type="text" id="orderDetailPayment" name="orderDetailPayment" required>
		</div>
		
		<!-- 용량 입력 필드 -->
		<div class="form-group dynamic-field" id="volumeInput" >
		  <label for="orderDetailCancel">취소유무</label>
		  <input type="text" id="orderDetailCancel" name="orderDetailCancel" required>
		</div>
	
	    <div class="form-group">
	      <label for="orderDetailStatus">상태</label>
		  <input type="text" id="orderDetailStatus" name="orderDetailStatus" required>
	    </div>
	    
	    <div class="form-group">
	      <label for="orderDetailCnt">개수</label>
		  <input type="number" id="orderDetailCnt" name="orderDetailCnt" required>
	    </div>

	    <br><br><br><br><br>
	</c:forEach>
	<div class="form-group">
      <label for="orderCnt">전체 제품개수</label>
	  <input type="number" id="orderCnt" name="orderCnt" required>
	</div>
	
	<div class="form-group">
      <label for="orderPay">전체 주문금액(원)</label>
	  <input type="number" id="orderPay" name="orderPay" required>
    </div>
    
    <div class="form-group">
      <label for="orderDate">전체 주문일</label>
	  <input type="date" id="orderDate" name="orderDate" required>
    </div>
	
	<div class="form-group">
      <input type="submit" value="전송"> 
	</div>
	</form>
	      <label for="countUp"></label>
      <input class="addDelete" type="button" id="countUp" name="countUp" onclick="cntup('${count}'); return false;" value="추 가">
      <label for="countDelete"></label>
      <input class="addDelete" type="button" id="countDelete" name="countDelete" onclick="cntdn('${count}'); return false;" value="제 거">
	
</div>
</body>
</html>