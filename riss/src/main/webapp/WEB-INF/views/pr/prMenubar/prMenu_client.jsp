<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/bizconnect/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/bizconnect/resources/js/pr/prMenu_client.js"></script>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bizconnect-재고:거래처관리</title>
    <style>
       body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        /* 전체 레이아웃 스타일 */
        .wrapper {
            display: flex;
            justify-content: center; /* 가운데 정렬을 추가 */
            align-items: flex-start;
            width: 100%;
            min-height: 100vh;
        }

        /* 사이드바 스타일 */
        .sidebar {
            width: 250px;
            background-color: #343a40;
            padding: 20px;
            height: 100vh;
            color: white;
            flex-shrink: 0;
        }

        .sidebar h3 {
            color: #ffc107;
            margin-bottom: 30px;
        }

        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 15px;
        }

        .sidebar ul li a {
            color: white;
            font-weight: bold;
            padding: 10px;
            display: block;
            text-decoration: none;
            border-radius: 5px;
        }
        
        .sidebar ul li.active a {
            background-color: #ffc107;
            color: white;
        }

        .sidebar ul li a:hover {
            background-color: #495057;
        }

        /* 콘텐츠 영역 스타일 */
        .content-wrapper {
            display: flex;
            flex-direction: column;
            width: 100%;
            max-width: 1200px; /* main.jsp와 같은 너비로 설정 */
            padding: 20px;
            box-sizing: border-box;
            margin: 0 auto; /* 가운데 정렬 */
        }
/* 			background-color: #ffffff; */
/*             padding: 15px 20px; */
/*             box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); */
/*             margin-bottom: 30px; */
/*             display: flex; */
/*             justify-content: flex-end; */
/*             align-items: center; */
        .content {
            width: 100%;
            padding: 20px;
            background-color: white; /* 배경색을 설정해 main.jsp와 통일 */
            border-radius: 10px; /* 모서리를 둥글게 */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* 헤더 스타일 */
        .header {
            background-color: #ffffff;
            padding: 15px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px;
            display: flex;
            justify-content: flex-end;
            align-items: center;
        }

        /* 버튼 스타일 */
        .header button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
            margin-left: 10px;
        }

        .header button:hover {
            background-color: #495057;
        }

        /* 테이블 스타일 */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            padding: 12px;
            border: 1px solid #dee2e6;
            text-align: center;
        }

        table th {
            background-color: #f8f9fa;
            font-weight: bold;
        }

        table td {
            color: #343a40;
        }

        .button-group {
            margin-top: 20px;
            margin-right: 10px;
            display: flex;
            justify-content: flex-end;
        }

        .button-group button {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            margin-left: 10px;
        }

        .btn-black {
            background-color: #343a40;
            color: white;
        }

        .btn-blue {
            background-color: #007bff;
            color: white;
        }

        .btn-red {
            background-color: #dc3545;
            color: white;
        }

        /* 미디어 쿼리: 화면 축소에 대응하는 레이아웃 */
        @media (max-width: 1200px) {
            .content-wrapper {
                width: 100%;
                padding: 10px;
            }

            .header {
                flex-direction: column;
                align-items: flex-start;
            }

            .header button {
                width: 100%;
                margin-top: 10px;
            }
        }

        footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px 20px;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="wrapper">
    <div class="sidebar">
        <h3><span style="color: #ffffff">재고관리 </span>&nbsp; | 거래처관리</h3>
        <ul>
            <li><a href="moveprMenu_product.do">제품관리</a></li>
            <li><a href="moveprMenu_porder.do">발주관리</a></li>
            <li><a href="moveprMenu_order.do">수주관리</a></li>
            <li class="active"><a href="moveprMenu_client.do">거래처관리</a></li>
        </ul>
    </div>
    
    <div class="content-wrapper">
		<div class="header">
	    <!-- 전체메뉴 버튼 (상단 오른쪽에 배치됨) -->
		    <button onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
		    <button onclick="location.href='/bizconnect/prManagement.do'">재고관리 Home</button>
		    <button onclick="location.href='/bizconnect/logout.do'" class="btn">로그아웃</button>     
		</div>

    <div class="content">
    <h1 style="font-family: 'Segoe UI', sans-serif; font-size: 24px; color: white;
    background-color: #343a40; padding: 10px; border-radius: 5px;">거래처관리 ▸ 거래처조회</h1>


        <div class="search-bar">
            <select>
                <option>거래처명</option>
            </select>
            <input type="text" placeholder="검색어를 입력하세요">
            <button>전체보기</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>회사명(회사코드)</th>
                    <th>사업자번호</th>
                    <th>담당자명</th>
                    <th>거래처업종</th>
                    <th>거래처전화번호</th>
                    <th>거래처주소</th>
                    <th>거래처이메일</th>
                    <th>거래처팩스번호</th>
                    <th>수정일</th>
                    <th>수정 / 삭제</th>
                    <th>상세</th>
                </tr>
            </thead>
            <tbody>
              
            </tbody>
            <tfoot>
                <c:forEach items="${ client }" var="c"><tr>
            	<tr>

                    <td>${ c.getClientName() }(${ c.getClientCode() })</td>
                    <td>${ c.getBusinessNum() }</td>
                    <td>${ c.getPersonCharge() }</td>
                    <td>${ c.getBusinessType() }</td>
                    <td>${ c.getClientTel() }</td>
                    <td>${ c.getClientAddr() }</td>
                    <td>${ c.getClientEmail() }</td>
                    <td>${ c.getClientFax() }</td>
                    <td>${ c.getModifiDate() }</td>
        
                    
                    <td>
                    	<button class="updateBTN" onclick="updateBTN('${ c.getClientCode() }'); return false;">수정 / 상세</button>
                    </td>
                    <td>
                    	<button class="deleteBTN" onclick="deleteBTN('${ c.getClientCode() }'); return false;">삭 제</button>	
                    </td>
			    </tr>
			    </c:forEach>
                
            </tfoot>
        </table>

        <div class="button-group">
            <button class="btn-black">전체선택</button>
<!--             <button class="btn-blue">뭘로 하징</button> -->
            <button class="btn-red" onclick="javascript:location.href='moveClientInsert.do'; return false;">거래처 등록</button>
           <!--  <button class="btn-blue" onclick="javascript:location.href='/bizconnect/ordreport.do'; return false;">거래명세서 작성</button> -->
        </div>

    </div>

</body>
</html>