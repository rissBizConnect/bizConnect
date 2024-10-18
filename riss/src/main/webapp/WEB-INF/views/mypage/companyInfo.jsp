<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업 등록 및 정보</title>
    
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

        /* 폼 스타일 */
        form {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            font-weight: bold;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        button:hover {
            background-color: #0056b3;
        }

        footer {
            background-color: #343a40; /* 푸터 배경색 */
            color: white; /* 푸터 텍스트 색상 */
            text-align: center; /* 가운데 정렬 */
            padding: 10px 20px;
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

            <!-- 기업 등록 및 정보 섹션 -->
            <h1>기업 등록 및 정보</h1>
            <p>기업 관련 정보를 등록하거나 수정할 수 있는 페이지입니다.</p>

            <form action="/bizconnect/companyInfoAction.do" method="post">
                <label for="companyName">회사 이름:</label>
                <input type="text" id="companyName" name="companyName">

                <label for="companyAddress">회사 주소:</label>
                <input type="text" id="companyAddress" name="companyAddress">

                <label for="companyPhone">회사 전화번호:</label>
                <input type="text" id="companyPhone" name="companyPhone">

                <button type="submit">등록</button>
            </form>
        </div>
    </div>
</div>

<footer>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</footer>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
