// screen
//--------------------------------------------------------------------
function bgWidth() {
	var bodyWidth = document.body.clientWidth;
	var bgdiv = document.getElementById("panel_div");
	if (bodyWidth > 1366) {
		bgdiv.style.left = (bodyWidth - 1366) / 2 + "px";
	}
}

// UI
// --------------------------------------------------------------------



// 0级赛
function tZero_check() {
	var t = document.getElementById("tZero_label").innerHTML;
	if (t == "愿意") {
		document.getElementById("tZero_label").innerHTML = "不愿意";
	} else if (t == "不愿意") {
		document.getElementById("tZero_label").innerHTML = "愿意";
	}
}

// 性别
function pGender_check(i) {
	var t = document.getElementById("pGender" + i + "_label").innerHTML;
	if (t == "男") {
		document.getElementById("pGender" + i + "_label").innerHTML = "女";
	} else if (t == "女") {
		document.getElementById("pGender" + i + "_label").innerHTML = "男";
	}
}

// 替补
function useBench(i) {
	var t = document.getElementById('pBench' + i);
	if (t.checked == true) {
		if (i == 6) {
			document.getElementById('pBench7').disabled = false;
		}
		document.getElementById('pId' + i).disabled = false;
		document.getElementById('pName' + i).disabled = false;
		document.getElementById('pGender' + i).disabled = false;
		document.getElementById('pId' + i).disabled = false;
		document.getElementById('pBuilding' + i).disabled = false;
		document.getElementById('pRoom' + i).disabled = false;
		document.getElementById('pLolExp' + i).disabled = false;
		document.getElementById('pServer' + i).disabled = false;
		document.getElementById('pWin' + i).disabled = false;
	} else if (t.checked == false) {
		if (i == 6) {
			document.getElementById('pBench7').disabled = true;
		}
		document.getElementById('pId' + i).disabled = true;
		document.getElementById('pName' + i).disabled = true;
		document.getElementById('pGender' + i).disabled = true;
		document.getElementById('pId' + i).disabled = true;
		document.getElementById('pBuilding' + i).disabled = true;
		document.getElementById('pRoom' + i).disabled = true;
		document.getElementById('pLolExp' + i).disabled = true;
		document.getElementById('pServer' + i).disabled = true;
		document.getElementById('pWin' + i).disabled = true;
	}
}

// tools
// --------------------------------------------------------------------
function returnPage() {
	history.back();
}