<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재고관리 HOME</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

.clock {
    position: relative;
    width: 200px;
    height: 200px;
    border: 10px solid #f0f0f0;
    border-radius: 50%;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.hour-hand, .minute-hand, .second-hand {
    position: absolute;
    width: 50%;
    height: 2px;
    background-color: black;
    top: 50%;
    transform-origin: 100%;
    transform: rotate(90deg);
}
.second-hand {
    background-color: red;
}


        /* Sidebar 스타일 */
        .sidebar {
            width: 250px;
            background-color: #343a40;
            color: white;
            position: fixed;
            top: 0;
            left: 0;
            height: 100vh;
            padding: 20px;
            z-index: 1000;
            box-sizing: border-box;
        }

        .sidebar h3 {
            color: #ffc107;
            margin-bottom: 30px;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 15px;
        }

        .sidebar ul li a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 10px;
            display: block;
            border-radius: 5px;
        }

        .sidebar ul li a:hover {
            background-color: #495057;
        }

        /* Header 스타일 */
        .header {
            background-color: #ffffff;
            padding: 15px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            position: fixed;
            top: 0;
            left: 250px; /* 사이드바의 너비만큼 여백 설정 */
            right: 0;
            display: flex;
            justify-content: flex-end;
            z-index: 1000;
            box-sizing: border-box;
        }

        .header button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-left: 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        .header button:hover {
            background-color: #495057;
        }

        /* Main content 스타일 */
        .main-content {
            margin-left: 250px; /* 사이드바의 너비만큼 여백 설정 */
            margin-top: 60px; /* 헤더의 높이만큼 여백 설정 */
            padding: 20px;
            box-sizing: border-box;
        }

        .dashboard-card {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            text-align: center;
        }

        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .dashboard-card h2 {
            font-size: 1.5rem;
            color: #343a40;
        }

        .dashboard-card p {
            font-size: 1.2rem;
            color: #6c757d;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h3>ERP Connect</h3>
    <ul>
        <li><a href="/bizconnect/moveprMenu_product.do">제품관리</a></li>
        <li><a href="/bizconnect/moveprMenu_porder.do">발주관리</a></li>
        <li><a href="moveprMenu_order.do">수주관리</a></li>
        <li><a href="/bizconnect/moveprMenu_check.do">교환/환불관리</a></li>
        <li><a href="/bizconnect/moveprMenu_client.do">거래처관리</a></li>
    </ul>
</div>

<!-- Header -->
<div class="header">
    <button onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
    <button onclick="location.href='/bizconnect/logout.do'" class="btn">로그아웃</button>
</div>

<!-- Main Content -->
<div class="main-content">
    <h1>재고관리 HOME</h1>
    
    <div class="clock">
        <div class="hour-hand"></div>
        <div class="minute-hand"></div>
        <div class="second-hand"></div>
    </div>
    <!-- 대시보드 카드 레이아웃 -->
    <div class="dashboard-grid">
        <div class="dashboard-card">
            <h2>재고 수량</h2>
            <p>1,500 개</p>
        </div>
        <div class="dashboard-card">
            <h2>발주 대기</h2>
            <p>25 건</p>
        </div>
        <div class="dashboard-card">
            <h2>수주 처리</h2>
            <p>18 건</p>
        </div>
        <div class="dashboard-card">
            <h2>교환/환불 요청</h2>
            <p>3 건</p>
        </div>
    </div>
</div>

</body>
</html>
