<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bizconnect 로그인</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #f0f4f8, #b1d1f1);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            animation: fadeIn 1.2s ease;
        }
        @keyframes fadeIn {
            0% {
                opacity: 0;
                transform: translateY(30px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
        .login-title {
            font-size: 28px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 30px;
            color: #343a40;
        }
        .form-control {
            border-radius: 10px;
            padding: 15px;
            font-size: 16px;
        }
        .login-btn {
            background-color: #007bff;
            color: white;
            font-size: 18px;
            padding: 12px;
            border-radius: 10px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        .login-btn:hover {
            background-color: #0056b3;
        }
        .form-label {
            font-weight: bold;
            color: #555;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h1 class="login-title">Bizconnect 로그인</h1>
    <form action="/bizconnect/login.do" method="post">
        <div class="mb-4">
            <label for="gId" class="form-label">아이디</label>
            <input type="text" class="form-control" id="gId" name="gId" placeholder="아이디 입력" required>
        </div>
        <div class="mb-4">
            <label for="userPW" class="form-label">암호</label>
            <input type="password" class="form-control" id="userPW" name="userPW" placeholder="암호 입력" required>
        </div>
        <div class="mb-4">
            <label for="comCode" class="form-label">회사 코드</label>
            <input type="text" class="form-control" id="comCode" name="comCode" placeholder="회사 코드 입력" required>
        </div>
        <button type="submit" class="btn login-btn w-100">로그인</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
