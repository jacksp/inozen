<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/admin/include/popupheader.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="title">
	<h1>ī�װ� ���</h1>
</div>
<div id="buttons">

	<script>
		var saveHandler = function() {
			$("form").submit();
		}
	
		var cancelHandler = function() {
			window.close();
		}
	</script>	

	<a href="javascript:void(1)" id="savebtn" class="savebtn">����</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">���</a>
	
	<script type="text/javascript"> 
		Event.observe("savebtn", "click", saveHandler, false);
	
		Event.observe("cancelbtn", "click", cancelHandler, false);	
	</script>
</div>
<div id="formbox">
	<form id="form" action="/admin/category/saveCategory.do" method="post">
		<div class="formblock">
		<p id="cateNamerow">
			<label>ī�װ� �̸� :</label>
			<input id="cateName" name="cateName" type="text" value="" size="10" maxlength="15"/>
			<form:errors path="cateName" cssClass="error" />
			<input id="pCateName" name="pCateName" type="hidden" value="${model.cateName}" />
			<input id="pCateCode" name="pCateCode" type="hidden" value="${model.cateCode}" />
		</p>
		<p id="namerow">
			<label>���� ī�װ� : </label> <c:out value="${model.cateName}" default="���õ� ���� ī�װ��� �����ϴ�."/>
		</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>