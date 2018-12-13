	var count = 0;
	var index = 0;
	
	function setCount(c) {
		count = c;
	}

	$("#btn").click(function() {
		var file = "<div id='a"+index+"'><input type='file' name='f1'><span title='a"+index+"' class='del'>X</span></div>";
		if (count < 5) {
			$("#addFile").append(file);
		} else {
			alert("파일은 최대 5개까지만 가능합니다");
		}
		count++;
		index++;
	});
	$("#addFile").on("click", ".files", function() {
		$(this).parent().remove();
		count--;
	})
