function salaryDelete(...salary) {
	const[gId, salaryno] = salary;
	location.href = "salaryDelete.do?gId=" + gId + "&salaryno=" + salaryno;
}

function salaryUpdate(...salary) {
	const[gId, salaryNo, name] = salary;
	location.href = "moveSalaryUpdate.do?gId=" + gId + "&salaryNo=" + salaryNo + "&name=" + name;
}

function test() {
	alert('전송에 실패했습니다.');
}
