// script.js

function goToMypage() {
    // 마이페이지로 이동하는 코드
    alert("마이페이지로 이동합니다.");
}

function logout() {
    // 로그아웃 처리 코드
    alert("로그아웃 처리되었습니다.");
}

function loadPage(pageName) {
    // 페이지 로드 코드
    alert(pageName + " 페이지를 로드합니다.");
}

function toggleSubmenu(menuId) {
    const submenu = document.getElementById(menuId + '-submenu');
    const hasSubmenu = document.getElementById(menuId);
    
    // 서브메뉴 토글
    if (submenu.style.display === "block") {
        submenu.style.display = "none"; // 숨기기
        hasSubmenu.classList.remove('active'); // 클래스 제거
    } else {
        submenu.style.display = "block"; // 보이기
        hasSubmenu.classList.add('active'); // 클래스 추가
    }
}
