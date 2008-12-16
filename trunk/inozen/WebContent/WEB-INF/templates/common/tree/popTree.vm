<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="com.inozen.app.common.tree.domain.Tree" %>
<%
	//var param = "?type=1&target=opener&kind=popup&form=form&name=cateName&value=menuRelatedCode";
	List<Tree> list = (List<Tree>)request.getAttribute("list");
	String target = (String)request.getParameter("target");
	String src = (String)request.getParameter("src");
	String kind = (String)request.getParameter("kind");
	String form = (String)request.getParameter("form");
	String name = (String)request.getParameter("name");
	String value = (String)request.getParameter("value");
	String retval = (String)request.getParameter("retval");
%>
<%@ include file="/include/popupheader.jsp" %>
<script type="text/javascript" language="javascript">

	function setValue(name, value) {
		<%=target%>.$('<%=name%>').value = name;
		alert(<%=target%>.$('<%=name%>').value);
		<%=target%>.$('<%=value%>').value = value;
		alert(<%=target%>.$('<%=value%>').value);
		window.close();

	}
</script>

<%
	for(int i=0; i<list.size(); i++) {
		for(int j=0; j<list.get(i).getLevel(); j++) out.print("&nbsp;=>");
		if(list.get(i).isLeaf())
			out.print(list.get(i).getName());
		else {
			out.print("<a href=\"javascript:setValue('"+list.get(i).getName()+"','"+list.get(i).getNodeId()+"')\">"+list.get(i).getName()+"</a>");
		}
		
		out.print("<br>");
		
	}
%>
<%@ include file="/include/popupfooter.jsp" %>