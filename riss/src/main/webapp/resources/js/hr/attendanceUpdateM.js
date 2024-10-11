function fileterChange() {
        if ($('select[name=fileterCg]').val() == "all") {
        	location.href = "moveAttendanceUpdateM.do?fileter=all";
        }else if ($('select[name=fileterCg]').val() == "member") {
        	$("#memberFileter").show();
        	$("#dateFileter").hide();
        }else if ($('select[name=fileterCg]').val() == "date") {
        	$("#dateFileter").show();
        	$("#memberFileter").hide();
        }
}

function memberChange(){
	location.href = "moveAttendanceUpdateM.do?fileter=member&smember=" + $('select[name=memberCg]').val();
}
function dateChange() {
}

