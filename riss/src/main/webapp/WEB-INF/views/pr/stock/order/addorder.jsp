<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>주문 등록</title>
    <script>
        function validate() {
            var orderDate = document.forms["orderForm"]["orderDate"].value;
            if (orderDate === "") {
                alert("주문 날짜를 입력하세요.");
                return false; // 유효성 검사 실패 시 폼 제출 중단
            }
            return true; // 유효성 검사 통과 시 폼 제출
        }
    </script>
</head>
    <body>
     <h1>주문 등록</h1>
    <form name="orderForm" action="addorder.do" method="post" onsubmit="return validate();">

    <!-- 주문번호 -->
    <label for="orderCd">주문번호:</label>
    <input type="number" name="orderCd" required><br>

    <!-- 주문 유형 -->
    <label for="orderType">주문 유형:</label>
    <input type="text" name="orderType" required><br>

    <!-- 주문 날짜 -->
    <label for="orderDate">주문일:</label>
    <input type="date" name="orderDate" required><br>

    <!-- 수령 날짜 -->
    <label for="orderReceiveDate">수령일:</label>
    <input type="date" name="orderReceiveDate" required><br> 

    <!-- 주문 금액 -->
    <label for="orderAmount">주문 금액:</label>
    <input type="number" name="orderAmount" required><br>

    <!-- 부가세 -->
    <label for="orderTax">부가세:</label>
    <input type="number" name="orderTax" required><br>

    <!-- 결제 여부 -->
    <label for="orderPaymentYn">결제 여부:</label>
    <select name="orderPaymentYn" required>
        <option value="Y">예</option>
        <option value="N">아니요</option>
    </select><br>

    <!-- 주문 취소 여부 -->
    <label for="orderCancelYn">주문 취소 여부:</label>
    <select name="orderCancelYn" required>
        <option value="Y">예</option>
        <option value="N">아니요</option>
    </select><br>

    <!-- 주문 단가 -->
    <label for="orderUnitPrice">주문 단가:</label>
    <input type="number" name="orderUnitPrice" required><br>

    <!-- 주문 상태 -->
    <label for="orderStatus">주문 상태:</label>
    <input type="text" name="orderStatus" required><br>

    <!-- 고객 정보 -->
    <label for="orderCustomerInfo">고객 정보:</label>
    <input type="text" name="orderCustomerInfo" required><br>

    <!-- 결제 방식 -->
    <label for="orderPaymentType">결제 방식:</label>
    <input type="text" name="orderPaymentType" required><br>

    <!-- 삭제 사유 -->
    <label for="orderDeletionReason">삭제 사유:</label>
    <input type="text" name="orderDeletionReason"><br>

    <!-- 직원 이름 -->
    <label for="empName">직원 이름:</label>
    <input type="text" name="empName" required><br>

    <!-- 보고서 유형 -->
    <label for="reportType">보고서 유형:</label>
    <input type="text" name="reportType" required><br>

    <!-- 결제 방법 -->
    <label for="paymentMethod">결제 방법:</label>
    <input type="text" name="paymentMethod" required><br>

    <!-- 결제 상태 -->
    <label for="paymentStatus">결제 상태:</label>
    <input type="text" name="paymentStatus" required><br>

    <!-- 제품 코드 -->
    <label for="productCd">제품 코드:</label>
    <input type="text" name="productCd" required><br>

    <!-- 회사 코드 -->
    <label for="comCode">회사 코드:</label>
    <input type="text" name="comCode" required><br>

    <input type="submit" value="주문 등록">
 </form>
     <button onclick="javascript:location.href='/bizconnect/order.do'; return false;">돌아가기</button>

    <c:forEach items="${requestScope.messages}" var="message">
        <p>${message}</p>
    </c:forEach>
</body>
</html>