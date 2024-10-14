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
            // 유효성 검사 로직 추가
            return true; // 검사 통과 시 true 반환
        }
    </script>
</head>
<body>
    <h1>주문 등록</h1>
    <form action="addorder.do" method="post" onsubmit="return validate();">
        <label for="orderNo">주문번호:</label>
        <input type="number" name="orderNo" required><br>

        <label for="productNo">제품 번호:</label>
        <input type="text" name="productNo" required><br>

        <label for="orderType">주문 타입:</label>
        <input type="text" name="orderType" required><br>

        <label for="orderDate">주문일:</label>
        <input type="date" name="orderDate" required><br>

        <label for="orderReceiveDate">수령일:</label>
        <input type="date" name="orderReceiveDate"><br>

        <label for="orderAmount">주문 금액:</label>
        <input type="number" name="orderAmount" required><br>

        <label for="orderTax">부가세:</label>
        <input type="number" name="orderTax" required><br>

        <label for="orderPaymentYn">결제 여부:</label>
        <select name="orderPaymentYn">
            <option value="Y">예</option>
            <option value="N">아니요</option>
        </select><br>

        <label for="orderCancelYn">주문 취소 여부:</label>
        <select name="orderCancelYn">
            <option value="Y">예</option>
            <option value="N">아니요</option>
        </select><br>

        <input type="submit" value="주문 등록">
    </form>
     <button onclick="javascript:location.href='/bizconnect/order.do'; return false;">돌아가기</button>

    <c:forEach items="${requestScope.messages}" var="message">
        <p>${message}</p>
    </c:forEach>
</body>
</html>