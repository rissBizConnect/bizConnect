<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bizconnect - 퇴직자 관리</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/styles.css">
    <style>
        /* 추가된 CSS 스타일 */
        body {
            margin: 0; /* 기본 마진 제거 */
            padding-top: 100px; /* 고정된 헤더 높이만큼 여백 추가 */
            display: flex; /* Flexbox를 사용하여 레이아웃 설정 */
        }

        header {
            position: fixed; /* 고정 위치 */
            top: 0; /* 상단 고정 */
            left: 0; /* 왼쪽 고정 */
            right: 0; /* 오른쪽 고정 */
            display: flex;
            justify-content: space-between; /* 왼쪽과 오른쪽을 공간을 둬서 배치 */
            align-items: center; /* 수직 중앙 정렬 */
            padding: 10px;
            background-color: #87CEEB; /* 하늘색 배경 */
            z-index: 1000; /* 다른 요소 위에 표시 */
        }

        .top-navigation {
            position: fixed; /* 고정 위치 */
            top: 45px; /* 상단 고정 */
            left: 0; /* 왼쪽 고정 */
            right: 0; /* 오른쪽 고정 */
            display: flex;
            justify-content: center; /* 중앙 정렬 */
            flex-grow: 1; /* 남은 공간을 차지하게 함 */
        }

        .nav-links {
            display: flex;
            position: fixed; /* 고정 위치 */
            top: 80px;
            gap: 20px; /* 링크 간의 간격 */
        }

        .nav-links a {
            text-decoration: none; /* 링크 밑줄 제거 */
            color: #333; /* 링크 색상 (필요에 따라 수정) */
        }

        .nav-links a:hover {
            color: #007bff; /* 링크 호버 색상 (필요에 따라 수정) */
        }

        /* 왼쪽 네비게이션 바 스타일 */
        aside {
            width: 250px; /* 왼쪽 네비게이션 바 너비 설정 */
            flex-shrink: 0; /* 너비 고정 */
            padding-top: 100px; /* 헤더 높이 만큼 여백 추가 */
        }

        .user-actions {
            display: flex;
            gap: 10px; /* 버튼 간의 간격 */
        }

        /* 나머지 스타일 유지 */
    </style>
</head>
<body>
    <!-- 상단 바 및 네비게이션 바 통합 -->
    <header>
        <div class="logo">
            <h1>Bizconnect</h1>
        </div>
        <div class="nav-group" style="flex-grow: 1; display: flex; justify-content: space-between; align-items: center;">
            <nav class="top-nav">
                <div class="user-actions">
                    <button onclick="goToMypage()">마이페이지</button>
                    <button onclick="logout()">로그아웃</button>
                </div>
            </nav>
            <!-- 추가된 상단 네비게이션 바 -->
            <nav class="top-navigation">
                <div class="nav-links">
                    <a class="hr" href="#" onclick="loadPage('인사관리')">인사관리</a>
                    <a class="pd" href="#" onclick="loadPage('재고관리')">재고관리</a>
                    <a class="cs" href="#" onclick="loadPage('회계관리')">회계관리</a>
                </div>
            </nav>
        </div>
    </header>

    <div class="container" style="display: flex; width: 100%;">
        <!-- 왼쪽 네비게이션 바 -->
        <aside>
            <nav>
                <ul class="side-menu">
                    <li><a href="#">인사 관리</a></li>
                    <li class="has-submenu" id="attendance">
                        <a href="#" onclick="toggleSubmenu('attendance')">근태관리</a>
                        <ul class="submenu" id="attendance-submenu">
                            <li><a href="#" onclick="loadPage('출퇴근 근태')">출퇴근 근태</a></li>
                            <li><a href="#" onclick="loadPage('연차')">연차</a></li>
                        </ul>
                    </li>
                    <li><a href="#" onclick="loadPage('사원명')">사원명</a></li>
                    <li class="has-submenu" id="salary">
                        <a href="#" onclick="toggleSubmenu('salary')">급여관리</a>
                        <ul class="submenu" id="salary-submenu">
                            <li><a href="#" onclick="loadPage('급여')">급여</a></li>
                        </ul>
                    </li>
                    <li class="has-submenu" id="retiree">
                        <a href="#" onclick="toggleSubmenu('retiree')">퇴직자관리</a>
                        <ul class="submenu" id="retiree-submenu">
                            <li><a href="#" onclick="loadPage('퇴직자')">퇴직자</a></li>
                            <li><a href="#" onclick="loadPage('퇴직자->사원')">퇴직자 -> 사원</a></li>
                        </ul>
                    </li>
                    <li class="has-submenu" id="document">
                        <a href="#" onclick="toggleSubmenu('document')">서류관리</a>
                        <ul class="submenu" id="document-submenu">
                            <li><a href="#" onclick="loadPage('계약서')">계약서</a></li>
                            <li><a href="#" onclick="loadPage('증명서')">증명서</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </aside>

        <!-- 메인 콘텐츠 -->
        <main id="content" style="flex-grow: 1; padding-top: 100px;">
            <section class="dashboard">
                <h2>퇴직자 관리</h2>
                <div class="info-box">
                    <p>여기에서 퇴직자 정보를 관리할 수 있습니다.</p>
                    <button onclick="loadPage('퇴직자관리')">퇴직자 관리로 이동</button>
                </div>
            </section>
        </main>
    </div>

    <!-- 하단 바 -->
    <footer>
        <p>&copy; 2024 Bizconnect. All Rights Reserved.</p>
    </footer>

    <!-- JavaScript 파일 경로 -->
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>
