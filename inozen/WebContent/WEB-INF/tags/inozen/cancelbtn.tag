<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>

<script>
var cancelHandler = function() {
	window.close();
}
</script>

<o:button clickhandler="cancelHandler" text="���" id="cancelbtn" styleclass="cancelbtn" />

