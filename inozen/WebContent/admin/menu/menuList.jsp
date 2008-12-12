<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.model.Menu" %>
<%@ page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>Untitled Document</title>
<link rel="stylesheet" media="screen" type="text/css" href="/css/base.css" />
<script language="JavaScript" src="/js/prototype-1.6.x.js"></script>
<script language="JavaScript" src="/js/osaf.js"></script>

<!-- calendar -->
<link rel="stylesheet" type="text/css" media="all" href="/js/jscalendar-1.0/calendar-blue2.css" title="win2k-cold-1" />
<script type="text/javascript" src="/js/jscalendar-1.0/calendar.js"></script>
<script type="text/javascript" src="/js/jscalendar-1.0/lang/calendar-en.js"></script>
<script type="text/javascript" src="/js/jscalendar-1.0/calendar-setup.js"></script>

<style>
body {
	margin-right: 2px;
}
</style>

</head>
<%
	String pMenuCode = (String)request.getAttribute("code");
	String message = (String)request.getAttribute("message");
%>
<body>

<div id="buttons">
<script type="text/javascript">
	var pMenuCode = "<%=pMenuCode%>";
	var message = "<%=message%>";
	function addCategory () {
		if((pMenuCode==""||pMenuCode=="null")&&message=="") {
			alert("메뉴를 선택하세요.");
			return;
		}
		popup("saveMenu.do?pMenuCode="+pMenuCode, "popup", 700, 400, "yes", "yes");
	}

	function searchCategory () {
		document.forms.searchform.method="POST";
		document.forms.searchform.action="menuList.do";
		document.forms.searchform.submit();
	}

</script>
<%-- ===================================================================================== --%>
<%--                               Button Anchor                                           --%>
<%-- ===================================================================================== --%>
<a href="javascript:void(1)" onClick="searchCategory()" id="searchbtn" class="searchbtn">검색</a>
<a href="javascript:void(1)" onclick="addCategory()" id="addbtn" class="addbtn">추가</a>
</div>

<form id="searchform" method="get">
	<label>이름 :</label>
	<input id="name" name="cateName" type="text" size="20" maxlength="30" value="" />
</form>
<%
	List<Menu> list = (List<Menu>)request.getAttribute("list");
%>
	<table border="1">
		<tr>
			<td>메뉴코드</td>
			<td>메뉴이름</td>
			<td>상위메뉴코드</td>
			<td>상위메뉴이름</td>
			<td>메뉴종류</td>
			<td>메뉴타입</td>
			<td>관련코드</td>
			<td>메뉴URL</td>
			<td>등록사용자아이디</td>
			<td>등록사용자이름</td>
			<td>등록일자</td>
			<td>수정사용자아이디</td>
			<td>수정사용자이름</td>
			<td>수정일자</td>
			<td>메뉴순서</td>
			<td>메뉴상태</td>
		</tr>
<%
	if(list!=null) {
		for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getMenuCode() %></td>
			<td><%=list.get(i).getMenuName() %></td>
			<td><%=list.get(i).getPMenuCode() %></td>
			<td><%=list.get(i).getPMenuName() %></td>
			<td><%=list.get(i).getMenuKind() %></td>
			<td><%=list.get(i).getMenuType() %></td>
			<td><%=list.get(i).getMenuRelatedCode() %></td>
			<td><%=list.get(i).getMenuURL() %></td>
			<td><%=list.get(i).getCreatedUserID() %></td>
			<td><%=list.get(i).getCreatedUserName() %></td>
			<td><%=list.get(i).getCreatedDate()%></td>
			<td><%=list.get(i).getModifiedUserID()%></td>
			<td><%=list.get(i).getModifiedUserName()%></td>
			<td><%=list.get(i).getModifiedDate()%></td>
			<td><%=list.get(i).getMenuOrder()%></td>
			<td><%=list.get(i).getMenuStatus()%></td>
		</tr>
<%
		}
	}
%>
		<tr>
			<td colspan="16"><font color="red"><%=message %></font></td>
		</tr>
	</table>
</body>
</html>