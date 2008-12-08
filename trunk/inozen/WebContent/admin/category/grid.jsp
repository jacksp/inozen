<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ include file="/admin/include/gridheader.jsp" %>

<o:gridpage popupheight="400" popupwidth="700" >
<c:set var="startNumValue" value="${startNum}" />

	<d:table name="list" class="maingrid" id="maingrid">
		<d:column title="No">
			<a href="javascript:sendToUpdate(<c:out value="${maingrid.cateCode}" />)">
				${startNumValue}
			</a>
<c:set var="startNumValue" value="${startNumValue + 1}" />
		</d:column>
		<d:column property="cateName" title="�̸�" />
		<d:column property="cateStatus" title="����" />
		<d:column property="createdDate" title="������" />
		<d:column property="createdUserId" title="�����ھ��̵�" />
		<d:column property="createdUserName" title="�������̸�" />
		<d:column property="modifiedDate" title="������" />
		<d:column property="modifiedUserId" title="�����ھ��̵�" />
		<d:column property="modifiedUserName" title="�������̸�" />
		<d:column property="pCateCode" title="����ī�װ��ڵ�" />
		<d:column property="pCateName" title="����ī�װ��̸�" />
	</d:table>
</o:gridpage>

<%@ include file="/admin/include/gridfooter.jsp" %>