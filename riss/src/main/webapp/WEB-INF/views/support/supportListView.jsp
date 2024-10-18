<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 게시판</title>
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
    background-color: #343a40;
    padding: 20px;
    height: 100vh;
    color: white;
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
    background-color: #495057;
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

/* 콘텐츠 영역 스타일 */
.content-wrapper {
    display: flex;
    justify-content: center;
    width: 100%;
    padding-top: 0px; /* Removed unnecessary padding */
}

.content {
    width: 100%;
    max-width: 1200px;
    padding: 10px 20px;  /* Reduced padding to bring it upwards */
    box-sizing: border-box;
    margin-top: -30px;  /* Move content upwards */
}

/* 헤더 스타일 */
.header {
    background-color: #ffffff;
    padding: 10px 20px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin-bottom: 15px;
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
            background-color: #495057; /* 약간 밝은 회색 */
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

<div class="content-wrapper">
    <!-- 콘텐츠 영역 -->
    <div class="content">
        <!-- 상단 헤더 -->
        <div class="header">
            <button onclick="location.href='/bizconnect/menu.do'">메인페이지</button>
            <button onclick="location.href='/bizconnect/logout.do'" class="btn">로그아웃</button>
        </div>

        <h1>고객센터 게시판</h1>
        <!-- 항목별 검색 기능 추가 -->
        <fieldset id="ss">
            <legend>검색할 항목을 선택하세요.</legend>
            <input type="radio" name="item" id="title" checked> 제목 &nbsp;
            <input type="radio" name="item" id="content"> 내용 &nbsp;
            <input type="radio" name="item" id="date"> 등록날짜 &nbsp;
        </fieldset>

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
		<br>
		<!-- 게시글 추가 버튼 -->
        <button onclick="location.href='<c:url value="/supportWriteForm.do"/>'">게시글 추가</button>
    
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
        <c:import url="/WEB-INF/views/common/pagingView.jsp" />
	</div>
</div>
</div>
<footer>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
    
</footer>

</body>
</html>
