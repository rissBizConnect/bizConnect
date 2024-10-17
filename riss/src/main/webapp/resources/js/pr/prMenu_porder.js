function test() {
	
	alert('전송에 실패했습니다.');
}

function updateBTN(orderDiv) {
	location.href = "moveOrderUpdate.do?orderDiv=" + orderDiv;
}


function deleteBTN(...arr) {
	[orderDiv, orderT] = arr;
	location.href = "orderDelete.do?orderDiv=" + orderDiv + "&orderT=" + orderT;
}

