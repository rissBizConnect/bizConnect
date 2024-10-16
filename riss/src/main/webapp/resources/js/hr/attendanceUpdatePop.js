function updateBTN() {
	window.opener.updateAttendance($("#gId").val(), $("#day").val(), $("#goDate").val(), $("#outDate").val());
	window.close();
}

