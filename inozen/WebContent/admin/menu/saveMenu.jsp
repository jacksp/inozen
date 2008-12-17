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
	<h1>�޴� ���</h1>
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

	<a href="javascript:void(1)" id="savebtn" class="savebtn">����</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">���</a>
	
</div>
<div id="formbox">
	<form id="form" action="/admin/menu/saveMenu.do" method="post">
	<input type="hidden" name="menuRelatedCode" id="menuRelatedCode" value=""/>
		<div class="formblock">
		<p id="namerow">
			<label>�޴� �̸� :</label>
			<input id="menuName" name="menuName" type="text" value="" size="10" maxlength="15"/>
			<form:errors path="menuName" cssClass="error"/>
			<input id="pMenuName" name="pMenuName" type="hidden" value="${model.menuName}" />
			<input id="pMenuCode" name="pMenuCode" type="hidden" value="${model.menuCode}" />
		</p>
		<p id="namerow">
			<label>���� �޴� : </label> <c:out value="${model.menuName}" default="���õ� ���� �޴��� �����ϴ�."/>
		</p>
		<p id="radiorow">
			<label>�޴� ���� :</label>
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
			<label>�޴� ��ġ :</label>
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
			<label for="cateName">ī�װ��� ���� :</label>
			<input id="cateName" name="cateName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="cateCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchCate">�˻�</a>
		</p>
		</div>
		<div id="layer1" style="display:none">
		<p>
			<label>�Խ��� ���� :</label>
			<input id="boardName" name="boardName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="boardCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchBd">�˻�</a>
		</p>
		</div>
		<div id="layer2" style="display:none">
		<p>
			<label>������ ���� :</label>
			<input id="pageName" name="pageName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="pageCode" name="codeValue" type="hidden" value="" />
			<a href="javascript:void(1)" id="searchPage">�˻�</a>
		</p>
		</div>
		<div id="layer3" style="display:none">
		<p>
			<label>��ũ :</label>
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