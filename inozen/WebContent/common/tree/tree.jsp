<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="com.inozen.app.common.tree.domain.Tree" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	
	List<Tree> list = (List<Tree>)request.getAttribute("list");
	String target = (String)request.getParameter("target");
	String src = (String)request.getParameter("src");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function setRight(nodeid) {
		parent.<%=target%>.location.href="<%=src%>?type=1&code="+nodeid;
	}
</script>
<body>

<%
	for(int i=0; i<list.size(); i++) {
		for(int j=0; j<list.get(i).getLevel(); j++) out.print("&nbsp;=>");
		if(list.get(i).isLeaf())
			out.print(list.get(i).getName());
		else
			out.print("<a href='javascript:setRight("+list.get(i).getNodeId()+")'>"+list.get(i).getName()+"</a>");
		out.print("<br>");
		
	}
%>

</body>
</html>