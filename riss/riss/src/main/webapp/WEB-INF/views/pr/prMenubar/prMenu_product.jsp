<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
 <%@ page import="org.riss.bizconnect.pd.order.model.dto.OrderDTO" %>
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
        
        .filter-menu {
        display: none;
        margin-top: 20px;
    }
    </style>
    
    <!-- 조건별조회 버튼 누르면 필터링 -->
    <script>
    function toggleFilterMenu() {
        var filterMenu = document.getElementById('filterMenu');
        if (filterMenu.style.display === 'none' || filterMenu.style.display === '') {
            filterMenu.style.display = 'block';
        } else {
            filterMenu.style.display = 'none';
        }
    }
    </script>
</head>
<body>

	<div class="header">
    <!-- 전체메뉴 버튼 (상단 오른쪽에 배치됨) -->
    <button onclick="location.href='/bizconnect/prManagement.do'">재고관리 Home</button>
	</div>

    <div class="sidebar">
        <ul>
            <li class="active"><a href="/bizconnect/prMenu_product.do">제품관리</a></li>
            <li><a href="/bizconnect/prMenu_porder.do">발주관리</a></li>
            <li><a href="/bizconnect/prMenu_order.do">수주관리</a></li>
            <li><a href="/bizconnect/prMenu_check.do">교환/환불관리</a></li>
            <li><a href="/bizconnect/prMenu_client.do">거래처관리</a></li>
        </ul>
    </div>

    <div class="content">
        <h1>제품관리 ▸ 제품조회</h1>

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
                    <th>제품번호</th> <!-- 회사코드 제외함 -->
                    <th>제품명</th>
                    <th label for="filter">규격</label> <br>
					<select id="filter">
					   <option value="size">크기</option>
					   <option value="weight">중량</option>
					   <option value="volume">용량</option>
					</select></th>                  
                    <th>판매가</th>
                    <th>매입가</th>
                    <!-- <th>부가세</th> -->
                    <th>재고수량(현재재고량)</label> </th>
                    <th label for="filter">재고경고임계치</label> <br>
                       <select id="filter" name="stockStatus">
                            <option value="all">전체</option>
                            <option value="safe">안전</option>
                            <option value="danger">부족</option>
                        </select>
        			<th>거래처명</th>
                    <th>처리상태</th>
					<!-- <th>제품사진</th> -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td><input type="checkbox" name="selectProduct" value="${product.productNo}"></td>
                        <td>${product.productNo}</td>
                        <td>${product.productName}</td>
                        <td>${product.productCri}</td>
                        <td>${product.stockStatus}</td> <!-- 재고 상태 출력 -->
                        <td>${product.productPrice}</td>
                        <td>${product.productPurPrice}</td>
                        <td>${product.productCnt}</td>
                        <td>${product.productStockWarn}</td>
                        <td>${product.clientName}</td>
                        <td>${product.processStatus}</td>
                    </tr>
                </c:forEach>              
            </tbody>

        </table>

        <div class="button-group">
            <button class="btn-black">전체선택</button>
            <button class="btn-blue">조건별 조회</button>
            <button class="btn-red" onclick="javascript:location.href='/bizconnect/product.do'; return false;">제품 등록</button>
            <button class="btn-blue" onclick="javascript:location.href='/bizconnect/ordreport.do'; return false;">거래명세서 작성</button>
        </div>
        
                <div id="filterMenu" class="filter-menu">
            <label for="stockStatus">재고 상태</label>
            <select id="stockStatus" name="stockStatus">
                <option value="all">전체</option>
                <option value="safe">안전</option>
                <option value="danger">위험</option>
            </select>

            <label for="sizeFilter">규격 필터</label>
            <select id="sizeFilter">
                <option value="size">크기</option>
                <option value="weight">중량</option>
                <option value="volume">용량</option>
            </select>
        </div>

    </div>
    
   <script>
	// 추가된 자바스크립트 부분 시작**
	document.getElementById('ProductCri').addEventListener('change', function() {
	    var criValue = this.value;
	    document.getElementById('sizeInput').style.display = criValue === 'size' ? 'block' : 'none';
	    document.getElementById('weightInput').style.display = criValue === 'weight' ? 'block' : 'none';
	    document.getElementById('volumeInput').style.display = criValue === 'volume' ? 'block' : 'none';
});

</body>
</html>