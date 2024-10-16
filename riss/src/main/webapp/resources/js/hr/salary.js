function memberDelete(...salary) {
	const[gId, salaryno] = salary;
	location.href = "salaryDelete.do?gId=" + gId + "&salaryno=" + salaryno;
}

function memberUpdate(...salary) {
	const[gId, salaryno] = salary;
	location.href = "moveSalaryUpdate.do?gId=" + gId + "&salaryno=" + salaryno;
}

function test() {
	alert('전송에 실패했습니다.');
}
