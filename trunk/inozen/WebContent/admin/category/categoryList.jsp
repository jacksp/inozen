<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.model.Category" %>
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
<body>

<div id="buttons">
<script type="text/javascript">

	function addCategory () {
		var pCode = "";
		popup("saveCategory.do?pCode="+pCode, "popup", 700, 400, "yes", "yes");
	}

	function searchCategory () {
		document.forms.searchform.method="POST";
		document.forms.searchform.action="categoryList.do";
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
	List<Category> list = (List<Category>)request.getAttribute("list");
%>
	<table border="1">
		<tr>
			<td>코드</td>
			<td>이름</td>
			<td>상태</td>
			<td>생성일</td>
			<td>생성자아이디</td>
			<td>생성자이름</td>
			<td>수정일</td>
			<td>수정자아이디</td>
			<td>수정자이름</td>
			<td>부모코드</td>
			<td>부모이름</td>
		</tr>
<%
	for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getCateCode() %></td>
			<td><%=list.get(i).getCateName() %></td>
			<td><%=list.get(i).getCateStatus() %></td>
			<td><%=list.get(i).getCreatedDate() %></td>
			<td><%=list.get(i).getCreatedUserId() %></td>
			<td><%=list.get(i).getCreatedUserName() %></td>
			<td><%=list.get(i).getModifiedUserId() %></td>
			<td><%=list.get(i).getModifiedUserName() %></td>
			<td><%=list.get(i).getModifiedDate() %></td>
			<td><%=list.get(i).getPCateCode() %></td>
			<td><%=list.get(i).getPCateName() %></td>
		</tr>
<%
	}
%>
	</table>
</body>
</html>