$("#submitMember").click(function(event){
	var memberData = {
			memberEmail: $("#member_Email").val(),
			memberPWD: $("#member_PWD").val(),
			memberName: $("#member_Name").val(),
			memberGender: $("#member_Gender").val(),
		memberTel: $("#member_Tel").val()
	}
	ajaxSignup(memberData);
});

function ajaxSignup(user) {
	$.ajax({
		url:serverAddr + "/hMember/joinMember.json",
		type: "POST",
		dataType: "json",
		data: user,
		success: function (obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				alert("가입실패 하였습니다. 정확히 입력 후 재시도 해주세요")
				return
			}
			alert("축하합니다 가입되었습니다.")
		},
	});
}
