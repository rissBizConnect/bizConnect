function memberDelete(gid) {
	location.href = "infoDelete.do?gId=" + gid;
}

function memberUpdate(gid) {
	location.href = "moveInfoUpdate.do?gId=" + gid;
}

function memberRetireUpdate(gid) {
	location.href = "memberRetireUpdate.do?gId=" + gid;
}


function test() {
	alert('전송에 실패했습니다.');
}
