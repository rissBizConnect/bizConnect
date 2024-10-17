function test() {
	
	alert('전송에 실패했습니다.');
}

function cntdn(count) {
	if(Number(count) >1){
	location.href = "moveOrderInsert.do?count=" + (Number(count) - 1);
	}
}


function cntup(count) {

	location.href = "moveOrderInsert.do?count=" + (Number(count) + 1);
}
