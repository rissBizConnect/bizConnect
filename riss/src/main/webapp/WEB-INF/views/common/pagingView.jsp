<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 페이지 표시에 사용될 값들을 변수 선언 --%>
<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />
<c:set var="urlMapping" value="${ requestScope.paging.urlMapping }" />
<c:set var="startPage" value="${ requestScope.paging.startPage }" />
<c:set var="endPage" value="${ requestScope.paging.endPage }" />
<c:set var="maxPage" value="${ requestScope.paging.maxPage }" />

<c:set var="fileter" value="${ requestScope.fileter }" />
<c:set var="keyword" value="${ requestScope.keyword }" />
<c:set var="begin" value="${ requestScope.begin }" />
<c:set var="end" value="${ requestScope.end }" />
<c:set var="smember" value="${ requestScope.smember }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%-- 1. 목록 페이징 처리 : 검색에 대한 목록이 아닌 경우 --%>
<c:if test="${ empty fileter or fileter eq 'all' }">
<div style="text-align: center;">
	<%-- 1page 로 이동 --%>
	<c:if test="${ currentPage eq 1 }">
		[첫페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage gt 1 }">
		<a href="/bizconnect/${ urlMapping }?page=1">[첫페이지로]</a> &nbsp;
	</c:if>
	<%-- 이전 페이지그룹으로 이동 --%>
	<%-- 이전 그룹이 있다면 --%>
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) ge 1 }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage - 10 }">[이전그룹]</a> &nbsp;
	</c:if>
	<%-- 이전 그룹이 없다면 --%>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) ge 1) }">
		[이전그룹] &nbsp;
	</c:if>
	
	<%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
	<c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
		<c:if test="${ p eq currentPage }">
			<font color="blue" size="4"><b>${ p }</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<a href="/bizconnect/${ urlMapping }?page=${ p }">${ p }</a>
			<%-- 예: 페이지 7 클릭시 href="/bizconnect/nlist.do?page=7" 요청 처리됨 --%>
		</c:if>
	</c:forEach>
	
	<%-- 다을 페이지그룹으로 이동 --%>
	<%-- 다음 그룹이 있다면 --%>
	<c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage + 10 }">[다음그룹]</a> &nbsp;
	</c:if>
	<%-- 다음 그룹이 없다면 --%>
	<c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
		[다음그룹] &nbsp;
	</c:if>
	
	<%-- maxPage 로 이동 --%>
	<c:if test="${ currentPage ge maxPage }">
		[맨끝페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ maxPage }">[맨끝페이지로]</a> &nbsp;
	</c:if>
</div>
</c:if>



<%-- 4. 인사 근태 member --%>
<c:if test="${ !empty fileter and fileter eq 'member'}">
<div style="text-align: center;">
	<%-- 1page 로 이동 --%>
	<c:if test="${ currentPage eq 1 }">
		[첫페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage gt 1 }">
		<a href="/bizconnect/${ urlMapping }?page=1&fileter=${ fileter }&smember=${smember}">[첫페이지로]</a> &nbsp;
	</c:if>
	
	<%-- 이전 페이지그룹으로 이동 --%>
	<%-- 이전 그룹이 있다면 --%>
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) ge 1 }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage - 10 }&fileter=${ fileter }&smember=${smember}">[이전그룹]</a> &nbsp;
	</c:if>
	<%-- 이전 그룹이 없다면 --%>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) ge 1) }">
		[이전그룹] &nbsp;
	</c:if>
	
	<%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
	<c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
		<c:if test="${ p eq currentPage }">
			<font color="blue" size="4"><b>${ p }</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<a href="/bizconnect/${ urlMapping }?page=${ p }&fileter=${ fileter }&smember=${smember}">${ p }</a>
			<%-- 예: 페이지 7 클릭시 href="/bizconnect/nlist.do?page=7" 요청 처리됨 --%>
		</c:if>
	</c:forEach>
	
	<%-- 다을 페이지그룹으로 이동 --%>
	<%-- 다음 그룹이 있다면 --%>
	<c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage + 10 }&fileter=${ fileter }&smember=${smember}">[다음그룹]</a> &nbsp;
	</c:if>
	<%-- 다음 그룹이 없다면 --%>
	<c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
		[다음그룹] &nbsp;
	</c:if>
	
	<%-- maxPage 로 이동 --%>
	<c:if test="${ currentPage ge maxPage }">
		[맨끝페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ maxPage }&fileter=${ fileter }&smember=${smember}">[맨끝페이지로]</a> &nbsp;
	</c:if>
</div>
</c:if>

