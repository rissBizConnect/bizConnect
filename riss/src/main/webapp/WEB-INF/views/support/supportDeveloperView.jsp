<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객센터 상세보기 (관리자용)</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 20px;
        }

        .detail-view {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .detail-view th, .detail-view td {
            padding: 10px;
        }

        .detail-view th {
            width: 150px;
            background-color: #f0f0f0;
        }

        .btn-container {
            text-align: center;
            margin-top: 20px;
        }

        .btn-custom {
            margin-right: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
        }

        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>

    <script type="text/javascript">
        // 수정 페이지로 이동하는 함수
        function moveUpdatePage() {
            location.href = "${nup}";
        }

        // 삭제 요청하는 함수
        function requestDelete() {
            if (confirm("정말 삭제하시겠습니까?")) {
                location.href = "${ndel}";
            }
        }
    </script>
</head>
<body>

<div class="container">
    <div class="detail-view">
        <h2 class="text-center mb-4">${support.supportNo} 번 공지글 상세보기 (관리자용)</h2>
        <table class="table table-bordered">
            <tr>
                <th>제 목</th>
                <td>${support.supportTitle}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${support.supportWriter}</td>
            </tr>
            <tr>
                <th>등록날짜</th>
                <td><fmt:formatDate value="${support.supportDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
            <tr>
                <th>중요도</th>
                <td>${support.importance}</td>
            </tr>
            <tr>
                <th>중요도 설정 종료 날짜</th>
                <td><fmt:formatDate value="${support.impEndDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td>
                    <c:choose>
                        <c:when test="${!empty support.originalFilePath}">
                            <a href="${nfdown}">${support.originalFilePath}</a>
                        </c:when>
                        <c:otherwise>
                            첨부 파일 없음
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>내 용</th>
                <td>${support.supportContent}</td>
            </tr>
        </table>

        <div class="btn-container">
            <button class="btn btn-primary btn-custom" onclick="moveUpdatePage();">수정페이지로 이동</button>
            <button class="btn btn-danger btn-custom" onclick="requestDelete();">삭제하기</button>
            <button class="btn btn-secondary btn-custom" onclick="location.href='${pageContext.servletContext.contextPath}/supportList.do';">목록</button>
            <button class="btn btn-secondary btn-custom" onclick="history.go(-1);">이전 페이지로 이동</button>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="text-center mt-4 py-3" style="background-color: #343a40; color: white;">
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
