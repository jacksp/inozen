<%@ tag pageEncoding="euc-kr" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="type" required="true" %>

<div id="title">
	<h1>${title}</h1>
</div>
		
<jsp:doBody />
		
<div id="" class="ifrmbox40">
	<iframe id="tree" name="tree" src="/common/tree/tree.do?type=${type}" height="300" scrolling="auto" frameborder="0" width="100%">
	</iframe>
</div>
<div id="" class="ifrmbox60">
	<iframe id="maingrid" name="maingrid" src="list.do" height="300" scrolling="auto" frameborder="0" width="100%">
	</iframe>
</div>