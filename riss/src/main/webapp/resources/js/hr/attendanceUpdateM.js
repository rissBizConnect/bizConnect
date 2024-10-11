$(document).ready(function() {
    $("#companyCg").change(function() {
        var selectedValue = $(this).val();
        var url = "";

		$("table").hide();

        // c:if 문처럼 조건에 따라 표시
        if (selectedValue === "category1") {
        	location.href = "/bizconnect/moveAttendance.do";
            $("#table1").show();
        } else if (selectedValue === "category2") {
            $("#table2").show();
        } else {
            $("#table3").show();
        }
    });
});