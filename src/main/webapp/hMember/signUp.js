var checkedEmail;
var checkedPassword;
$(document).ready(function(){
	$("#check_member_PWD").keyup(function(){
		var pw1 = $("#member_PWD").val();
		var pw2 = $("#check_member_PWD").val();
		if(pw1.length >= 1) {
			if(pw1 != pw2) {
				$("#check_PWD_msg").html("비번호가 일치하지 않습니다.");
				checkedPassword = false;
			} else {
				$("#check_PWD_msg").html("비번호가 일치합니다.");
				checkedPassword = true;
			}
		}
	});
	$("#member_Email").keyup(function(){
		var email = $("#member_Email").val();
		if(email.length >= 1) {
			if(!isEmail(email)) {
				$("#check_Email_msg").html("잘못된 이메일 형식입니다.");
				checkedEmail = false;
			} else {
				$.ajax({
					url:serverAddr + "/hMember/checkedEmail.json",
					type: "POST",
					dataType: "json",
					data: {memberEmail:email},
					success: function (obj) {
						var result = obj.jsonResult
						if (result.state != "success") {
							$("#check_Email_msg").html("사용중인 이메일 입니다.");
							checkedEmail = false;
						} else {
							$("#check_Email_msg").html("사용 가능한 이메일 입니다.");
							checkedEmail = true;
						}
					}
				});
			}
		}
	});
});
$("#submitMember").click(function(event){
	var memberData = {
		memberEmail: $("#member_Email").val(),
		memberPWD: $("#member_PWD").val(),
		memberName: $("#member_Name").val(),
		memberGender: $(".member_Gender").val(),
		memberTel: $("#member_Tel").val()
	}
	ajaxSignup(memberData);
});
function isEmail(email) {
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
	if(regex.test(email) === false) {  
		return false;  
	} else {  
		return true;
	}
}

function ajaxSignup(user) {
	$.ajax({
		url:serverAddr + "/hMember/joinMember.json",
		type: "POST",
		dataType: "json",
		data: user,
		success: function (obj) {
			var result = obj.jsonResult
			
			if (result.state != "success"||checkedEmail!=true||checkedPassword!=true) {
				alert("가입실패 하였습니다. 정확히 입력 후 재시도 해주세요")
				return
			}
			alert("축하합니다 가입되었습니다.")
			location.href = "../hMember/signIn.html"
		}
	});
}
