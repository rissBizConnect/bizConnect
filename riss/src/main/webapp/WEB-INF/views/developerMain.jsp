<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>개발자 대시보드</title>
    <link rel="stylesheet" type="text/css" href="path_to_your_styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h3>사용자 목록</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>계정</th>
                        <th>활성화 여부</th>
                        <th>이름</th>
                        <th>등록일</th>
                    </tr>
                </thead>
                <tbody id="userList">
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.gid}</td>
                            <td><a href="#" onclick="loadUserDetails('${user.gId}')">${user.userName}</a></td>
                            <td>${user.active ? 'O' : 'X'}</td>
                            <td>${user.userName}</td>
                            <td>${user.entryDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/bizconnect/supportList.do">고객센터</a>
        </div>
        
        <div class="content">
            <h3>선택한 사용자 정보</h3>
            <form id="userDetailsForm" action="saveUserDetails.do" method="post">
                <input type="hidden" name="gId" id="gId">
                <table border="1">
                    <tr><th>사용자 GID</th><td id="gIdDisplay"></td></tr>
                    <tr><th>회사 코드</th><td id="comCodeDisplay"></td></tr>
                    <tr><th>이름</th><td id="userNameDisplay"></td></tr>
                    <tr><th>직업</th><td id="userJobDisplay"></td></tr>
                    <tr><th>전화번호</th><td id="userPhoneDisplay"></td></tr>
                    <tr><th>이메일</th><td id="userEmailDisplay"></td></tr>
                    <tr><th>주소</th><td id="userAddrDisplay"></td></tr>
                    <tr><th>입사일</th><td id="userEntryDisplay"></td></tr>
                </table>
                
                <h3>사용자 권한</h3>
                <p>PR 관리 권한: <input type="checkbox" name="prManagement" id="prManagement"></p>
                <p>HR 관리 권한: <input type="checkbox" name="hrManagement" id="hrManagement"></p>
                
                <button type="submit">저장</button>
            </form>
        </div>
    </div>

    <script type="text/javascript">
        function loadUserDetails(gId) {
            $.getJSON("/bizconnect/developer/viewUserDetails.do", { userId: gId }, function(data) {
                $('#gIdDisplay').text(data.gId);
                $('#comCodeDisplay').text(data.comCode);
                $('#userNameDisplay').text(data.userName);
                $('#userJobDisplay').text(data.userJob);
                $('#userPhoneDisplay').text(data.userPhone);
                $('#userEmailDisplay').text(data.userEmail);
                $('#userAddrDisplay').text(data.userAddr);
                $('#userEntryDisplay').text(data.userEntry);
                $('#prManagement').prop('checked', data.prManagement);
                $('#hrManagement').prop('checked', data.hrManagement);
            });
        }
    </script>
</body>
</html>
