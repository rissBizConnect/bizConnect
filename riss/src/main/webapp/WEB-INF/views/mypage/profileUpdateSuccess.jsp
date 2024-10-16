<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>개인정보 수정 완료</title>
    <script type="text/javascript">
        window.onload = function() {
            alert("${successMessage}");
            window.location.href = "/bizconnect/main.do"; // 메인 페이지로 리디렉션
        }
    </script>
</head>
<body>
</body>
</html>
