<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Support Update</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        
        .container {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #dee2e6;
        }

        th {
            background-color: #f8f9fa;
            text-align: left;
            width: 30%;
        }

        td input[type="text"], td input[type="date"], td textarea, td input[type="file"] {
            width: 95%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        td textarea {
            resize: none;
        }

        .button-group {
            text-align: center;
            margin-top: 20px;
        }

        .button-group input[type="submit"], .button-group input[type="reset"], .button-group button {
            background-color: #343a40;
            color: white;
            border: none;
            padding: 10px 20px;
            font-weight: bold;
            border-radius: 5px;
            margin-right: 10px;
            cursor: pointer;
        }

        .button-group input[type="submit"]:hover, .button-group input[type="reset"]:hover, .button-group button:hover {
            background-color: #495057;
        }

        .important-checkbox {
            margin-left: 10px;
        }

    </style>
</head>
<body>
    <c:import url="/WEB-INF/views/common/menubar.jsp" />
    <div class="container">
        <h2>${ support.supportNo } 번 지원글 수정 페이지 (관리자용)</h2>
        <form action="updateSupport.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="supportNo" value="${ support.supportNo }">
            <input type="hidden" name="originalFilePath" value="${ support.originalFilePath }">
            <input type="hidden" name="renameFilePath" value="${ support.renameFilePath }">
            <table>
                <tr>
                    <th>제 목</th>
                    <td><input type="text" name="supportTitle" value="${ support.supportTitle }" required></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="supportWriter" readonly value="${ sessionScope.loginUser.userName }"></td>
                </tr>
                <tr>
                    <th>중요도</th>
                    <td>
                        <input type="checkbox" name="importance" value="Y" <c:if test="${ support.importance eq 'Y' }">checked</c:if>> 중요
                        <span class="important-checkbox"></span>
                    </td>
                </tr>
                <tr>
                    <th>중요도 설정 종료 날짜</th>
                    <td><input type="date" name="impEndDate" value="${ support.impEndDate }"></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                        <c:choose>
                            <c:when test="${ !empty support.originalFilePath }">
                                ${ support.originalFilePath } &nbsp;
                                <input type="checkbox" name="deleteFlag" value="yes"> 파일삭제<br>
                                변경: <input type="file" name="upfile">
                            </c:when>
                            <c:otherwise>
                                첨부 파일 없음<br>
                                추가: <input type="file" name="upfile">
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>내 용</th>
                    <td><textarea rows="5" name="supportContent">${ support.supportContent }</textarea></td>
                </tr>
            </table>
            <div class="button-group">
                <input type="submit" value="수정하기">
                <input type="reset" value="수정취소">
                <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/supportList.do'; return false;">목록</button>
                <button onclick="javascript:history.go(-1); return false;">이전 페이지로 이동</button>
            </div>
        </form>
    </div>
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
