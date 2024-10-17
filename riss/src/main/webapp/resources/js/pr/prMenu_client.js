function test() {
	
	alert('전송에 실패했습니다.');
}

function updateBTN(ClientCode) {
	location.href = "moveClientUpdate.do?ClientCode=" + ClientCode;
}


function deleteBTN(ClientCode) {

	location.href = "clientDelete.do?ClientCode=" + ClientCode;
}

