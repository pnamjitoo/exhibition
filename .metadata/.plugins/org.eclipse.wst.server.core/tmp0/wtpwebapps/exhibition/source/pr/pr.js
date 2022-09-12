function prCheck() {
	
	if(isNaN(document.frm.mem_no.value)){
		alert("숫자를 입력해야 합니다");
		frm.mem_no.focus();
		return false;
	}
	
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요.");
		frm.title.focus();
		return false;
	}
	//
	if(document.frm.place.value.length == 0){
		alert("장소를 입력하세요.");
		frm.place.focus();
		return false;
	}
	
	if(document.frm.rdate.value.length == 0){
		alert("등록일을 입력하세요.");
		frm.rdate.focus();
		return false;
	}
	if(document.frm.descript.value.length == 0){
		alert("설명을 입력하세요.");
		frm.descript.focus();
		return false;
	}
	return true;
	
}