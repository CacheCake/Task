//sign in
//--------------------------------------------------------------

//记录登陆通道
var channel = null;// 当前选择的通道
var el = null;// 上次点击的通道
function chooseChannel(c, e) {
	var role = document.getElementById("userRole");// 通道传参
	channel = c;
	if (el != null) {
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

// UI
// --------------------------------------------------------------
// 随窗口改变高度
function panelHeight(i) {
	var bodyHeight = document.documentElement.clientHeight;
	var paneldiv = document.getElementById("panel");
	var iframediv = document.getElementById("member_list");
	var paperdiv = document.getElementById("paper");
	if (bodyHeight > 650) {
		paneldiv.style.height = (bodyHeight - 102) + "px";
		if (i==1) {
			iframediv.style.height = (bodyHeight - 155) + "px";
			paperdiv.style.height = (bodyHeight - 175) + "px";
		} else {
			iframediv.style.height = (bodyHeight - 150) + "px";
			paperdiv.style.height = (bodyHeight - 170) + "px";
		}
	}
}