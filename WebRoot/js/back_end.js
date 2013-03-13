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

// TaskDone
function taskDone(tId, tName) {
	if (confirm("您确认要将任务：" + tName + " 设置为已完成吗?")) {
		top.location.href = "mgr/TaskDone?tId=" + tId;
	}
}
function taskCollect(tId, tName) {
	if (confirm("您确认要将任务：" + tName + " 归档吗?")) {
		top.location.href = "mgr/TaskCollect?tId=" + tId;
	}
}

// 显示新建任务的遮罩层
var isOut = "out";
function mOut() {
	isOut = "out";
}
function mIn() {
	isOut = "in";
}
function showAddPanel() {
	var p = document.getElementById("add_above");
	p.hidden = false;
}
function hidAddPanel() {
	var p = document.getElementById("add_above");
	if (isOut == "out") {
		p.hidden = true;
	}
}
// 未实施界面
var tId = 0;
var rh = document.body.scrollHeight;
function showUpdatePanela(taskId) {
	tId = taskId;
	var pa = document.getElementById("taska" + tId);
	var p = document.getElementById("task" + tId);
	pa.hidden = false;
	p.hidden = true;

	if (rh < document.body.scrollHeight) {
		document.body.scrollTop = document.body.scrollTop + 200;
	}
}
document.onmousedown = function() {
	var pa = document.getElementById("taska" + tId);
	var p = document.getElementById("task" + tId);
	if (pa.hidden == false && isOut == "out") {
		pa.hidden = true;
		p.hidden = false;
	}
}
top.document.onmousedown = function() {
	var pa = document.getElementById("taska" + tId);
	var p = document.getElementById("task" + tId);
	if (pa.hidden == false && isOut == "out") {
		pa.hidden = true;
		p.hidden = false;
	}
}
// topshow
function top1() {
	top.location.href = "mgr/ShowTaskList";
}