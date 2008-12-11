<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/admin/include/popupheader.jsp" %>

<div id="title">
	<h1>게시판 등록</h1>
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

	<a href="javascript:void(1)" id="savebtn" class="savebtn">저장</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">취소</a>
	
	<script type="text/javascript"> 
		Event.observe("savebtn", "click", saveHandler, false);
	
		Event.observe("cancelbtn", "click", cancelHandler, false);	
	</script>
</div>
<div id="formbox">
	<form id="form" action="/admin/board/saveBoard.do" method="post">
		<div class="formblock">
		<p id="namerow">
			<label>게시판 이름 :</label>
			<input id="boardName" name="boardName" type="text" value="" size="10" maxlength="15"/>&nbsp;
			<input id="cateName" name="cateName" type="hidden" value="${category.cateName}" />
			<input id="cateCode" name="cateCode" type="hidden" value="${category.cateCode}" />
		</p>
		<p id="namerow">
			<label>카테고리 : </label> <c:out value="${category.cateName}" default="선택된 카테고리가 없습니다."/>
		</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>