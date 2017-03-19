$("#loginMember").on("click",function(){
	var loginInfo = {
		memberEmail : $("#member_Email").val(),
		memberPWD : $("#member_PWD").val()
	}
	ajaxLogin(loginInfo);
})
function ajaxLogin(user) {
	$.ajax({
		url:serverAddr+"/hMember/login.json",
		type:"POST",
		dataType:"json",
		data: user,
		success: function(obj) {
			var result = obj.jsonResult
			if (result.state != "success") {
				alert("로그인 실패");
				return
			}
			alert("로그인 성공");
		}
	})
	
}