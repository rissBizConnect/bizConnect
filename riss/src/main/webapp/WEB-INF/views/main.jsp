<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP 마이페이지</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

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
            justify-content: flex-start;
            align-items: flex-start;
            width: 100%;
            min-height: 100vh;
        }

        /* 사이드바 스타일 */
        .sidebar {
            width: 250px;
            background-color: #343a40; /* 다크 그레이 */
            padding: 20px;
            height: 100vh;
            color: white;
        }

        .sidebar h3 {
            color: #ffc107; /* 노란색 로고 텍스트 */
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

        .sidebar ul li a:hover {
            background-color: #495057;  /* 약간 밝은 회색 */
        }

        /* 콘텐츠 영역 스타일 */
        .content-wrapper {
            display: flex;
            justify-content: center;
            width: 100%;
        }

        .content {
            width: 100%;
            max-width: 1200px;
            padding: 20px;
            box-sizing: border-box;
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
            background-color: #343a40; /* 사이드바와 동일한 다크 그레이 */
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
            margin-left: 10px;
        }

        .header button:hover {
            background-color: #495057; /* 약간 밝은 회색 */
        }

        /* 프로필 정보 섹션 스타일 */
        .profile-info-section {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            display: flex;
            justify-content: space-between; /* 테이블과 사진을 양 끝으로 */
            align-items: center; /* 중앙 정렬 */
        }

        /* 테이블 스타일 */
        .profile-info-section table {
            width: 60%; /* 테이블 너비 조정 */
            max-width: 600px;
            margin-right: 20px;
            border-collapse: collapse;
        }

        table td {
            padding: 12px;
            border: 1px solid #dee2e6;
            color: #343a40; /* 다크 그레이 */
        }

        table tr td:first-child {
            font-weight: bold;
            width: 150px;
            background-color: #495057; /* 짙은 회색 */
            color: white;
        }

        /* 프로필 사진 스타일 */
        .profile-photo {
            width: 200px;
            height: 200px;
            border-radius: 5px; /* 네모 모양으로 변경 */
            background-color: #dee2e6;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 18px;
            color: #343a40;
            margin-left: auto; /* 오른쪽 끝에 고정 */
        }

        /* 미디어 쿼리: 화면 축소에 대응하는 레이아웃 */
        @media (max-width: 1200px) {
            .content {
                max-width: 800px;
            }

            .header {
                flex-direction: column;
                align-items: flex-start;
            }

            .header button {
                width: 100%;
                margin-top: 10px;
            }

            .profile-info-section {
                flex-direction: column;
                align-items: center;
            }

            .profile-info-section table {
                width: 100%;
            }

            .profile-photo {
                margin-top: 20px;
                width: 120px;
                height: 120px;
            }
        }
        footer {
    background-color: #343a40; /* 푸터 배경색 (파란색) */
    color: white; /* 푸터 텍스트 색상 (흰색) */
    text-align: center; /* 가운데 정렬 */
    padding: 10px 20px; /* 상하 10px, 좌우 20px 패딩 */
    position: relative; /* 상대적 위치 설정 */
    bottom: 0; /* 아래쪽 위치 */
    width: 100%; /* 너비 100% */
}
    </style>
</head>
<body>

<div class="wrapper">
    <!-- 사이드바 -->
    <div class="sidebar">
        <h3>ERP Connect</h3>
        <ul>
            <li><a href="/bizconnect/main.do">마이페이지</a></li>
            <li><a href="/bizconnect/profileUpdate.do">개인정보 변경</a></li>
            <li><a href="/bizconnect/companyInfo.do">기업 정보</a></li>
            <li><a href="/bizconnect/supportList.do">고객센터</a></li>
        </ul>
    </div>

    <!-- 콘텐츠와 헤더를 포함한 메인 콘텐츠 -->
    <div class="content-wrapper">
        <div class="content">
            <!-- 헤더 -->
            <div class="header">
                <button onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
                <button onclick="location.href='/bizconnect/logout.do'" class="btn">로그아웃</button>
            </div>

            <!-- 프로필 정보 섹션 -->
            <div class="profile-info-section">
                <!-- 테이블 섹션 -->
                <table class="table table-striped">
                    <tr>
                        <td>이름</td>
                        <td>${loginUser.userName}</td>
                    </tr>
                    <tr>
                        <td>GID</td>
                        <td>${loginUser.gId}</td>
                    </tr>
                    <tr>
                        <td>소속</td>
                        <td>${loginUser.comCode}</td>
                    </tr>
                    <tr>
                        <td>역할</td>
                        <td>${loginUser.userRole}</td>
                    </tr>
                    <tr>
                        <td>직무</td>
                        <td>${loginUser.userJob}</td>
                    </tr>
                    <tr>
                        <td>입사일</td>
                        <td>${loginUser.userEntry}</td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td>${loginUser.userPhone}</td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td>${loginUser.userEmail}</td>
                    </tr>

                </table>

                <!-- 프로필 사진 섹션 -->
                <div class="profile-photo">
                    사진
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<div class="footerPos">
		<c:import url="/WEB-INF/views/common/footer.jsp" />
	</div>
</body>
</html>
