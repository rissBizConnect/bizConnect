<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객센터 상세보기</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background-color: #f4f6f9;
        }

        /* 사이드바 스타일 */
        .sidebar {
            width: 250px;
            background-color: #343a40;
            color: white;
            height: 100vh;
            padding-top: 20px;
            position: fixed;
        }

        .sidebar h3 {
            color: #ffc107;
            text-align: center;
            margin-bottom: 30px;
        }

        .sidebar ul {
            list-style: none;
            padding-left: 0;
        }

        .sidebar ul li {
            margin-bottom: 15px;
        }

        .sidebar ul li a {
            color: white;
            display: block;
            padding: 10px;
            text-decoration: none;
        }

        .sidebar ul li a:hover {
            background-color: #495057;
        }

        /* 콘텐츠 영역 */
        .content-wrapper {
            margin-left: 250px;
            padding: 20px;
        }

        .detail-view {
            background-color: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .detail-view h2 {
            font-weight: bold;
            color: #343a40;
        }

        .info p {
            margin-bottom: 5px;
        }

        /* 버튼 스타일 */
        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }

        .btn-custom:hover {
            background-color: #0056b3;
        }

        footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="wrapper d-flex">
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

        <!-- 메인 콘텐츠 -->
        <div class="content-wrapper">
            <div class="container">
                <!-- 헤더 -->
                <div class="d-flex justify-content-end mb-3">
                    <button class="btn btn-dark me-2" onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
                    <button class="btn btn-dark" onclick="location.href='/bizconnect/logout.do'">로그아웃</button>
                </div>

                <!-- 상세보기 섹션 -->
                <div class="detail-view">
                    <h2>${support.supportTitle}</h2>
                    <div class="info text-muted mb-3">
                        <p>작성자: ${support.supportWriter}</p>
                        <p>작성일: <fmt:formatDate value="${support.supportDate}" pattern="yyyy-MM-dd" /></p>
                        <p>조회수: ${support.readCount}</p>
                    </div>
                    <div class="content-text">
                        <pre>${support.supportContent}</pre>
                    </div>
                </div>

                <!-- 버튼 영역 -->
                <div class="text-center mt-3">
                    <button class="btn btn-custom" onclick="location.href='/bizconnect/supportList.do'">목록</button>
                </div>

                <!-- 관리자용 버튼 -->
                <c:if test="${loginUser != null && loginUser.userRole == 'developer'}">
                    <div class="text-center mt-2">
                        <a href="supportUpdate.do?no=${support.supportNo}" class="btn btn-warning me-2">수정</a>
                        <a href="supportDelete.do?no=${support.supportNo}" class="btn btn-danger">삭제</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <footer>
        <c:import url="/WEB-INF/views/common/footer.jsp" />
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
