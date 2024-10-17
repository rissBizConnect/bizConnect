<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/bizconnect/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/bizconnect/resources/js/pr/prMenu_order.js?after"></script>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재고관리 HOME</title>
    <style>
    
    .header {
        display: flex;
        justify-content: flex-end; /* Aligns the content to the right */
        align-items: center;
        background-color: #f4f4f4;
        padding: 10px 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .header button {
        padding: 10px 20px;
        background-color: #ffffff;
        border: 1px solid #ccc;
        cursor: pointer;
        font-weight: bold;
    }       
    
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        /* 왼쪽 사이드바 스타일 */
        .sidebar {
            width: 200px;
            height: 100vh;
            background-color: #f4f4f4;
            float: left;
            padding-top: 20px;
        }
        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 15px;
        }
        .sidebar ul li a {
            text-decoration: none;
            color: #333;
            display: block;
        }
        .sidebar ul li a:hover {
            background-color: #ddd;
        }
        .sidebar ul li.active a {
            background-color: #337ab7;
            color: white;
        }

        /* 메인 컨텐츠 스타일 */
        .content {
            margin-left: 200px;
            padding: 20px;
        }
        h1 {
            font-size: 24px;
        }

        /* 테이블 스타일 */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
        td img {
            width: 50px;
        }
        /* 하단 합계 스타일 */
        .summary-row {
            background-color: #e8f4ff;
            font-weight: bold;
        }

        /* 버튼 스타일 */
        .button-group {
            margin-top: 20px;
        }
        .button-group button {
            padding: 10px 20px;
            margin-right: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-blue {
            background-color: #337ab7;
            color: white;
        }
        .btn-red {
            background-color: #d9534f;
            color: white;
        }
        .btn-black {
            background-color: black;
            color: white;
        }

        /* 검색 창 스타일 */
        .search-bar {
            margin-top: 20px;
        }
        .search-bar input {
            padding: 10px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .search-bar select {
            padding: 10px;
            border-radius: 5px;
        }
        .search-bar button {
            padding: 10px 20px;
            margin-left: 10px;
            border: none;
            background-color: #337ab7;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

	<div class="header">
    <!-- 전체메뉴 버튼 (상단 오른쪽에 배치됨) -->
    <button onclick="location.href='/bizconnect/prManagement.do'">재고관리 Home</button>
	</div>

    <div class="sidebar">
        <ul>
            <li><a href="moveprMenu_product.do">제품관리</a></li>
            <li><a href="moveprMenu_porder.do">발주관리</a></li>
            <li class="active"><a href="moveprMenu_order.do">수주관리</a></li>
            <li><a href="/bizconnect/prMenu_check.do">교환/환불관리</a></li>
            <li><a href="moveprMenu_client.do">거래처관리</a></li>
        </ul>
    </div>

    <div class="content">
        <h1>수주관리 ▸ 주문조회</h1>

        <div class="search-bar">
            <select>
                <option>제품명</option>
                <!-- 추가 옵션들 -->
            </select>
            <input type="text" placeholder="검색어를 입력하세요">
            <button>전체보기</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>주문번호</th>
                    <th>수주제품개수</th>
                    <th>주문금액</th>
                    <th>고객코드</th>
                    <th>주문일</th>
                    <th>수정 / 상세</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
              
            </tbody>
            <tfoot>
            	<c:forEach items="${ order }" var="o"><tr>
            	<tr>
                    <td>${ o.orderDiv }</td>
                    <td>${ o.orderCnt }</td>
                    <td>${ o.orderPay }</td>
                    <td>${ o.customerCode }</td>
                    <td>${ o.orderDate }</td>
                    <td>
                    	<button class="updateBTN" onclick="updateBTN('${o.orderDiv}', '${o.orderType }'); return false;">수정 / 상세</button>
                    </td>
                    <td>
                    	<button class="deleteBTN" onclick="deleteBTN('${o.orderDiv}', '${o.orderType }' ); return false;">삭 제</button>	
                    </td>
			    </tr>
			    </c:forEach>
            </tfoot>
        </table>

        <div class="button-group">
            <button class="btn-black">전체선택</button>
            <button class="btn-blue">뭘로 하징</button>
            <button class="btn-red" onclick="javascript:location.href='/bizconnect/moveOrderInsert.do'; return false;">주문 등록</button>
            <button class="btn-blue" onclick="javascript:location.href='/bizconnect/ordreport.do'; return false;">거래명세서 작성</button>
        </div>

    </div>

</body>
</html>