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
    <div class="contentPos">
        <h1>퇴직자 목록</h1>

        <!-- 검색 폼 -->
        <form action="retList.do" method="get">
            GID: <input type="text" name="gid" value="${param.gid}"/>
            회사 코드: <input type="text" name="comCode" value="${param.comCode}"/>
            퇴직자 사번: <input type="text" name="retNo" value="${param.retNo}"/>
            입사일: <input type="date" name="userEntryDate" value="${param.userEntryDate}"/>
            퇴사일: <input type="date" name="retDate" value="${param.retDate}"/>
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
                    <th>상태변경</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="retire" items="${list}">
                    <tr id="retire-${retire.retNo}">
                        <td>${retire.retNo}</td>
                        <td>${retire.retType}</td>
                        <td>${retire.exitReason}</td>
                        <td>${retire.retDate}</td>
                        <td>${retire.retTotalDate}</td>
                        <td><a href="retireEditForm.do?retNo=${retire.retNo}">수정</a></td>
                        <td><a href="retDelete.do?retNo=${retire.retNo}" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a></td>
                        <td>${retire.status == 'Y' ? '사원' : '퇴직자'}</td>
                        <td>
								<form action="${pageContext.request.contextPath}/updateRetireToMember.do" method="post">
									<input type="hidden" name="retNo" value="${retire.retNo}" /> 
									<input type="hidden" name="gid" value="${retire.gid}" /> 
									<input type="hidden" name="comCode" value="${retire.comCode}" /> 
									<input type="submit" value="사원으로 변환" />
								</form>
							</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="paging">
            <c:import url="/WEB-INF/views/common/pagingView.jsp" />
        </div>
    </div>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
