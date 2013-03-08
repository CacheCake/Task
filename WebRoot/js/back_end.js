//sign in
//--------------------------------------------------------------

//记录登陆通道
var channel = null;//当前选择的通道
var el = null;//上次点击的通道
function chooseChannel(c,e) {
	var role = document.getElementById("userRole");//通道传参
	channel = c;
	if (el !=null) {
		el.style.backgroundColor = "#4c3d7a";
	}
	e.style.backgroundColor = "#352a54";
	role.value = c;
	el = e;
	
	var b = document.getElementById("mSign_in");
	b.disabled = false;
	b.innerHTML = "Sign In";
	b.style.backgroundColor = "#4c3d7a";
}