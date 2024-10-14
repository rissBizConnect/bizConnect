<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.riss.bizconnect.pd.order.model.dto.OrderDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수주 관리</title>
    <style>
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
    <script>
        function showOrderSuccessPopup() {
            alert("주문이 완료되었습니다."); // 주문 완료 메시지 팝업
        }
    </script>
</head>
<body>

    <div class="sidebar">
        <ul>
            <li><a href="/bizconnect/">재고관리</a></li>
            <li><a href="/bizconnect/porder.do">발주관리</a></li>
            <li class="active"><a href="#">수주관리</a></li>
            <li><a href="/bizconnect/erpclient.do">거래처관리</a></li>
        </ul>
    </div>

    <div class="content">
        <h1>수주관리 > 주문조회</h1>

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
                    <th>선택</th>
                    <th>주문번호</th>
                    <th>제품명</th>
                    <th>제품사진</th>
                    <th>거래처명</th>
                    <th>단가</th>
                    <th>발주수량</th>
                    <th>공급가액</th>
                    <th>부가세</th>
                    <th>처리상태</th>
                </tr>
            </thead>
            <tbody>
               <!-- 주문 데이터가 여기에 삽입될 예정 -->
            </tbody>
            <tfoot>
                <tr class="summary-row">
                    <td colspan="6">합계</td>
                    <td>싸울래?</td>
                    <td>불만있어??</td>
                    <td>뭐요</td>
                    <td>뭘봐</td>
                </tr>
            </tfoot>
        </table>

        <div class="button-group">
            <button class="btn-black">전체선택</button>
            <button class="btn-blue" onclick="showOrderSuccessPopup(); return false;">주문하기</button> <!-- 주문하기 버튼 -->
            <button class="btn-red" onclick="javascript:location.href='/bizconnect/addorder.do'; return false;">주문 등록</button>
            <button class="btn-blue" onclick="javascript:location.href='/bizconnect/ordreport.do'; return false;">거래명세서 작성</button>
        </div>

    </div>

</body>
</html>