<!-- 5. 인사 근태 date  -->
<c:if test="${ !empty fileter and fileter eq 'date'}">
<div style="text-align: center;">
	<%-- 1page 로 이동 --%>
	<c:if test="${ currentPage eq 1 }">
		[첫페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage gt 1 }">
		<a href="/bizconnect/${ urlMapping }?page=1&fileter=${ fileter }&begin=${ begin }&end=${ end }">[첫페이지로]</a> &nbsp;
	</c:if>
	
	<%-- 이전 페이지그룹으로 이동 --%>
	<%-- 이전 그룹이 있다면 --%>
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) ge 1 }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage - 10 }&fileter=${ fileter }&begin=${ begin }&end=${ end }">[이전그룹]</a> &nbsp;
	</c:if>
	<%-- 이전 그룹이 없다면 --%>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) ge 1) }">
		[이전그룹] &nbsp;
	</c:if>
	
	<%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
	<c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
		<c:if test="${ p eq currentPage }">
			<font color="blue" size="4"><b>${ p }</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<a href="/bizconnect/${ urlMapping }?page=${ p }&fileter=${ fileter }&begin=${ begin }&end=${ end }">${ p }</a>
			<%-- 예: 페이지 7 클릭시 href="/bizconnect/nlist.do?page=7" 요청 처리됨 --%>
		</c:if>
	</c:forEach>
	
	<%-- 다을 페이지그룹으로 이동 --%>
	<%-- 다음 그룹이 있다면 --%>
	<c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage + 10 }&fileter=${ fileter }&begin=${ begin }&end=${ end }">[다음그룹]</a> &nbsp;
	</c:if>
	<%-- 다음 그룹이 없다면 --%>
	<c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
		[다음그룹] &nbsp;
	</c:if>
	
	<%-- maxPage 로 이동 --%>
	<c:if test="${ currentPage ge maxPage }">
		[맨끝페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ maxPage }&fileter=${ fileter }&begin=${ begin }&end=${ end }">[맨끝페이지로]</a> &nbsp;
	</c:if>
</div>
</c:if>

<!-- 6. 인사 근태 work  -->
<c:if test="${ !empty fileter and fileter eq 'work'}">
<div style="text-align: center;">
	<%-- 1page 로 이동 --%>
	<c:if test="${ currentPage eq 1 }">
		[첫페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage gt 1 }">
		<a href="/bizconnect/${ urlMapping }?page=1&fileter=${ fileter }&work=${work }">[첫페이지로]</a> &nbsp;
	</c:if>
	
	<%-- 이전 페이지그룹으로 이동 --%>
	<%-- 이전 그룹이 있다면 --%>
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) ge 1 }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage - 10 }&fileter=${ fileter }&work=${work }">[이전그룹]</a> &nbsp;
	</c:if>
	<%-- 이전 그룹이 없다면 --%>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) ge 1) }">
		[이전그룹] &nbsp;
	</c:if>
	
	<%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
	<c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
		<c:if test="${ p eq currentPage }">
			<font color="blue" size="4"><b>${ p }</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<a href="/bizconnect/${ urlMapping }?page=${ p }&fileter=${ fileter }&work=${work }">${ p }</a>
			<%-- 예: 페이지 7 클릭시 href="/bizconnect/nlist.do?page=7" 요청 처리됨 --%>
		</c:if>
	</c:forEach>
	
	<%-- 다을 페이지그룹으로 이동 --%>
	<%-- 다음 그룹이 있다면 --%>
	<c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage + 10 }&fileter=${ fileter }&work=${work }">[다음그룹]</a> &nbsp;
	</c:if>
	<%-- 다음 그룹이 없다면 --%>
	<c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
		[다음그룹] &nbsp;
	</c:if>
	
	<%-- maxPage 로 이동 --%>
	<c:if test="${ currentPage ge maxPage }">
		[맨끝페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ maxPage }&fileter=${ fileter }&work=${work }">[맨끝페이지로]</a> &nbsp;
	</c:if>
</div>
</c:if>

<!-- 키워드 -->
<c:if test="${ !empty fileter and fileter eq 'keyword'}">
<div style="text-align: center;">
	<%-- 1page 로 이동 --%>
	<c:if test="${ currentPage eq 1 }">
		[첫페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage gt 1 }">
		<a href="/bizconnect/${ urlMapping }?page=1&fileter=${ fileter }&keyword=${keyword}">[첫페이지로]</a> &nbsp;
	</c:if>
	
	<%-- 이전 페이지그룹으로 이동 --%>
	<%-- 이전 그룹이 있다면 --%>
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) ge 1 }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage - 10 }&fileter=${ fileter }&keyword=${keyword}">[이전그룹]</a> &nbsp;
	</c:if>
	<%-- 이전 그룹이 없다면 --%>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) ge 1) }">
		[이전그룹] &nbsp;
	</c:if>
	
	<%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
	<c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
		<c:if test="${ p eq currentPage }">
			<font color="blue" size="4"><b>${ p }</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<a href="/bizconnect/${ urlMapping }?page=${ p }&fileter=${ fileter }&keyword=${keyword}">${ p }</a>
			<%-- 예: 페이지 7 클릭시 href="/bizconnect/nlist.do?page=7" 요청 처리됨 --%>
		</c:if>
	</c:forEach>
	
	<%-- 다을 페이지그룹으로 이동 --%>
	<%-- 다음 그룹이 있다면 --%>
	<c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ startPage + 10 }&fileter=${ fileter }&keyword=${keyword}">[다음그룹]</a> &nbsp;
	</c:if>
	<%-- 다음 그룹이 없다면 --%>
	<c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
		[다음그룹] &nbsp;
	</c:if>
	
	<%-- maxPage 로 이동 --%>
	<c:if test="${ currentPage ge maxPage }">
		[맨끝페이지로] &nbsp;
	</c:if>
	<c:if test="${ currentPage lt maxPage }">
		<a href="/bizconnect/${ urlMapping }?page=${ maxPage }&fileter=${ fileter }&keyword=${keyword}">[맨끝페이지로]</a> &nbsp;
	</c:if>
</div>
</c:if>



</body>
</html>






