<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.model.HtmlPage" %>
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
	String cateCode = (String)request.getAttribute("code");
	String message = (String)request.getAttribute("message");
%>
<body>

<div id="buttons">
<script type="text/javascript">
	function addHtml () {
		popup("saveHtml.do", "popup", 700, 400, "yes", "yes");
	}

	function searchHtml () {
		alert(1);
		document.forms.searchform.method="POST";
		document.forms.searchform.action="htmlList.do";
		document.forms.searchform.submit();
	}

</script>
<%-- ===================================================================================== --%>
<%--                               Button Anchor                                           --%>
<%-- ===================================================================================== --%>
<a href="javascript:void(1)" onClick="searchHtml()" id="searchbtn" class="searchbtn">검색</a>
<a href="javascript:void(1)" onclick="addHtml()" id="addbtn" class="addbtn">추가</a>
</div>

<form id="searchform" method="get">
	<label>이름 :</label>
	<input id="name" name="pageName" type="text" size="20" maxlength="30" value="" />
</form>
<%
	List<HtmlPage> list = (List<HtmlPage>)request.getAttribute("list");
%>
	<table border="1">
		<tr>
			<td>페이지코드</td>
			<td>페이지이름</td>
			<td>페이지경로</td>
			<td>페이지상태</td>
			<td>생성일</td>
			<td>생성자아이디</td>
			<td>생성자이름</td>
			<td>수정일</td>
			<td>수정자아이디</td>
			<td>수정자이름</td>
		</tr>
<%
	if(list!=null) {
		for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getPageCode() %></td>
			<td><%=list.get(i).getPageName() %></td>
			<td><%=list.get(i).getPageLocation() %></td>
			<td><%=list.get(i).getPageStatus() %></td>
			<td><%=list.get(i).getCreatedDate() %></td>
			<td><%=list.get(i).getCreatedUserID() %></td>
			<td><%=list.get(i).getCreatedUserName() %></td>
			<td><%=list.get(i).getModifiedDate() %></td>
			<td><%=list.get(i).getModifiedUserID() %></td>
			<td><%=list.get(i).getModifiedUserName() %></td>
		</tr>
<%
		}
	}
%>
		<tr>
			<td colspan="10"><font color="red"><%=message %></font></td>
		</tr>
	</table>
</body>
</html>