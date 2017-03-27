function detectmob() {  
   if( navigator.userAgent.match(/Android/i) 
   || navigator.userAgent.match(/webOS/i) 
   || navigator.userAgent.match(/iPhone/i) 
   || navigator.userAgent.match(/iPad/i) 
   || navigator.userAgent.match(/iPod/i) 
   || navigator.userAgent.match(/BlackBerry/i) 
   || navigator.userAgent.match(/Windows Phone/i) 
   ){ 
         return true; 
    } 
   else { 
         return false; 
    } 
}
$(document).ready(function(){
	console.log("t&&t: "+ (tt()&&tt()) );
	console.log("t&&f: "+ (tt()&&ff()) );
	console.log("f&&t: "+ (ff()&&tt()) );
	console.log("f&&f: "+ (ff()&&ff()) );
	console.log("t&&t&&t: "+ (tt()&&tt()&&tt()) );
	console.log("t&&t&&f: "+ (tt()&&tt()&&ff()) );
	console.log("t||t: "+ (tt()||tt()) );
	console.log("t||f: "+ (tt()||ff()) );
	console.log("f||t: "+ (ff()||tt()) );
	console.log("f||f: "+ (ff()||ff()) );
	console.log("t||t||f: "+ (tt()||tt()||ff()) );
	var a ="가";
	var regexK = /^(?=.*[ㄱ-ㅎ|ㅏ-ㅣ|가-힣])/;
	console.log("regexK.test(a): "+regexK.test(a))
//	if(regexK.test(a)===false) {
//	}
});
function tt() {
	return true;
}
function ff() {
	return false;
}
function t(a) {
	
}
