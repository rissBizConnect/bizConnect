<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>퇴직자 추가</title>
</head>
<body>
<h1>퇴직자 추가</h1>

<form action="retAdd.do" method="get">
    GID: <input type="text" name="gid" required/><br/>
    회사 코드: <input type="text" name="comCode" required/><br/>
    퇴직자 사번: <input type="text" name="retNo" required/><br/>
    입사일: <input type="date" name="userEntryDate" required/><br/>
    퇴사일: <input type="date" name="retDate" required/><br/>
    총 근무일: <input type="text" name="retTotalDate" required/><br/>
    고용형태: <input type="text" name="retType" required/><br/>
    비고: <input name="exitReason"></input><br/>
    <input type="submit" value="추가"/>
</form>

<a href="retList.do">목록으로 돌아가기</a>
</body>
</html>