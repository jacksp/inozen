<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.admin.menu.support.MenuRef" %>
<%@ page import="com.inozen.app.model.enumeration.MenuType" %>
<%@ page import="com.inozen.app.model.enumeration.MenuKind" %>
<%@ include file="/admin/include/popupheader.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	MenuRef ref = (MenuRef)request.getAttribute("ref");
	MenuType type = ref.getMenuType();
	MenuKind kind = ref.getMenuKind();
%>
<div id="title">
	<h1>메뉴 등록</h1>
</div>
<div id="buttons">

	<script type="text/javascript" language="javascript">
		var saveHandler = function() {
			var codeLength = $("form").codeValue.length;
			for(i=0; i<codeLength; i++) {
				if($("form").codeValue[i].value!="") $("menuRelatedCode").value = $("form").codeValue[i].value;
			}
			$("form").submit();
		}
	
		var cancelHandler = function() {
			document.location.href="menuList.do";
		}

		var popupCateHandler = function() {
			var param = "?type=1&target=opener&kind=popup&form=form&name=cateName&value=cateCode&retval=true";
			popup("/common/tree/popTree.do"+param, "popup", 400, 600, "yes", "yes");
		}

		var popupPageHandler = function() {
			var param = "?target=opener&form=form&name=pageName&value=pageCode&retval=true";
			popup("/admin/page/popHtmlList.do"+param, "popup", 600, 400, "yes", "yes");
		}

		var checkHandler = function() {
<%
	for(int i=0; i<type.size(); i++) {
%>
			if($("menuType<%=i%>").checked == true) $("layer<%=i%>").style.display = 'block';
			else $("layer<%=i%>").style.display = 'none';
<%
	}
%>
		}

	</script>	

	<a href="javascript:void(1)" id="savebtn" class="savebtn">저장</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">취소</a>
	
</div>
<div id="formbox">
	<form id="form" action="/admin/menu/saveMenu.do" method="post">
	<input type="hidden" name="menuRelatedCode" id="menuRelatedCode" value=""/>
		<div class="formblock">
		<p id="namerow">
			<label>메뉴 이름 :</label>
			<input id="menuName" name="menuName" type="text" value="" size="10" maxlength="15"/>
			<form:errors path="menuName" cssClass="error"/>
			<input id="pMenuName" name="pMenuName" type="hidden" value="${model.menuName}" />
			<input id="pMenuCode" name="pMenuCode" type="hidden" value="${model.menuCode}" />
		</p>
		<p id="namerow">
			<label>상위 메뉴 : </label> <c:out value="${model.menuName}" default="선택된 상위 메뉴가 없습니다."/>
		</p>
		<p id="radiorow">
			<label>메뉴 종류 :</label>
<%
	for(int i=0; i<type.size(); i++) {
%>
			<span>
				<input id="menuType<%=i%>" name="menuType" type="radio" value="<%=type.get(i).getValue() %>"/>
				<label for="menuType<%=i%>"><%=type.get(i).getDescr() %></label>
			</span>
<%
	}
%>
			<form:errors path="menuType" cssClass="error" />
		</p>
		<p id="">
			<label>메뉴 위치 :</label>
<%
	for(int i=0; i<kind.size(); i++) {
%>
			<span>
				<input id="menuKind<%=i %>" name="menuKind" type="radio" value="<%=kind.get(i).getValue() %>"/>
				<label for="menuKind<%=i%>"><%=kind.get(i).getDescr() %></label>
			</span>
<%
	}
%>
		</p>
		<div id="layer0" style="display:none">
		<p>
			<label for="cateName">카테고리 선택 :</label>
			<input id="cateName" name="cateName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="cateCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchCate">검색</a>
		</p>
		</div>
		<div id="layer1" style="display:none">
		<p>
			<label>게시판 선택 :</label>
			<input id="boardName" name="boardName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="boardCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchBd">검색</a>
		</p>
		</div>
		<div id="layer2" style="display:none">
		<p>
			<label>페이지 선택 :</label>
			<input id="pageName" name="pageName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="pageCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchPage">검색</a>
		</p>
		</div>
		<div id="layer3" style="display:none">
		<p>
			<label>링크 :</label>
			<input id="menuURL" name="menuURL" type="text" value="" size="100" maxlength="15"/>
		</p>
		</div>
	</form>
</div>
<script type="text/javascript" language="javascript"> 
	Event.observe("savebtn", "click", saveHandler, false);
	Event.observe("cancelbtn", "click", cancelHandler, false);
	Event.observe("searchCate", "click", popupCateHandler, false);
	Event.observe("searchPage", "click", popupPageHandler, false);
<%
	for(int i=0; i<type.size(); i++) {
%>
	Event.observe("menuType<%=i %>", "click", checkHandler, false);
<%
	}
%>
</script>
<%@ include file="/admin/include/popupfooter.jsp" %>