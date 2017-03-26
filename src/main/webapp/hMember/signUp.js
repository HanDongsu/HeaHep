var checkedEmail;
var checkedPassword;
var checkedNick;
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
	
	$("#member_Nick").keyup(function(){
		var nick = $("#member_Nick").val();
		if(nick.length >= 1) {
			if(!isNick(nick)) {
				$("#check_Nick_msg").html("공백이나 특수문자는 사용할 수 없습니다.");
				checkedNick = false;
			} else {
				$.ajax({
					url:serverAddr + "/hMember/checkedNick.json",
					type: "POST",
					dataType: "json",
					data: {memberNick:nick},
					success: function (obj) {
						var result = obj.jsonResult
						if (result.state != "success") {
							$("#check_Nick_msg").html("사용 불가");
							checkedNick = false;
						} else {
							$("#check_Nick_msg").html("사용 가능");
							checkedNick = true;
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
		memberGender: $("#member_Gender").val(),
		memberTel: $("#member_Tel").val(),
		memberNick: $("#member_Nick").val()
	}
	ajaxSignup(memberData);
});
// 이메일 유효성
function isEmail(email) {
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
	if(regex.test(email) === false) {
		return false;  
	} else {
		return true;
	}
}
// 닉네임 유효성
function isNick(nick) {
	var regex = /[\s\{\}\[\]\/?.,;:|\)*~`!^\+<>@\#$%&\'\"\\\(\=]/gi;
	if(regex.test(nick) === false){
		return true;
	} else {
		return false;
	}
}
// \w 알파벳+숫자+언더바 
// 패스워드 유효성
function isPWD(pwd) {
	var regexK = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]$/g; // 한글
	var regexS = /[\s\{\}\[\]\/.,:\)*~`!^\+<>@\#%\(\-\_]/; //특수문자
	// 특수문자 중 $ ; & | % ' " = # ? ＼ 는 사용하실 수 없습니다.
	var regexN = /[\d]/; // 숫자
	var regexL = /[\l]/; // 소문자
	var regexU = /[\u]/; // 대문자
	var regex = /^[a-zA-Z]/ 
	if(regexK.test(pwd) === false){
		if(regexS.test(pwd)===true && regexN.test(pwd)===true){
			return true;
		} else if(regexS.test(pwd)===true && regexB.text(pwd)===true){
			return true;
		}
		return true;
	} else {
		return false;
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
			if (result.state != "success"||checkedEmail!=true||checkedPassword!=true||checkedNick!=true) {
				alert("가입실패 하였습니다. 정확히 입력 후 재시도 해주세요")
				return
			}
			alert("축하합니다 가입되었습니다.")
			location.href = "../hMember/signIn.html"
		}
	});
}

function maxLengthCheck(object){
    if (object.value.length > 11){
        object.value = object.value.slice(0, 11);
    }    
}
