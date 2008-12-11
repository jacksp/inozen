<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.inozen.app.model.Board" %>
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
	var cateCode = "<%=cateCode%>";
	function addBoard () {
		if(cateCode==""||cateCode=="null") {
			alert("카테고리를 선택하세요.");
			return;
		}
		popup("saveBoard.do?cateCode="+cateCode, "popup", 700, 400, "yes", "yes");
	}

	function searchBoard () {
		document.forms.searchform.method="POST";
		document.forms.searchform.action="boardList.do";
		document.forms.searchform.submit();
	}

</script>
<%-- ===================================================================================== --%>
<%--                               Button Anchor                                           --%>
<%-- ===================================================================================== --%>
<a href="javascript:void(1)" onClick="searchBoard()" id="searchbtn" class="searchbtn">검색</a>
<a href="javascript:void(1)" onclick="addBoard()" id="addbtn" class="addbtn">추가</a>
</div>

<form id="searchform" method="get">
	<label>이름 :</label>
	<input id="name" name="cateName" type="text" size="20" maxlength="30" value="" />
</form>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
%>
	<table border="1">
		<tr>
			<td>게시판코드</td>
			<td>게시판이름</td>
			<td>게시판순서</td>
			<td>게시판상태</td>
			<td>게시판종류</td>
			<td>생성일</td>
			<td>생성자아이디</td>
			<td>생성자이름</td>
			<td>수정일</td>
			<td>수정자아이디</td>
			<td>수정자이름</td>
			<td>카테고리코드</td>
		</tr>
<%
	if(list!=null) {
		for(int i=0; i<list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getBoardCode() %></td>
			<td><%=list.get(i).getBoardName() %></td>
			<td><%=list.get(i).getBoardOrder() %></td>
			<td><%=list.get(i).getBoardStatus() %></td>
			<td><%=list.get(i).getBoardType() %></td>
			<td><%=list.get(i).getCreatedDate() %></td>
			<td><%=list.get(i).getCreatedUserId() %></td>
			<td><%=list.get(i).getCreatedUserName() %></td>
			<td><%=list.get(i).getModifiedDate() %></td>
			<td><%=list.get(i).getModifiedUserId() %></td>
			<td><%=list.get(i).getModifiedUserName() %></td>
			<td><%=list.get(i).getCategory().getCateCode()%></td>
		</tr>
<%
		}
	}
%>
		<tr>
			<td colspan="12"><font color="red"><%=message %></font></td>
		</tr>
	</table>
</body>
</html>