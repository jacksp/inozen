<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="maxlength" required="true" %>
<%@ attribute name="desc" required="false" %>

<o:felement type="text" label="${label}" path="${path}" maxlength="${maxlength}" size="${size}" desc="${desc}" />