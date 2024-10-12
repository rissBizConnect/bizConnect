function fileterChange() {
        if ($('select[name=fileterCg]').val() == "all") {
        	location.href = "moveAttendanceUpdateM.do?fileter=all";
        }else if ($('select[name=fileterCg]').val() == "member") {
        	$("#memberFileter").show();
        	$("#dateFileter").hide();
        	$("#workFileter").hide();
        }else if ($('select[name=fileterCg]').val() == "date") {
        	$("#dateFileter").show();
        	$("#memberFileter").hide();
        	$("#workFileter").hide();
        }else if ($('select[name=fileterCg]').val() == "work") {
        	$("#workFileter").show();
        	$("#dateFileter").hide();
        	$("#memberFileter").hide();
        }
}

function memberChange(){
	location.href = "moveAttendanceUpdateM.do?fileter=member&smember=" + $('select[name=memberCg]').val();
}
function dateChange() {
	if($("#begin").val() != null && $("#begin").val().length > 0 && $("#end").val() != null && $("#end").val().length > 0){
		location.href = "moveAttendanceUpdateM.do?fileter=date&begin=" + $("#begin").val() + "&end=" + $("#end").val();
	}
}

function workChange(){
	location.href = "moveAttendanceUpdateM.do?fileter=work&work=" + $("#workCg").val();
}

function moveAttendanceUpdateW(...att) {
	const[gId, day, goDate, outDate] = att;
    var width = 450; 
    var height = 150;
    const screenWidth = window.innerWidth;
    const screenHeight = window.innerHeight;

    const left = (screenWidth / 2) - (width / 2);
    const top = (screenHeight / 2) - (height / 2);

	var url = "/bizconnect/attendanceUpdatePop.do?gId=" + gId + "&day=" + day + "&goDate=" + goDate + "&outDate=" + outDate;
    var option = `width=${width},height=${height},top=${top},left=${left}`;
    windowpop = window.open(url, "일단 그냥", option);

}

function test(){
	alert('전송에 실패했습니다.');
}

function updateAttendance(...att){
	const[gId, day, goDate, outDate] = att;
	location.href = "updateAttendance.do?gId=" + gId + "&day=" + day + "&goD=" + goDate + "&outD=" + outDate;
}
