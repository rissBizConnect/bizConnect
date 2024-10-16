<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>퇴직자 목록</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/common/styles.css'/>">
</head>
<body>
<div class="front">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<c:import url="/WEB-INF/views/common/menubar.jsp" />
		<div class = contentPos>
<h1>퇴직자 목록</h1>

<!-- 검색 폼 -->
<form action="retList.do" method="get">
    GID: <input type="text" name="gid" value="${param.gid}"/>
    회사 코드: <input type="text" name="comCode" value="${param.comCode}"/>
    퇴직자 사번: <input type="text" name="retNo" value="${param.retNo}"/>
    입사일: <input type="text" name="userEntryDate" value="${param.userEntryDate}"/>
    퇴사일: <input type="text" name="retDate" value="${param.retDate}"/>
    고용형태: <input type="text" name="retType" value="${param.retType}"/>
    <input type="submit" value="검색"/>
</form>

<!-- 추가 버튼 -->
<a href="retireAddForm.do">퇴직자 추가</a>

<!-- 퇴직자 목록 테이블 -->
<table border="1">
    <thead>
        <tr>
            <th>퇴직자 사번</th>
            <th>고용형태</th>
            <th>비고</th>
            <th>퇴사일</th>
            <th>총 근무일</th>
            <th>수정</th>
            <th>삭제</th>
            <th>사원 전환</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="retire" items="${list}">
            <tr>
                <td>${retire.retNo}</td>
                <td>${retire.retType}</td>
                <td>${retire.exitReason}</td>
                <td>${retire.retDate}</td>
                <td>${retire.retTotalDate}</td>            
                <td><a href="retireEditForm.do?retNo=${retire.retNo}">수정</a></td>
                <td><a href="retDelete.do?retNo=${retire.retNo}" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a></td>
                <td><form action="convertRetireToMember.do" method="post">
   						<input type="text" name="gId" placeholder="GID 입력하세요" required />
    					<input type="text" name="comCode" placeholder="comCode 입력하세요" required />
    					<button type="submit">퇴직자에서 사원 변환</button>
					</form>
                             
               </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class = "paging"><c:import url="/WEB-INF/views/common/pagingView.jsp" />
</div>
</div>
<%-- <!-- 페이징 처리 -->
<div>
    <c:if test="${paging.totalPage > 1}">
        <c:forEach var="page" begin="1" end="${paging.totalPage}">
            <c:choose>
                <c:when test="${page == paging.currentPage}">
                    <strong>${page}</strong>
                </c:when>
                <c:otherwise>
                    <a href="retList.do?currentPage=${page}&gid=${param.gid}&comCode=${param.comCode}&retNo=${param.retNo}&userEntryDate=${param.userEntryDate}&retDate=${param.retDate}&retType=${param.retType}">${page}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:if>
</div> --%>
		<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
