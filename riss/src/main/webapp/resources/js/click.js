document.addEventListener("DOMContentLoaded", () => {
const body = document.querySelector("body"),
  hourHand = document.querySelector(".hour"),
  minuteHand = document.querySelector(".minute"),
  secondHand = document.querySelector(".second"),
  modeSwitch = document.querySelector(".mode-switch");

// 로컬스토리지에 이미 dark mode가 세팅되었는지 확인한다.
if (localStorage.getItem("mode") === "Dark Mode") {
  // body에 dark라는 클래스를 추가하고, modeSwitch 텍스트를"Light Mode"로 바꿔줌.
  body.classList.add("dark");
  modeSwitch.textContent = "Light Mode";
}

modeSwitch.addEventListener("click", () => {
  // body 요소에서 "dark" 클래스를 토글한다.
  body.classList.toggle("dark");
  // body 요소에 "dark" 클래스가 현재 존재하는지 확인한다.
  const isDarkMode = body.classList.contains("dark");
  // "dark" 클래스 존재에 따라 modeSwitch 텍스트 설정
  modeSwitch.textContent = isDarkMode ? "Light Mode" : "Dark Mode";
  // "dark" 클래스 존재에 따라 localStorage "mode" 항목 설정
  localStorage.setItem("mode", isDarkMode ? "Dark Mode" : "Light Mode");
});

const updateTime = () => {
  // 현재의 시간을 받아오고 시침바늘의 각도를 계산
  let date = new Date(),
    secToDeg = (date.getSeconds() / 60) * 360,
    minToDeg = (date.getMinutes() / 60) * 360,
    hrToDeg = (date.getHours() / 12) * 360;
  secondHand.style.transform = `rotate(${secToDeg}deg)`;
  minuteHand.style.transform = `rotate(${minToDeg}deg)`;
  hourHand.style.transform = `rotate(${hrToDeg}deg)`;
};

// 매 초당 시침이 바뀌게
setInterval(updateTime, 1000);

updateTime();
});