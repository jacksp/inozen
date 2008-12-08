<%@ tag pageEncoding="euc-kr" %>
<%@ attribute name="title" required="true" %>

<div id="title">
	<h1>${title}</h1>
</div>
		
<jsp:doBody />
		
<div id="" class="ifrmbox2">
	<iframe id="tree" name="tree" src="/common/tree/tree.do?type=${type}" height="300" scrolling="auto" frameborder="1" width="100%">
	</iframe>
</div>
<div id="" class="ifrmbox2">
	<iframe id="maingrid" name="maingrid" src="grid.do" height="300" scrolling="auto" frameborder="1" width="100%">
	</iframe>
</div>