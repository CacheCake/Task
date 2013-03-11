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
		if (i == 1) {
			iframediv.style.height = (bodyHeight - 155) + "px";
			paperdiv.style.height = (bodyHeight - 175) + "px";
		} else {
			iframediv.style.height = (bodyHeight - 150) + "px";
			paperdiv.style.height = (bodyHeight - 170) + "px";
		}
	}
}

// 跳转成员到详细
function showMember(uId) {
	parent.location.href = "hr/ShowMember?uId=" + uId;
}

// hr操作按钮
var opButton = null;
function hrOpButton(i, uId) {
	if (opButton != null) {
		opButton.innerHTML = "...";
	}
	opButton = document.getElementById("op_button" + i);
	opButton.innerHTML = '<button class="update_button" onclick="showMember('
			+ uId
			+ ')"></button><button class="del_button" onclick="delMember('
			+ uId + ')"></button>';
}

// 删除hr成员
function delMember(uId) {
	if (confirm("确认要删除" + uId + "吗?")) {
		parent.location.href = "hr/DeleteMember?uId=" + uId;
	}
}

// Sign Out
function signOut() {
	window.location.href = "signIn/DoSignOut";
}