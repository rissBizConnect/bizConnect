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
        /* 전체 레이아웃 설정 */
        body {
            display: flex;
            flex-direction: column;
            height: 100vh; /* 화면 전체 높이 사용 */
            margin: 0;
        }

        /* 헤더 스타일 */
        header {
            background-color: #f4f4f4;
            padding: 10px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        /* 왼쪽 메뉴바 스타일 */
        .menubar {
            width: 200px;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            background-color: #f4f4f4;
            padding: 10px;
            box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);
            z-index: 10; /* 메뉴바가 다른 요소 위에 오도록 설정 */
        }

        /* 중앙 콘텐츠 스타일 */
        .content {
            margin-left: 220px; /* 메뉴바 너비 + 여백 */
            flex: 1; /* 중앙 콘텐츠가 남은 공간을 차지하도록 설정 */
            display: flex;
            flex-direction: column; /* 수직 정렬 */
            padding: 20px;
        }

        /* 버튼 그룹 스타일 */
        .button-group {
            text-align: right; /* 버튼을 오른쪽 정렬 */
            margin-bottom: 20px; /* 버튼과 테이블 간의 여백 */
        }

        /* 푸터 스타일 */
        footer {
            background-color: #f4f4f4;
            padding: 10px;
            text-align: center;
            box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
        }

        /* 테이블 스타일 */
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

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

        /* 필터링 스타일 */
        .filter-group {
            margin-bottom: 20px; /* 필터링 입력 필드와 버튼 간의 여백 */
        }
    </style>
</head>
<body>
    <!-- 헤더 -->
    <header>
         <c:import url="/WEB-INF/views/common/header.jsp" />
    </header>

    <!-- 왼쪽 메뉴바 -->
    <div class="menubar">
        <c:import url="/WEB-INF/views/common/menubar.jsp" />
    </div>

    <!-- 중앙 콘텐츠 -->
    <div class="content">
        <h2>퇴직자 목록</h2>
        <hr>

        <!-- 필터링 그룹 -->
        <div class="filter-group">
            <label for="filterRetNo">퇴직자 사번:</label>
            <input type="text" id="filterRetNo" oninput="filterTable()">
            <label for="filterUserEntryDate">입사일:</label>
            <input type="date" id="filterUserEntryDate" oninput="filterTable()">
            <label for="filterRetDate">퇴사일:</label>
            <input type="date" id="filterRetDate" oninput="filterTable()">
            <label for="filterRetType">고용형태:</label>
            <input type="text" id="filterRetType" oninput="filterTable()">
        </div>

        <!-- 버튼 그룹 -->
        <div class="button-group">
            <button id="openAddRetireePopup">퇴직자추가</button>
            <button id="editSelectedRetiree">수정</button>
            <button id="deleteSelectedRetiree">삭제</button>
        </div>

        <table class="table" border="1" cellspacing="0" id="retireeTable">
            <tr>
                <th>선택</th>
                <th>퇴직자 사번</th>
                <th>유저 GID</th>
                <th>입사일</th>
                <th>퇴사일</th>
                <th>총 근무일</th>
                <th>비고</th>
            </tr>
            <c:forEach var="retire" items="${retireList}">
                <tr>
                    <td><input type="checkbox" class="retire-checkbox" value="${retire.retNo}" /></td>
                    <td>${retire.retNo}</td>
                    <td>${retire.gid}</td>
                    <td>${retire.userEntryDate}</td>
                    <td>${retire.retDate}</td>
                    <td>${retire.retTotalDate}</td>
                    <td>${retire.exitreason}</td>
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

            // 수정 버튼 클릭 시 선택된 퇴직자 수정
            $('#editSelectedRetiree').on('click', function () {
                const selected = $('.retire-checkbox:checked');
                if (selected.length === 0) {
                    alert("수정할 퇴직자를 선택하세요.");
                    return;
                }
                if (selected.length > 1) {
                    alert("한 번에 한 명의 퇴직자만 수정할 수 있습니다.");
                    return;
                }
                const retNo = selected.val();
                window.location.href = `/retire/edit?retNo=${retNo}`;
            });

            // 삭제 버튼 클릭 시 선택된 퇴직자 삭제
            $('#deleteSelectedRetiree').on('click', function () {
                const selected = $('.retire-checkbox:checked');
                if (selected.length === 0) {
                    alert("삭제할 퇴직자를 선택하세요.");
                    return;
                }
                if (confirm("선택한 퇴직자를 정말로 삭제하시겠습니까?")) {
                    const retNos = selected.map(function() { return this.value; }).get().join(',');
                    $.ajax({
                        type: 'POST',
                        url: '/retire/delete',
                        data: { retNos: retNos },
                        success: function(response) {
                            location.reload(); // 페이지 새로고침
                        },
                        error: function() {
                            alert("삭제 중 오류가 발생했습니다.");
                        }
                    });
                }
            });
        });

        // 필터링 함수
        function filterTable() {
            const retNoFilter = document.getElementById("filterRetNo").value.toLowerCase();
            const userEntryDateFilter = document.getElementById("filterUserEntryDate").value;
            const retDateFilter = document.getElementById("filterRetDate").value;
            const retTypeFilter = document.getElementById("filterRetType").value.toLowerCase();

            const table = document.getElementById("retireeTable");
            const rows = table.getElementsByTagName("tr");

            for (let i = 1; i < rows.length; i++) {
                const cells = rows[i].getElementsByTagName("td");
                const retNoText = cells[1].textContent.toLowerCase();
                const userEntryDateText = cells[3].textContent;
                const retDateText = cells[4].textContent;
                const retTypeText = cells[6].textContent.toLowerCase();

                const isRetNoMatch = retNoText.includes(retNoFilter);
                const isUserEntryDateMatch = userEntryDateFilter ? userEntryDateText === userEntryDateFilter : true;
                const isRetDateMatch = retDateFilter ? retDateText === retDateFilter : true;
                const isRetTypeMatch = retTypeText.includes(retTypeFilter);

                if (isRetNoMatch && isUserEntryDateMatch && isRetDateMatch && isRetTypeMatch) {
                    rows[i].style.display = ""; // 일치하는 행 표시
                } else {
                    rows[i].style.display = "none"; // 일치하지 않는 행 숨기기
                }
            }
        }
    </script>
    <!-- 푸터 -->
    <footer>
         <c:import url="/WEB-INF/views/common/footer.jsp" />
    </footer>
</body>
</html>
