<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 게시판</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.header {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    background-color: #f4f4f4;
    padding: 10px 20px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    position: relative;
}

.header button {
    padding: 10px 20px;
    background-color: #ffffff;
    border: 1px solid #ccc;
    cursor: pointer;
    font-weight: bold;
}

.sidebar {
    width: 220px;
    background-color: #f4f4f4;
    padding: 20px;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    height: 100vh;
    float: left;
}

.sidebar ul {
    list-style-type: none;
    padding: 0;
}

.sidebar ul li {
    padding: 10px 0;
}

.sidebar ul li a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
}

.content {
    margin-left: 240px;
    padding: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}

th {
    background-color: #f2f2f2;
    font-weight: bold;
}
</style>
</head>
<body>

    <!-- 상단 헤더 -->
    <div class="header">
        <div class="profile-info">BizConnect</div>
        <button onclick="location.href='<c:url value="/menu.do"/>'">전체메뉴</button>
    </div>

    <!-- 왼쪽 사이드바 -->
    <div class="sidebar">
        <ul>
            <li><a href="<c:url value='/main.do'/>">프로필 정보</a></li>
            <li><a href="<c:url value='/profileUpdate.do'/>">개인정보 변경</a></li>
            <li><a href="<c:url value='/companyInfo.do'/>">기업 등록 및 정보</a></li>
            <li><a href="<c:url value='/supportList.do'/>">고객센터</a></li>
        </ul>
    </div>

    <!-- 콘텐츠 영역 -->
    <div class="content">
        <h1>고객센터 게시판</h1>
        <!-- 항목별 검색 기능 추가 -->
        <fieldset id="ss">
            <legend>검색할 항목을 선택하세요.</legend>
            <input type="radio" name="item" id="title" checked> 제목 &nbsp; 
            <input type="radio" name="item" id="content"> 내용 &nbsp; 
            <input type="radio" name="item" id="date"> 등록날짜 &nbsp;
        </fieldset>

        <!-- 검색 항목별 값 입력 전송용 폼 -->
        <!-- 제목 검색 폼 -->
        <form action="<c:url value='/supportSearchTitle.do'/>" id="titleform" class="sform" method="get">
            <input type="hidden" name="action" value="title">
            <fieldset>
                <legend>검색할 제목을 입력하세요.</legend>
                <input type="search" name="keyword" size="50"> &nbsp; 
                <input type="submit" value="검색">
            </fieldset>
        </form>

        <!-- 내용 검색 폼 -->
        <form action="<c:url value='/supportSearchContent.do'/>" id="contentform" class="sform" method="get">
            <input type="hidden" name="action" value="content">
            <fieldset>
                <legend>검색할 내용을 입력하세요.</legend>
                <input type="search" name="keyword" size="50"> &nbsp; 
                <input type="submit" value="검색">
            </fieldset>
        </form>

        <!-- 등록날짜 검색 폼 -->
        <form action="supportSearchDate.do" id="dateform" class="sform" method="get">
            <input type="hidden" name="action" value="date">
            <fieldset>
                <legend>검색할 등록날짜를 선택하세요.</legend>
                <input type="date" name="begin"> ~ 
                <input type="date" name="end"> &nbsp; 
                <input type="submit" value="검색">
            </fieldset>
        </form>

        <br><br>

        <!-- 조회된 공지사항 목록 출력 -->
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="support" items="${list}">
                    <tr>
                        <td>${support.supportNo}</td>
                        <td><a href="<c:url value='/supportDetail.do'/>?no=${support.supportNo}">${support.supportTitle}</a></td>
                        <td>${support.supportWriter}</td>
                        <td><fmt:formatDate value="${support.supportDate}" pattern="yyyy-MM-dd" /></td>
                        <td>${support.readCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 페이지네이션 -->
        <div class="pagination">
            <c:if test="${currentPage > 1}">
                <a href="<c:url value='/supportList.do'/>?page=${currentPage - 1}">Previous</a>
            </c:if>
            <span>Page ${currentPage}</span>
            <c:if test="${currentPage < totalCount / 10}">
                <a href="<c:url value='/supportList.do'/>?page=${currentPage + 1}">Next</a>
            </c:if>
        </div>

        <!-- 게시글 추가 버튼 -->
        <button onclick="location.href='<c:url value="/supportWriteForm.do"/>'">게시글 추가</button>
    </div>

    <c:import url="/WEB-INF/views/common/pagingView.jsp" />
</body>
</html>
