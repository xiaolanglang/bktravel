$(function() {
	$("#del-image").click(function() {
		$(".item").remove();
		$("#select-file").show();
	});

	$("#imgFile").bind("change", function() {
		var file = $(this).val();
		var pos = file.lastIndexOf("\\");
		var fileName = file.substring(pos + 1);
		$("#file-name").text(fileName);
	})
})