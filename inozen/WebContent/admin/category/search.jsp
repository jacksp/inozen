<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ taglib prefix="a" tagdir="/WEB-INF/tags/inozen/admin" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ include file="/admin/include/searchheader.jsp" %>


<o:searchbuttons popupheight="400" popupwidth="700" />

<o:searchform action="search.do">
	<o:searchrow>
		<o:stext path="cateName" label="�̸�" size="20" maxlength="30" />
	</o:searchrow>
</o:searchform>

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

<%@ include file="/admin/include/searchfooter.jsp" %>