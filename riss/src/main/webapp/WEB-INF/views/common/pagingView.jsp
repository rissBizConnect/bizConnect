<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/click.css?after">
	<script src="${pageContext.request.contextPath}/resources/js/click.js" charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
      <div class="clock">
        <label style="--i: 1"><span>1</span></label>
        <label style="--i: 2"><span>2</span></label>
        <label style="--i: 3"><span>3</span></label>
        <label style="--i: 4"><span>4</span></label>
        <label style="--i: 5"><span>5</span></label>
        <label style="--i: 6"><span>6</span></label>
        <label style="--i: 7"><span>7</span></label>
        <label style="--i: 8"><span>8</span></label>
        <label style="--i: 9"><span>9</span></label>
        <label style="--i: 10"><span>10</span></label>
        <label style="--i: 11"><span>11</span></label>
        <label style="--i: 12"><span>12</span></label>
        <div class="indicator">
          <span class="hand hour"></span>
          <span class="hand minute"></span>
          <span class="hand second"></span>
        </div>
      </div>
      <div class="mode-switch">Dark Mode</div>
    </div>

</body>
</html>