function memberDelete(gid) {
	location.href = "infoDelete.do?gId=" + gid;
}

function memberUpdate(gid) {
	location.href = "infoUpdate.do?gId=" + gid;
}

function updateFile(input) {

	const files = event.currentTarget.files;
	const file = files[0];
	
	const reader = new FileReader();  
	reader.onload = (e) => {  //e : event 객체
		$(input).attr('src', e.target.result); 
		$(input).attr('data-file', file.name);
	}
	reader.readAsDataURL(file);
}


function test() {
	alert('전송에 실패했습니다.');
}
