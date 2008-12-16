//<![CDATA[

//브라우저 별 키값 검사
function validateKey(e) {
	var keynum;
	var ismouseClick = 1;

	if (window.event) { //IE & Safari
		keynum = e.keyCode;
		//Safari의 경우 마우스클릭은 keynum 0 이 넘어옴
		if (keynum == 0){
			ismouseClick = 0;
		}
	}
		else if ( e.which ){ // Netscape/Firefox/Opera
		keynum = e.which;

		if (keynum == 1) {
			ismouseClick = 0;
		}
	}
	//마우스 클릭이거나 엔터키를 누른경우 true값 반환
	if ( ismouseClick == 0 || keynum == 13 ) {
		return true;
	}
	else{
		return false;
	}
}

//content tabnavi img swap
function jsTabnaviSwap(idx,ev){
	var objImg = document.getElementById("tabImg"+idx);
	if(ev.type=="mouseover" || ev.type=="focus"){
		objImg.src = objImg.src.replace("off","on");
	}
	else if(ev.type=="mouseout" || ev.type=="blur"){
		objImg.src = objImg.src.replace("on","off");
	}
}

//]]>