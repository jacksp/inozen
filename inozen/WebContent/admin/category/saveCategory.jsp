<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/admin/include/popupheader.jsp" %>

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
	<form id="form" action="/admin/category/saveCategory.do?gridid=maingrid" method="post">
	<input type="hidden" name="pCateName" value="${model.cateName}"/>
	<input type="hidden" name="pCateCode" value="${model.cateCode}"/>
		<div class="formblock">
		<p id="namerow">
			<label>ī�װ� �̸� :</label>
			<input id="name" name="cateName" type="text" value="" size="10" maxlength="15"/>&nbsp;
		</p>
		<p id="namerow">
			<label>���� ī�װ� : </label> <c:out value="${model.cateName}" default="���õ� ���� ī�װ��� �����ϴ�."/>
		</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>