<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
    <c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>퇴직자 목록</title>
    <style type="text/css">
        fieldset#search {
            width: 650px;
            position: relative;
            left: 450px;
        }
        form fieldset {
            width: 600px;
        }
        form.searchForm {
            background: lightgray;
            width: 650px;
            position: relative;
            left: 450px;
            display: none;  /* 기본적으로 숨김 */
        }
    </style>
    <script type="text/javascript" src="/first/resources/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('input[name=item]').on('change', function(){
                $('form.searchForm').hide(); // 모든 검색 폼 숨김
                $('input[name=item]').each(function(index){
                    if($(this).is(':checked')){
                        $('form.searchForm').eq(index).show(); // 체크된 폼만 보여줌
                    }
                });
            });
        });
    </script>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<h1 align="center">퇴직자 목록</h1>

<center>
    <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath}/retireeAdd.jsp';">퇴직자 추가</button>		
</center>

<!-- 항목별 검색 기능 -->
<fieldset id="search">
    <legend>검색할 항목을 선택하세요.</legend>
    <input type="radio" name="item" id="name"> 이름 &nbsp;
    <input type="radio" name="item" id="entryDate"> 입사일 &nbsp;
    <input type="radio" name="item" id="retirementDate"> 퇴사일 &nbsp;
</fieldset>

<!-- 검색 항목별 값 입력 전송용 폼 만들기 -->
<!-- 이름 검색 폼 -->
<form action="retireeSearchByName.do" class="searchForm" method="get">
    <input type="hidden" name="action" value="name">
    <fieldset>
        <legend>검색할 이름을 입력하세요.</legend>
        <input type="search" name="keyword" size="50"> &nbsp;
        <input type="submit" value="검색">
    </fieldset>
</form>

<!-- 입사일 검색 폼 -->
<form action="retireeSearchByEntryDate.do" class="searchForm" method="get">
    <input type="hidden" name="action" value="entryDate">
    <fieldset>
        <legend>검색할 입사일을 선택하세요.</legend>
        <input type="date" name="begin"> ~ <input type="date" name="end"> &nbsp;
        <input type="submit" value="검색">
    </fieldset>
</form>

<!-- 퇴사일 검색 폼 -->
<form action="retireeSearchByRetirementDate.do" class="searchForm" method="get">
    <input type="hidden" name="action" value="retirementDate">
    <fieldset>
        <legend>검색할 퇴사일을 선택하세요.</legend>
        <input type="date" name="begin"> ~ <input type="date" name="end"> &nbsp;
        <input type="submit" value="검색">
    </fieldset>
</form>

<br>
<center>
    <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/retireeList.do?page=1';">목록</button> &nbsp; &nbsp;
</center>
<br>

<!-- 조회된 퇴직자 목록 출력 -->
<table align="center" width="650" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>입사일</th>
        <th>퇴사일</th>
        <th>고용형태</th>
        <th>작업</th>
    </tr>
    <c:forEach items="${ requestScope.retireeList }" var="retiree">
        <tr>
            <td align="center">${ retiree.retireeId }</td>
            <td align="left">${ retiree.retireName }</td>
            <td align="center"><fmt:formatDate value="${ retiree.user_entry_date }" pattern="yyyy-MM-dd" /></td>
            <td align="center"><fmt:formatDate value="${ retiree.ret_date }" pattern="yyyy-MM-dd" /></td>
            <td align="center">${ retiree.ret_type }</td>
            <td align="center">
                <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/retireeEdit.do?id=${ retiree.retireeId }';">수정</button>
                <button onclick="javascript:if(confirm('정말 삭제하시겠습니까?')) location.href='${ pageContext.servletContext.contextPath }/retireeDelete.do?id=${ retiree.retireeId }';">삭제</button>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<!-- 페이징 출력 뷰 포함 처리 -->
<c:import url="/WEB-INF/views/common/pagingView.jsp" />

<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
