<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>

<script>
	var searchHandler = function(){
		$("searchform").submit();	
	}
</script>

<o:button clickhandler="searchHandler" text="°Ë»ö" id="searchbtn" styleclass="searchbtn" />