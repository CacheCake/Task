//sign in
//--------------------------------------------------------------

//记录登陆通道
var channel = null;
var el = null;
function chooseChannel(c,e) {
	channel = c;
	if (el !=null) {
		el.style.backgroundColor = "#4c3d7a";
	}
	e.style.backgroundColor = "#352a54";
	el = e;
	
	var b = document.getElementById("mSign_in");
	b.disabled = false;
	b.innerHTML = "Sign In";
	b.style.backgroundColor = "#4c3d7a";
}