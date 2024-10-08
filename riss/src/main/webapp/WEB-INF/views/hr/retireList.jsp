<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴직자 목록</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
    <style>
        /* 팝업 스타일 */
        #addRetireePopup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            border: 1px solid black;
            padding: 20px;
            z-index: 1000;
        }
        #popupOverlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }
    </style>
</head>
<body>
    <div class="front">
        <div class="headerPos">
            <c:import url="/WEB-INF/views/common/header.jsp" />
        </div>
        
        <div class="menubarPos">
            <c:import url="/WEB-INF/views/common/menubar.jsp" />
        </div>
        
        <div align= "center">
            <h1>퇴직자 목록</h1>
            <hr>
            <button id="openAddRetireePopup">퇴직자 추가</button>
            <table class="table" border="1" cellspacing="0" width="1000px">
                <tr>
                    <th>퇴직자 사번</th>
                    <th>유저 GID</th>
                    <th>입사일</th>
                    <th>퇴사일</th>
                    <th>총 근무일</th>
                    <th>비고</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
                <c:forEach var="retire" items="${retireList}">
                    <tr>
                        <td>${retire.retNo}</td>
                        <td>${retire.gid}</td>
                        <td>${retire.userEntryDate}</td>
                        <td>${retire.retDate}</td>
                        <td>${retire.retTotalDate}</td>
                        <td>${retire.exitreason}</td>
                        <td><a href="edit/${retire.retNo}">수정</a></td>
                        <td><a href="delete/${retire.retNo}">삭제</a></td>
                    </tr>
                </c:forEach>
            </table>
			</div>
            <!-- 퇴직자 추가 팝업 -->
            <div id="addRetireePopup">
                <h2>퇴직자 추가</h2>
                <form id="addRetireeForm" action="${pageContext.request.contextPath}/retire/add" method="post">
                    <label for="retNo">퇴직자 사번:</label>
                    <input type="text" id="retNo" name="retNo" required><br><br>

                    <label for="gid">유저 GID:</label>
                    <input type="text" id="gid" name="gid" required><br><br>

					<label for="userEntryDate">입사일:</label>
                    <input type="date" id="userEntryDate" name="userEntryDate" required><br><br>
                    
                    <label for="retDate">퇴사일:</label>
                    <input type="date" id="retDate" name="retDate" required><br><br>
     				
     				<label for="retTotalDate">총 근무일:</label>
                    <input type="number" id="retTotalDate" name="retTotalDate" required><br><br>
                    
                    <label for="exitReason">비고:</label>
                    <input type="text" id="exitReason" name="exitReason"><br><br>
               
                    <input type="submit" value="추가">
                    <button type="button" id="closePopup">닫기</button>
                </form>
            </div>

            <!-- 팝업 오버레이 -->
            <div id="popupOverlay"></div>
        </div>
    </div>

    <script>
    
        $(document).ready(function () {
            // 퇴직자 추가 버튼 클릭 시 팝업 열기
            $('#openAddRetireePopup').on('click', function () {
                $('#addRetireePopup').show();
                $('#popupOverlay').show();
            });

            // 팝업 닫기 버튼 클릭 시 팝업 닫기
            $('#closePopup').on('click', function () {
                $('#addRetireePopup').hide();
                $('#popupOverlay').hide();
            });

            // 팝업 제출 처리
            $('#addRetireeForm').on('submit', function (event) {
                event.preventDefault(); // 기본 제출 이벤트 방지

                // AJAX 요청으로 폼 데이터 전송
                $.post($(this).attr('action'), $(this).serialize(), function (response) {
                    alert(response.message); // 응답 메시지 알림
                    if (response.success) {
                        window.location.reload(); // 페이지 새로고침하여 추가된 퇴직자 목록 갱신
                    }
                }, 'json').fail(function() {
                    alert("오류가 발생했습니다. 다시 시도해 주세요."); // 실패 시 알림
                });
            });
        });
    </script>
</body>
</html>
