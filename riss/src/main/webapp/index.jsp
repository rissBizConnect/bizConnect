<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>뭘봐</title>
</head>
<body>

    <div class="container">
        <h1>안녕하세요 퉁퉁이입니다</h1>
        <div class="button-group">
            <button onclick="javascript:location.href='/bizconnect/porder.do'; return false;">발주관리</button> 
            <button onclick="javascript:location.href='/bizconnect/order.do'; return false;">수주관리</button> 
            <button onclick="javascript:location.href='/bizconnect/product.do'; return false;">제품관리</button> 
            <button onclick="javascript:location.href='/bizconnect/check.do'; return false;">교환/환불관리</button> 
            <button onclick="javascript:location.href='/bizconnect/erpclient.do'; return false;">거래처관리</button> 
        </div>
    </div>

</body>
</html>