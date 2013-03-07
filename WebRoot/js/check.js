//team_register
//----------------------------------------------------------------
function teamRegCheck() {
	//tName
	var tName = document.getElementById('tName');
	var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9]{2,15}$/;
	if (tName.value == "") {
		tName.setCustomValidity("此项不能为空。");
	} else if (!reg.test(tName.value)) {
		tName.setCustomValidity("请输入2-15个中文、英文或符号的字符。");
		tName.checkValidity();
	} else {
		tName.setCustomValidity("");
	}
	
	//tPhone
	var tPhone = document.getElementById('tPhone');
	var reg = /^1[3|4|5|8][0-9]\d{8}$/;
	if (tPhone.value == "") {
		tPhone.setCustomValidity("此项不能为空。");
	} else if (!reg.test(tPhone.value)) {
		tPhone.setCustomValidity("请输入正确格式的手机号码。");
		tPhone.checkValidity();
	} else {
		tPhone.setCustomValidity("");
	}
	
	//player
	for (var i = 1; i < 8; i++) {
		//pId
		var pId = document.getElementById('pId' + i);
		var reg = /^[0|1]\d{9}$/;
		if (pId.value == "") {
			pId.setCustomValidity("此项不能为空。");
		} else if (!reg.test(pId.value)) {
			pId.setCustomValidity("请输入正确格式的学号。");
			pId.checkValidity();
		} else {
			pId.setCustomValidity("");
		}
		
		//pName
		var pName = document.getElementById('pName' + i);
		var reg = /^[\u4E00-\u9FA5]{2,5}$/;
		if (pName.value == "") {
			pName.setCustomValidity("此项不能为空。");
		} else if (!reg.test(pName.value)) {
			pName.setCustomValidity("名字啊！");
			pName.checkValidity();
		} else {
			pName.setCustomValidity("");
		}
		
		//pWin
		var pWin = document.getElementById('pWin' + i);
		var reg = /^\d{1,4}$/;
		if (pWin.value == "") {
			pWin.setCustomValidity("此项不能为空。");
		} else if (!reg.test(pWin.value)) {
			pWin.setCustomValidity("胜场应在0-9999之间。");
			pWin.checkValidity();
		} else {
			pWin.setCustomValidity("");
		}
	}
}