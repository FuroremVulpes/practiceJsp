

//パスワード変更*********************************************************************
function PassCheck(pass){  //現在のパスワード
	var pass2;
	var new1;
	var new2;

	new1 = document.form1.newPass1.value;
	new2 = document.form1.newPass2.value;
	pass1 = document.form1.pass.value; //入力フォームの現在のパスワード

	if (pass != pass1){
		alert("パスワードが間違っています。");
		return;
	}else if (new1 != new2){
		alert("新しいパスワードが一致していません。");
		return;
	}
	document.form1.submit();
}
//パスワード変更ここまで*********************************************************************


//勤務表************************************************************************************
//勤務表入力戻るボタンを押して再送があった場合対応
function Add(num){

	//var startTime = document.form1.startTime.value;
	//var finishTime = document.form1.finishTime.value;
	//var breakTime document.form1.breakTime.value;
	//TimeCheck(startTime, finishTime, breakTime);

    document.form1.left.value = document.documentElement.scrollLeft || document.body.scrollLeft;
    document.form1.top.value = document.documentElement.scrollTop || document.body.scrollTop;

    if (num == 0){
    	document.form1.command.value = "attendanceSheet_add";
    }else{
    	document.form1.command.value = "attendanceSheet_update";
    }

	if (document.form1.alreadySend.value == "yes") {
		alert("既に送信されている可能性があります。\n勤務表リストを再度開いてから入力してください。\n★尚入力の際、戻るボタンはお控えください。★");
		return false;
	}else {
		document.form1.alreadySend.value = "yes";
		document.form1.submit();
	}
}

function EasyInput(){

	if (document.form1.startTime.value == ""){
		document.form1.startTime.value = document.form1.s.value;
	}
	if (document.form1.finishTime.value == ""){
		document.form1.finishTime.value = document.form1.f.value;

	}
	if (document.form1.breakTime.value == "") {
		document.form1.breakTime.value = document.form1.b.value;
	}
}

function Delete(num){

    document.form1.left.value = document.documentElement.scrollLeft || document.body.scrollLeft;
    document.form1.top.value = document.documentElement.scrollTop || document.body.scrollTop;
    document.form1.command.value = "attendanceSheet_delete";

    if (num == 0){
    	alert("削除対象がありません。")
    	return false;
    }

    if (document.form1.alreadySend.value == "yes") {
    	alert("既に送信されている可能性があります。\n勤務表リストを再度開いてから入力してください。\n★尚入力の際、戻るボタンはお控えください。★");
    	return false;
    } else {
    	document.form1.alreadySend.value = "yes";
    	document.form1.submit();
    }

}


//勤務表ここまで************************************************************************************