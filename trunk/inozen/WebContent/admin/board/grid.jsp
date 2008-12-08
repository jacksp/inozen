<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ include file="/admin/include/gridheader.jsp" %>

<o:gridpage popupheight="400" popupwidth="700" >
<c:set var="startNumValue" value="${startNum}" />

	<d:table name="list" class="maingrid" id="maingrid">
		<d:column title="No">
			<a href="javascript:sendToUpdate(<c:out value="${maingrid.id}" />)">
				${startNumValue}
			</a>
<c:set var="startNumValue" value="${startNumValue + 1}" />
		</d:column>
		<d:column property="name" title="�̸�" />
		<d:column property="loginId" title="���̵�" />
		<d:column property="sex" title="����" decorator="com.inozen.app.model.enumeration.SexType" />
		<d:column property="location" title="��°�" />
		<d:column property="birthday" title="����" />
		<d:column property="hobbies" title="���" />
	</d:table>
</o:gridpage>

<%@ include file="/admin/include/gridfooter.jsp" %>