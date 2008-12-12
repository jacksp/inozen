<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.admin.menu.support.MenuRef" %>
<%@ page import="com.inozen.app.model.enumeration.MenuType" %>
<%@ include file="/admin/include/popupheader.jsp" %>
<%
	MenuRef ref = (MenuRef)request.getAttribute("ref");
	MenuType type = ref.getMenuType();
	
%>
<div id="title">
	<h1>�޴� ���</h1>
</div>
<div id="buttons">

	<script>
		var saveHandler = function() {
			$("form").submit();
		}
	
		var cancelHandler = function() {
			window.close();
		}
	</script>	

	<a href="javascript:void(1)" id="savebtn" class="savebtn">����</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">���</a>
	
	<script type="text/javascript"> 
		Event.observe("savebtn", "click", saveHandler, false);
	
		Event.observe("cancelbtn", "click", cancelHandler, false);	
	</script>
</div>
<div id="formbox">
	<form id="form" action="/admin/category/saveCategory.do" method="post">
		<div class="formblock">
		<p id="namerow">
			<label>�޴� �̸� :</label>
			<input id="menuName" name="menuName" type="text" value="" size="10" maxlength="15"/>&nbsp;
			<input id="pmenuName" name="pMenuName" type="hidden" value="${model.menuName}" />
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
				<input id="menuType" name="menuType" type="radio" value="<%=type.get(i).getValue() %>"/>
				<label><%=type.get(i).getDescr() %></label>
			</span>
<%
	}
%>
		</p>
		<p>
			<label>ī�װ� ����</label>
			<input id="cateName" name="cateName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>�Խ��� ����</label>
			<input id="boardName" name="boardName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>������ ����</label>
			<input id="pageName" name="pageName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>��ũ</label>
			<input id="menuURL" name="menuURL" type="text" value="" size="100" maxlength="15"/>
		</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>