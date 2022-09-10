function loginCheck() {
   
   if (document.frm.id.value == "") {
      alert("아이디를 입력해주세요.");
      frm.id.focus();
      return false;
   } else if (document.frm.pwd.value == "") {
      alert("비밀번호를 입력해주세요.");
      frm.pwd.focus();
      return false;
   }
   return true;
}

function openCheck() {
	if (idCheck() == true){
	var url = "/exhibition/MemberServlet?command=idcheck&id=" + document.frm.id.value;
	window.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	}
}

function idCheck() {
		var idRegExp = /^[a-zA-z0-9]{4,12}$/;
	if (document.frm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	} else if (!idRegExp.test(document.frm.id.value)) {            
		alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야 합니다.");            
		frm.id.value = "";            
		frm.id.focus();            
		return false;        
	} 
	return true;
}

function idok() {
	opener.frm.id.value=document.frm.id.value;
	opener.frm.reid.value=document.frm.id.value;
	self.close();
}

function registCheck() {  
	if (!checkId(document.frm.id.value)){
		return false;
	}   else if (document.frm.reid.value.length == 0) {
		alert("아이디 중복 체크는 필수입니다.");
		frm.id.focus();
		return false;
	}	else if (!checkPassword(document.frm.pwd.value, document.frm.pwd1.value)) {
		return false;
	}	else if (!checkName(document.frm.mem_name.value)) {
		return false;
	}	else if (!checkNick(document.frm.nick.value)) {
		return false;
	}	else if (!checkAge(document.frm.age.value)) {
		return false;
	}	else if (!checkExistData(document.frm.gender.value, "성별을")) {
		return false;
	}	else if (!checkTel(document.frm.tel.value)) {
		return false;
	}	else if (!checkExistData(document.frm.addr.value, "주소를")) {
		return false;
	}	else if (!checkExistData(document.frm.rank.value, "가입유형을")) {
		return false;
	}        
	return true;
}
	
// 공백확인 함수    
function checkExistData(value, dataName) {        
	if (value == "") {            
		alert(dataName + " 입력해주세요.");            
		return false;
	}        
	return true;    
}

function checkId(id){     
 	if (!checkExistData(id, "아이디를"))        
		return false; 
	var idRegExp = /^[a-zA-z0-9]{4,12}$/;   
	if (!idRegExp.test(id)) {            
		alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야 합니다.");            
		frm.id.value = "";            
		frm.id.focus();            
		return false;        
	}        
	return true;	
}

//비밀번호가 입력되었는지 확인하기
function checkPassword(pwd, pwd1) {      
	if (!checkExistData(pwd, "비밀번호를"))            
		return false;       
	if (!checkExistData(pwd1, "비밀번호 확인을"))            
		return false;  
		       
	//비밀번호 유효성 검사
	var password1RegExp = /^[a-zA-z0-9]{4,12}$/;       
	if (!password1RegExp.test(pwd)) {
		alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야 합니다.");
		frm.pwd.value = "";
		frm.pwd.focus();
		return false;        
	}        
	//비밀번호와 비밀번호 확인이 맞지 않다면..        
	if (pwd != pwd1) {
		alert("두 비밀번호가 맞지 않습니다.");
		frm.pwd.value = "";
		frm.pwd1.value = "";
		frm.pwd1.focus();
		return false;
	}         
	return true;
}  
  
function checkAge(age) {
if (!checkExistData(age, "나이를"))            
	return false;         
	var ageRegExp = /^[0-9]{1,3}$/;        
		if (!ageRegExp.test(age)) {
			alert("나이는 숫자만 입력 가능합니다.");
			frm.age.value = "";            
			frm.age.focus();            
			return false;        
		}        
	return true;
}

function checkName(mem_name) {
if (!checkExistData(mem_name, "이름을"))            
	return false; 
else {
	return true;
}             
}

function checkNick(nick) {
if (!checkExistData(nick, "별명을"))            
	return false;  
	else {
	return true;
}               
}

function checkTel(tel) {
if (!checkExistData(tel, "전화번호를"))            
	return false;        
	var telRegExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;        
		if (!telRegExp.test(tel)) {
			alert("전화번호 형식이 올바르지 않습니다.");
			frm.tel.value = "";            
			frm.tel.focus();            
			return false;        
		}        
	return true;
}