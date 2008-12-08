<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ taglib prefix="a" tagdir="/WEB-INF/tags/inozen/admin" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ include file="/admin/include/searchheader.jsp" %>


<o:searchbuttons popupheight="400" popupwidth="700" />

<o:searchform action="search.do">
	<o:searchrow>
		<o:stext path="cateName" label="이름" size="20" maxlength="30" />
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
		<d:column property="cateName" title="이름" />
		<d:column property="cateStatus" title="상태" />
		<d:column property="createdDate" title="생성일" />
		<d:column property="createdUserId" title="생성자아이디" />
		<d:column property="createdUserName" title="생성자이름" />
		<d:column property="modifiedDate" title="수정일" />
		<d:column property="modifiedUserId" title="수정자아이디" />
		<d:column property="modifiedUserName" title="수정자이름" />
		<d:column property="pCateCode" title="상위카테고리코드" />
		<d:column property="pCateName" title="상위카테고리이름" />
	</d:table>
</o:gridpage>

<%@ include file="/admin/include/searchfooter.jsp" %>