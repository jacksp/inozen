<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>

<script>
var saveHandler = function() {
	$("form").submit();
}
</script>

<o:button clickhandler="saveHandler" text="ÀúÀå" id="savebtn" styleclass="savebtn" />