//<![CDATA[

//������ �� Ű�� �˻�
function validateKey(e) {
	var keynum;
	var ismouseClick = 1;

	if (window.event) { //IE & Safari
		keynum = e.keyCode;
		//Safari�� ��� ���콺Ŭ���� keynum 0 �� �Ѿ��
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
	//���콺 Ŭ���̰ų� ����Ű�� ������� true�� ��ȯ
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