function test() {
	
	alert('전송에 실패했습니다.');
}

function updateBTN(productNo) {
	location.href = "moveProductUpdate.do?productNo=" + productNo;
}


function deleteBTN(productNo) {
	location.href = "moveproDuctUpdate.do?productNo=" + productNo;
}

