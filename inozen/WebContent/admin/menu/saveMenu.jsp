<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.admin.menu.support.MenuRef" %>
<%@ page import="com.inozen.app.model.enumeration.MenuType" %>
<%@ include file="/admin/include/popupheader.jsp" %>
<%
	MenuRef ref = (MenuRef)request.getAttribute("ref");
	MenuType type = ref.getMenuType();
	
%>
<div id="title">
	<h1>메뉴 등록</h1>
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

	<a href="javascript:void(1)" id="savebtn" class="savebtn">저장</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">취소</a>
	
	<script type="text/javascript"> 
		Event.observe("savebtn", "click", saveHandler, false);
	
		Event.observe("cancelbtn", "click", cancelHandler, false);	
	</script>
</div>
<div id="formbox">
	<form id="form" action="/admin/category/saveCategory.do" method="post">
		<div class="formblock">
		<p id="namerow">
			<label>메뉴 이름 :</label>
			<input id="menuName" name="menuName" type="text" value="" size="10" maxlength="15"/>&nbsp;
			<input id="pmenuName" name="pMenuName" type="hidden" value="${model.menuName}" />
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
				<input id="menuType" name="menuType" type="radio" value="<%=type.get(i).getValue() %>"/>
				<label><%=type.get(i).getDescr() %></label>
			</span>
<%
	}
%>
		</p>
		<p>
			<label>카테고리 선택</label>
			<input id="cateName" name="cateName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>게시판 선택</label>
			<input id="boardName" name="boardName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>페이지 선택</label>
			<input id="pageName" name="pageName" type="text" value="" size="50" maxlength="15" readonly/>
			<input id="menuRelatedCode" name="menuRelatedCode" type="hidden" value="" />
		</p>
		<p>
			<label>링크</label>
			<input id="menuURL" name="menuURL" type="text" value="" size="100" maxlength="15"/>
		</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>